package com.example.kakao_pay.src.main.moreviewpage.setting.dialogs

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.login.LoginMainActivity

class DialogLogout : DialogFragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_logout, container, false)
        dialog?.window?.setBackgroundDrawable((ColorDrawable(Color.TRANSPARENT)))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        isCancelable = false

        return view.rootView
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply{
            findViewById<TextView>(R.id.btn_logout_cancel).setOnClickListener {
                dismiss()
            }
            findViewById<TextView>(R.id.btn_logout_check).setOnClickListener {
                val edit = ApplicationClass.sSharedPreferences.edit()
                edit.remove(ApplicationClass.X_ACCESS_TOKEN)
                edit.apply()
                activity?.finishAffinity()
                startActivity(Intent(context, LoginMainActivity::class.java))
                dismiss()
            }
        }
    }
}