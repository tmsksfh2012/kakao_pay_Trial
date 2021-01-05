package com.example.kakao_pay.src.login.register

import android.content.Intent
import android.os.Bundle
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityRegisterEmailBinding
import com.example.kakao_pay.src.login.register.email_input.RegisterInputEmailActivity

class RegisterEmailActivity : BaseActivity<ActivityRegisterEmailBinding>(ActivityRegisterEmailBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnAgree.setOnClickListener {
            startActivity(Intent(this, RegisterInputEmailActivity::class.java))
        }
    }
}