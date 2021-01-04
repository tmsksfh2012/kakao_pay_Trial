package com.example.kakao_pay.src.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityLoginMainBinding

class LoginMainActivity:BaseActivity<ActivityLoginMainBinding>(ActivityLoginMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.moreViewBtnLogin.setOnClickListener {
            showLoadingDialog(this)
            Handler(Looper.getMainLooper()).postDelayed({
                dismissLoadingDialog()
                startActivity(Intent(this, LoginActivity::class.java))
            },500)
        }
    }
}