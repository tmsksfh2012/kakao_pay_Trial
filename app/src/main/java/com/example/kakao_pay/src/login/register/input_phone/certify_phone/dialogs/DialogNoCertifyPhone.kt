package com.example.kakao_pay.src.login.register.input_phone.certify_phone.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R
import com.example.kakao_pay.src.login.register.input_phone.certify_phone.RegisterCertifyPhoneActivity
import com.example.kakao_pay.src.utils.putUserSelectPosition

class DialogNoCertifyPhone : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.dialog_no_phone, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply {
            val myActivity = activity as RegisterCertifyPhoneActivity
            findViewById<Button>(R.id.btn_again_post_phone).setOnClickListener {
                dismiss()
                putUserSelectPosition(1)
                myActivity.onDetached()
            }
            findViewById<ImageView>(R.id.no_phone_clear).setOnClickListener {
                dismiss()
            }
            findViewById<Button>(R.id.btn_other_phone).setOnClickListener {
                dismiss()
                putUserSelectPosition(2)
                myActivity.onDetached()
            }
        }
    }
}