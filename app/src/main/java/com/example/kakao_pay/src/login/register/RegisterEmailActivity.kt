package com.example.kakao_pay.src.login.register

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityRegisterEmailBinding

class RegisterEmailActivity : BaseActivity<ActivityRegisterEmailBinding>(ActivityRegisterEmailBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnAgree.setOnClickListener {
            showLoadingDialog(this)
            startActivity(Intent(this, RegisterEmailInputActivity::class.java))
        }
    }
}