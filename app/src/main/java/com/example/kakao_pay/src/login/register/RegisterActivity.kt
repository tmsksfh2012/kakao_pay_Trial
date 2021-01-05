package com.example.kakao_pay.src.login.register

import android.content.Intent
import android.os.Bundle
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.registerBtnFir.setOnClickListener {
            startActivity(Intent(this, RegisterEmailActivity::class.java))
        }
    }
}