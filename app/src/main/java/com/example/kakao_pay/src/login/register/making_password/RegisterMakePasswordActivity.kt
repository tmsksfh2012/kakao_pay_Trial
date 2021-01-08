package com.example.kakao_pay.src.login.register.making_password

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityMakingPasswordBinding
import com.example.kakao_pay.src.login.LoginActivity
import com.example.kakao_pay.src.login.register.making_password.dialogs.DialogErrPasswordType
import com.example.kakao_pay.src.login.register.making_profile.RegisterMakeProfileActivity
import com.example.kakao_pay.src.utils.onMyTextChanged
import com.example.kakao_pay.src.utils.Constants.TAG

class RegisterMakePasswordActivity : BaseActivity<ActivityMakingPasswordBinding>(ActivityMakingPasswordBinding::inflate) {
    lateinit var email : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        email = intent.extras?.getString("email").toString()
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

        if(binding.editEmail.isFocused) {
            binding.editEmail.onMyTextChanged {
                if (it.toString().count() == 8) {
                    binding.editEmail.setBackgroundResource(R.drawable.inputbox_selector)
                    Log.d(TAG, "EDITTEXT: " + it.toString())
                } else if (it.toString().count() >= 8) {
                    if (it.toString() == binding.editEmail.toString()) {
                        binding.editCertifyPassword.setBackgroundResource(R.drawable.inputbox_selector)
                        binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                        binding.btnNext.setTextColor(ContextCompat.getColor(this, R.color.black))
                    }
                } else if (it.toString().count() < 8) {
                    binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                    binding.btnNext.setTextColor(ContextCompat.getColor(this, R.color.grayText))
                }
            }
        }

        else if(binding.editCertifyPassword.isFocused) {
            binding.editCertifyPassword.onMyTextChanged {
                if (it.toString().count() == binding.editEmail.toString().length) {
                    Log.d(TAG, "EDITTEXT: " + it.toString())
                    Log.d(TAG, "EDITTEXT: " + binding.editCertifyPassword.toString())
                    if (it.toString() == binding.editEmail.toString()) {
                        Log.d(TAG, "EDITTEXT: " + it.toString())
                        Log.d(TAG, "EDITTEXT: " + binding.editCertifyPassword.toString())

                        binding.editCertifyPassword.setBackgroundResource(R.drawable.inputbox_selector)
                        binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                        binding.btnNext.setTextColor(ContextCompat.getColor(this, R.color.black))
                    }
                } else if (it.toString().count() != binding.editEmail.toString().count()) {
                    binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                    binding.btnNext.setTextColor(ContextCompat.getColor(this, R.color.grayText))
                }
            }
        }

        binding.btnNext.setOnClickListener {
            val reg = Regex("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{8,32}.$")

            if(binding.editCertifyPassword.text.toString() != binding.editEmail.text.toString()){
                showCustomToast("비밀번호가 일치하지 않습니다.")
                binding.editCertifyPassword.setBackgroundResource(R.drawable.inputbox_err)
//                if(32 > binding.editEmail.text.toString().length > 8){
//                    showCustomToast("비밀번호가 일치하지 않습니다.")
            }
            else if( !binding.editEmail.text.toString().matches(reg) ) {

                if( binding.editEmail.text.toString().count() > 32 || binding.editEmail.text.toString().count() < 8) {
                    showCustomToast("비밀번호는 8 ~ 32자리(영문자/숫자/특수문자)로 입력할 수 있어요.")
                    binding.editEmail.setBackgroundResource(R.drawable.inputbox_err)
                }
                else {
                    val mRegexErr = DialogErrPasswordType()

                    binding.editCertifyPassword.text.clear()
                    binding.editEmail.text.clear()

                    mRegexErr.show(supportFragmentManager, mRegexErr.tag)
                }
            }
            else {
                finish()
                startActivity(Intent(this, RegisterMakeProfileActivity::class.java)
                    .putExtra("password", binding.editEmail.text.toString())
                    .putExtra("email", email))
                // 프로필 설정창으로 이동
            }
        }
    }
}