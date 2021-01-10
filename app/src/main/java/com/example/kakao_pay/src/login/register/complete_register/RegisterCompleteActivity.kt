package com.example.kakao_pay.src.login.register.complete_register

import android.content.Intent
import android.os.Bundle
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivitySuccessMakingProfileBinding
import com.example.kakao_pay.src.main.MainActivity
import com.example.kakao_pay.src.utils.Constants.TAG

class RegisterCompleteActivity : BaseActivity<ActivitySuccessMakingProfileBinding>(ActivitySuccessMakingProfileBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val email = intent.getStringExtra("email")!! as CharSequence
        val nickname = intent.getStringExtra("nickname")!! as CharSequence

        binding.profileImg.background = resources.getDrawable(R.drawable.imgbox_default, null)
        binding.profileImg.clipToOutline = true
        binding.profileEmail.text = email
        binding.profileNickname.text = nickname

        binding.btnStart.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}