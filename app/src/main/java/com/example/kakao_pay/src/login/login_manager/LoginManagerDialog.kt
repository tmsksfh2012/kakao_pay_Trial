package com.example.kakao_pay.src.login.login_manager

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R
import com.example.kakao_pay.databinding.DialogLoginManagerBinding

class LoginManagerDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.dialog_login_manager, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply{
            findViewById<Button>(R.id.login_manager_btn_fir).setOnClickListener {
                // 이메일, 전화번호를 모르겠어요! 의 다음 페이지로 이동
            }
            findViewById<Button>(R.id.login_manager_btn_sec).setOnClickListener {
                // 비밀번호를 모르겠어요! 의 다음 페이지로 이동
            }
            findViewById<ImageView>(R.id.login_manager_clear).setOnClickListener {
                dismiss()
            }
        }
    }
}