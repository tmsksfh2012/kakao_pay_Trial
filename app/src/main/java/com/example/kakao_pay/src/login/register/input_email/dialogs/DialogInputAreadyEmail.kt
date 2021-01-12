package com.example.kakao_pay.src.login.register.input_email.dialogs

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

class DialogInputAreadyEmail : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.dialog_input_email_err_1, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply {
            findViewById<Button>(R.id.btn_err_login).setOnClickListener {
                dismiss()
                activity?.finish()
                startActivity(Intent(context, LoginActivity::class.java))
            }
            findViewById<Button>(R.id.btn_err_retry).setOnClickListener {
                dismiss()
            }
            findViewById<ImageView>(R.id.img_same_email_clear).setOnClickListener {
                dismiss()
            }
        }
    }
}