package com.example.kakao_pay.src.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityLoginBinding
import com.example.kakao_pay.src.login.login_manager.DialogLoginManager
import com.example.kakao_pay.src.login.register.RegisterActivity

class LoginActivity:BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var  mLoginManagerDialog = DialogLoginManager()

        binding.btnLoginManager.paint?.isUnderlineText = true

        binding.btnLoginManager.setOnClickListener {
            mLoginManagerDialog.show(supportFragmentManager, mLoginManagerDialog.tag)
        }
        binding.btnRegister.setOnClickListener {
            showLoadingDialog(this)
            Handler(Looper.getMainLooper()).postDelayed({
                dismissLoadingDialog()
                startActivity(Intent(this, RegisterActivity::class.java))
            },500)
        }
    }
}