package com.example.kakao_pay.src.login.register.email_input.email_certify

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityCertifyEmailBinding
import com.example.kakao_pay.src.login.register.email_input.RegisterInputEmailService
import com.example.kakao_pay.src.login.register.email_input.RegisterInputEmailView
import com.example.kakao_pay.src.login.register.email_input.email_certify.dialogs.DialogErrAuthNum
import com.example.kakao_pay.src.login.register.email_input.email_certify.dialogs.DialogNoCertifyEmail
import com.example.kakao_pay.src.login.register.email_input.email_certify.models.GetEmailRequest
import com.example.kakao_pay.src.login.register.email_input.email_certify.models.GetEmailResponse
import com.example.kakao_pay.src.login.register.email_input.models.PostEmailRequest
import com.example.kakao_pay.src.login.register.email_input.models.PostEmailResponse
import com.example.kakao_pay.src.login.register.making_password.RegisterMakePasswordActivity
import com.example.kakao_pay.src.utils.getUserSelectPosition
import com.example.kakao_pay.src.utils.onMyTextChanged

class RegisterCertifyEmailActivity : BaseActivity<ActivityCertifyEmailBinding>(ActivityCertifyEmailBinding::inflate),
RegisterCertifyEmailView, RegisterInputEmailView{
    lateinit var email : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val noCertifyEmail = DialogNoCertifyEmail()

        binding.noMail.paint?.isUnderlineText = true
        email = intent.extras?.getString("email").toString()
        binding.editEmail.text =  Editable.Factory.getInstance().newEditable(email)
        binding.editEmail.setTextColor(Color.parseColor("#757575"))
        binding.editEmail.isClickable = false
        binding.editEmail.isFocusable = false
        binding.editEmail.setOnTouchListener { v, event -> false }

        binding.noMail.setOnClickListener {

            noCertifyEmail.show(supportFragmentManager, noCertifyEmail.tag)
        }

        if(noCertifyEmail.isRemoving) {
            val position = getUserSelectPosition()
            if(position == 1) {
                val postEmail = PostEmailRequest(email = email)
                showLoadingDialog(this)
                RegisterInputEmailService(this).tryPostEmail(postEmail)
            }
            else if(position == 2){
                finish()
            }
        }

        binding.back.setOnClickListener {
            finish()
        }

        binding.editCertifyNumber.onMyTextChanged {
            if(it.toString().count() == 0 ) {
                binding.btnEmailSend.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                binding.btnEmailSend.setTextColor(ContextCompat.getColor(this, R.color.grayText))
                binding.editCertifyNumber.setBackgroundResource(R.drawable.inputbox_selector)
            }
            else if(it.toString().count() == 8) {
                binding.btnEmailSend.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                binding.btnEmailSend.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
            else if(it.toString().count() > 8) {
                binding.editCertifyNumber.setText(binding.editCertifyNumber.text.substring(0, binding.editCertifyNumber.text.toString().length-1))
            }
            else if(it.toString().count() > 0) {
                binding.editCertifyNumber.setBackgroundResource(R.drawable.inputbox_selector)
            }
        }
        binding.btnEmailSend.setOnClickListener {
            val number = binding.editCertifyNumber.text.toString()
            val getRequest = GetEmailRequest(email = email, authNum = number)

            if( number.count() == 0 ) {
                showCustomToast("이메일로 발송된 8자리 인증번호를 입력해주세요.")
                binding.editCertifyNumber.setBackgroundResource(R.drawable.inputbox_err)
            }
            else if(number.count() in 1..7) {
                showCustomToast("입력하신 인증번호가 올바르지 않습니다. 다시 확인해주세요.")
                binding.editCertifyNumber.setBackgroundResource(R.drawable.inputbox_err)
            }
            else {
                showLoadingDialog(this)
                RegisterCertifyEmailService(this).tryGetEmail(getRequest)
            }
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

    override fun onPostEmailSuccess(response: PostEmailResponse) {
        dismissLoadingDialog()
    }

    override fun onPostEmailFailure(message: String) {
    }

}