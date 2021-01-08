package com.example.kakao_pay.src.login.register.making_profile.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R

class DialogBirthErr : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.dialog_err_birth, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply{
            findViewById<ImageView>(R.id.birth_err_clear).setOnClickListener {
                dismiss()
            }

            findViewById<Button>(R.id.btn_birth_retry).setOnClickListener {
                dismiss()
            }
        }
    }
}