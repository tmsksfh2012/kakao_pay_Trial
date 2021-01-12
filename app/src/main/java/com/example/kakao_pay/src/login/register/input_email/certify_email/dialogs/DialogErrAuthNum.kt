package com.example.kakao_pay.src.login.register.input_email.certify_email.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R

class DialogErrAuthNum  : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.dialog_err_auth_num, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply {
            findViewById<Button>(R.id.btn_err_authNum).setOnClickListener {
                dismiss()
            }
            findViewById<ImageView>(R.id.err_authNum_clear).setOnClickListener {
                dismiss()
            }
        }
    }
}