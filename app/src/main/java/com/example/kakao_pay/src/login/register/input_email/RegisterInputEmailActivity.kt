package com.example.kakao_pay.src.login.register.input_email

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityInputEmailBinding
import com.example.kakao_pay.src.login.register.input_email.dialogs.DialogInputAreadyEmail
import com.example.kakao_pay.src.login.register.input_email.certify_email.RegisterCertifyEmailActivity
import com.example.kakao_pay.src.login.register.input_email.models.PostEmailRequest
import com.example.kakao_pay.src.login.register.input_email.models.PostEmailResponse
import com.example.kakao_pay.src.utils.OnMyTextChanged

class RegisterInputEmailActivity : BaseActivity<ActivityInputEmailBinding>(ActivityInputEmailBinding::inflate),
    IRegisterInputEmailView, OnMyTextChanged{
    val reg = Regex("[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}")

    private lateinit var email :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.back.setOnClickListener {
            finish()
        }

        binding.editEmail.onMyTextChanged {}

        binding.btnEmailSend.setOnClickListener {
            email = binding.editEmail.text.toString()
            if(email == "") {
                showCustomToast("이메일을 입력해주십시오")
                binding.editEmail.setBackgroundResource(R.drawable.inputbox_err)
            }
            else if(email.length > 30) {
                showCustomToast("이메일은 30자리 미만으로 입력해주세요.")
                binding.editEmail.setBackgroundResource(R.drawable.inputbox_err)
            }
            else if(!email.matches(reg)) {
                showCustomToast("올바르지 않은 이메일 형식입니다.")
                binding.editEmail.setBackgroundResource(R.drawable.inputbox_err)
            }
            else {
                val postEmail = PostEmailRequest(email = email)
                showLoadingDialog(this)
                RegisterInputEmailService(this).tryPostEmail(postEmail)
            }
        }
    }

    override fun onPostEmailSuccess(response: PostEmailResponse) {
        dismissLoadingDialog()
        when(response.code){
            1000 -> {
                binding.editEmail.text.clear()
                startActivity(Intent(this, RegisterCertifyEmailActivity::class.java).putExtra("email",email))
            }
            2001 -> {

            }
            2002 -> {

            }
            2003 -> {
                showCustomToast("이메일 형식 오류")
            }
            3001 -> {
                val mErrDialog =
                    DialogInputAreadyEmail()
                mErrDialog.show(supportFragmentManager, mErrDialog.tag)
            }
        }
    }

    override fun onPostEmailFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun EditText.onMyTextChanged(completion: (Editable?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.editEmail.isFocused) {
                    if (binding.editEmail.text.toString().matches(reg)) {
                        binding.btnEmailSend.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                        binding.btnEmailSend.setTextColor(ContextCompat.getColor(context, R.color.black))
                    } else {
                        binding.btnEmailSend.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                        binding.btnEmailSend.setTextColor(ContextCompat.getColor(context, R.color.grayText))
                        binding.editEmail.setBackgroundResource(R.drawable.inputbox_selector)
                    }
                }
            }
        })
    }
}