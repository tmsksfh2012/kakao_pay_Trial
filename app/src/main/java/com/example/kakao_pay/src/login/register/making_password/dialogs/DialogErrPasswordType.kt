package com.example.kakao_pay.src.login.register.making_password.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R

class DialogErrPasswordType : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.dialog_err_password, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply{
            findViewById<ImageView>(R.id.password_err_clear).setOnClickListener {
                dismiss()
            }
            findViewById<Button>(R.id.btn_password_retry).setOnClickListener {
                dismiss()
            }
        }
    }
}