package com.example.kakao_pay.src.login.register.making_password

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityMakingPasswordBinding
import com.example.kakao_pay.src.login.LoginActivity
import com.example.kakao_pay.src.login.register.making_password.dialogs.DialogErrPasswordType
import com.example.kakao_pay.src.login.register.making_profile.RegisterMakeProfileActivity
import com.example.kakao_pay.src.utils.OnMyTextChanged

class RegisterMakePasswordActivity : BaseActivity<ActivityMakingPasswordBinding>(ActivityMakingPasswordBinding::inflate),
    OnMyTextChanged{
    lateinit var email : String
    var phone : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        email = intent.extras?.getString("email")!!
        phone = intent.extras?.getString("phone")

        binding.mainEmail.isClickable = false
        binding.mainEmail.isFocusable = false
        binding.mainEmail.setTextColor(Color.parseColor("#757575"))
        binding.mainEmail.setOnTouchListener { v, event -> false }
        binding.mainEmail.text = Editable.Factory.getInstance().newEditable(email)

        binding.passwordBack.setOnClickListener {
            ActivityCompat.finishAffinity(this)
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // 수정 필요
            binding.editPassword.onMyTextChanged {}
            binding.editCertifyPassword.onMyTextChanged {}

        binding.btnNext.setOnClickListener {
            val reg = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{8,32}.$")

            if(binding.editCertifyPassword.text.toString() != binding.editPassword.text.toString()){
                showCustomToast("비밀번호가 일치하지 않습니다.")
                binding.editCertifyPassword.setBackgroundResource(R.drawable.inputbox_err)
//                if(32 > binding.editEmail.text.toString().length > 8){
//                    showCustomToast("비밀번호가 일치하지 않습니다.")
            }
            else if( !binding.editPassword.text.toString().matches(reg) ) {

                if( binding.editPassword.text.toString().count() > 32 || binding.editPassword.text.toString().count() < 8) {
                    showCustomToast("비밀번호는 8 ~ 32자리(영문자/숫자/특수문자)로 입력할 수 있어요.")
                    binding.editPassword.setBackgroundResource(R.drawable.inputbox_err)
                }
                else {
                    val mRegexErr = DialogErrPasswordType()

                    binding.editCertifyPassword.text.clear()
                    binding.editPassword.text.clear()

                    mRegexErr.show(supportFragmentManager, mRegexErr.tag)
                }
            }
            else {
                // 프로필 설정창으로 이동
                startActivity(Intent(this, RegisterMakeProfileActivity::class.java)
                    .putExtra("password", binding.editPassword.text.toString())
                    .putExtra("email", email)
                    .putExtra("phone", phone))
            }
        }
    }

    override fun EditText.onMyTextChanged(completion: (Editable?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.editPassword.isFocused) {
                    if (binding.editPassword.text.toString().count() == 8) {
                        binding.editPassword.setBackgroundResource(R.drawable.inputbox_selector)
                        binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                        binding.btnNext.setTextColor(ContextCompat.getColor(context, R.color.black))
                    } else if (binding.editPassword.text.toString().count() < 8) {
                        binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                        binding.btnNext.setTextColor(ContextCompat.getColor(context, R.color.grayText))
                    }
                }
                else if(binding.editCertifyPassword.isFocused) {
                    if (binding.editCertifyPassword.text.toString().count() == binding.editPassword.text.toString().count()) {
                        if (binding.editCertifyPassword.text.toString() == binding.editPassword.text.toString()) {
                            binding.editCertifyPassword.setBackgroundResource(R.drawable.inputbox_selector)
                            binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                            binding.btnNext.setTextColor(ContextCompat.getColor(context, R.color.black))
                        }
                    } else if (binding.editCertifyPassword.text.toString().count() != binding.editPassword.text.toString().count()) {
                        binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                        binding.btnNext.setTextColor(ContextCompat.getColor(context, R.color.grayText))
                    }
                }
            }
        })
    }
}