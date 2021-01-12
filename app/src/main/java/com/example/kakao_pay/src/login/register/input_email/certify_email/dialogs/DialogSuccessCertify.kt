package com.example.kakao_pay.src.login.register.input_email.certify_email.dialogs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R
import com.example.kakao_pay.src.login.LoginActivity
import com.example.kakao_pay.src.login.register.input_phone.certify_phone.RegisterCertifyPhoneActivity
import com.example.kakao_pay.src.login.register.making_kakao.RegisterMakeKakaoActivity

class DialogSuccessCertify : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.dialog_success_phone, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply {
            val myActivity = activity as RegisterCertifyPhoneActivity
            findViewById<Button>(R.id.btn_kakao_login).setOnClickListener{
                dismiss()
                myActivity.finishAffinity()
                startActivity(Intent(myActivity, LoginActivity::class.java))
            }
            findViewById<Button>(R.id.btn_continue_register).setOnClickListener {
                dismiss()
                val phone = myActivity.getPhoneNum()
                myActivity.finishAffinity()
                startActivity(Intent(myActivity, RegisterMakeKakaoActivity::class.java).putExtra("phone",phone))
            }
            findViewById<ImageView>(R.id.success_phone_clear).setOnClickListener {
                dismiss()
            }
        }
    }
}