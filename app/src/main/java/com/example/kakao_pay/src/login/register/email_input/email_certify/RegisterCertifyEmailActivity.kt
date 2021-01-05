package com.example.kakao_pay.src.login.register.email_input.email_certify

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityCertifyEmailBinding
import com.example.kakao_pay.src.login.login_manager.DialogLoginManager
import com.example.kakao_pay.src.login.register.email_input.email_certify.dialogs.DialogErrAuthNum
import com.example.kakao_pay.src.login.register.email_input.email_certify.models.GetEmailRequest
import com.example.kakao_pay.src.login.register.email_input.email_certify.models.GetEmailResponse
import com.example.kakao_pay.src.login.register.making_password.RegisterMakePasswordActivity

class RegisterCertifyEmailActivity : BaseActivity<ActivityCertifyEmailBinding>(ActivityCertifyEmailBinding::inflate),
RegisterCertifyEmailView{
    lateinit var email : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        email = intent.extras?.getString("email").toString()
        binding.editEmail.text =  Editable.Factory.getInstance().newEditable(email)
        binding.editEmail.setTextColor(Color.parseColor("#757575"))
        binding.editEmail.isClickable = false
        binding.editEmail.isFocusable = false
        binding.editEmail.setOnTouchListener { v, event -> true }
        binding.btnEmailSend.setOnClickListener {
            val number = binding.editCertifyNumber.text.toString()
            val getRequest = GetEmailRequest(email = email, authNum = number)
            showLoadingDialog(this)
            RegisterCertifyEmailService(this).tryGetEmail(getRequest)
        }
    }

    override fun onGetEmailSuccess(response: GetEmailResponse) {
        dismissLoadingDialog()
        when(response.code){
            1000 ->{
                finish()
                startActivity(Intent(this, RegisterMakePasswordActivity::class.java).putExtra("email",email))
            }
            2001 ->{

            }
            2003 ->{

            }
            2004 ->{
                val mErrAuthNum = DialogErrAuthNum()
                mErrAuthNum.show(supportFragmentManager, mErrAuthNum.tag)
            }
        }
    }

    override fun onGetEmailFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}