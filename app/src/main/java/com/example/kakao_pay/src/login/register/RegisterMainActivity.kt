package com.example.kakao_pay.src.login.register

import android.content.Intent
import android.os.Bundle
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityRegisterBinding
import com.example.kakao_pay.src.login.LoginActivity

class RegisterMainActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.daumId.paint?.isUnderlineText = true

        binding.registerBtnFir.setOnClickListener {
            startActivity(Intent(this, RegisterEmailActivity::class.java))
        }
        binding.registerBtnSec.setOnClickListener {
            startActivity(Intent(this, RegisterPhoneActivity::class.java))
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}