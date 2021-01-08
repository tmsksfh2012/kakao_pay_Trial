package com.example.kakao_pay.src.login.register.email_input.email_certify.dialogs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R
import com.example.kakao_pay.src.login.register.email_input.RegisterInputEmailActivity
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
            findViewById<Button>(R.id.btn_again_post_mail).setOnClickListener {
                dismiss()
                putUserSelectPosition(1)
            }
            findViewById<ImageView>(R.id.no_mail_clear).setOnClickListener{
                dismiss()
            }
            findViewById<Button>(R.id.btn_other_mail).setOnClickListener {
                dismiss()
                putUserSelectPosition(2)
            }
        }
    }
}