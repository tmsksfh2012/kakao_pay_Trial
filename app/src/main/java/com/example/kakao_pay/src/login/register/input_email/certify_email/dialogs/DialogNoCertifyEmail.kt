package com.example.kakao_pay.src.login.register.input_email.certify_email.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R
import com.example.kakao_pay.src.login.register.input_email.certify_email.RegisterCertifyEmailActivity
import com.example.kakao_pay.src.utils.putUserSelectPosition

class DialogNoCertifyEmail : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.dialog_no_mail, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply {
            val myActivity = activity as RegisterCertifyEmailActivity
            findViewById<Button>(R.id.btn_again_post_mail).setOnClickListener {
                dismiss()
                putUserSelectPosition(1)
                myActivity.onDetached()
            }
            findViewById<ImageView>(R.id.no_mail_clear).setOnClickListener{
                dismiss()
            }
            findViewById<Button>(R.id.btn_other_mail).setOnClickListener {
                dismiss()
                putUserSelectPosition(2)
                myActivity.onDetached()
            }
        }
    }
}