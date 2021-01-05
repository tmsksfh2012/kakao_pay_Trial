package com.example.kakao_pay.src.login.register.email_input

import android.content.Intent
import android.os.Bundle
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityInputEmailBinding
import com.example.kakao_pay.src.login.register.email_input.email_certify.RegisterCertifyEmailActivity
import com.example.kakao_pay.src.login.register.email_input.models.PostEmailRequest
import com.example.kakao_pay.src.login.register.email_input.models.PostEmailResponse

class RegisterInputEmailActivity : BaseActivity<ActivityInputEmailBinding>(ActivityInputEmailBinding::inflate),
    RegisterInputEmailView{
    private lateinit var email :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnEmailSend.setOnClickListener {
            email = binding.editEmail.text.toString()
            val postEmail = PostEmailRequest(email = email)
            showLoadingDialog(this)
            RegisterInputEmailService(this).tryPostEmail(postEmail)
        }
    }

    override fun onPostEmailSuccess(response: PostEmailResponse) {
        dismissLoadingDialog()
        startActivity(Intent(this, RegisterCertifyEmailActivity::class.java).putExtra("email",email))
    }

    override fun onPostEmailFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}