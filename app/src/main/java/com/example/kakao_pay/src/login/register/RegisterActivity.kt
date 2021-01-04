package com.example.kakao_pay.src.login.register

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityRegisterBinding
import com.example.kakao_pay.src.login.LoginActivity

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.registerBtnFir.setOnClickListener {
            showLoadingDialog(this)
            startActivity(Intent(this, RegisterEmailActivity::class.java))
        }
    }
}