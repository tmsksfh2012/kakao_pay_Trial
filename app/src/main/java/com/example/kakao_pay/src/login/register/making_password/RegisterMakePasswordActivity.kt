package com.example.kakao_pay.src.login.register.making_password

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityMakingPasswordBinding

class RegisterMakePasswordActivity : BaseActivity<ActivityMakingPasswordBinding>(ActivityMakingPasswordBinding::inflate) {
    lateinit var email : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        email = intent.extras?.getString("email").toString()
        binding.mainEmail.isClickable = false
        binding.mainEmail.isFocusable = false
        binding.mainEmail.setTextColor(Color.parseColor("#757575"))
        binding.mainEmail.setOnTouchListener { v, event -> true }
        binding.mainEmail.text = Editable.Factory.getInstance().newEditable(email)
    }
}