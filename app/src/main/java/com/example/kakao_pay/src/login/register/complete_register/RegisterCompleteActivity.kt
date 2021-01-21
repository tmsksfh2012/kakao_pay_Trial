package com.example.kakao_pay.src.login.register.complete_register

import android.content.Intent
import android.os.Bundle
import com.example.kakao_pay.R
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivitySuccessMakingProfileBinding
import com.example.kakao_pay.src.login.retrofit.ILoginView
import com.example.kakao_pay.src.login.retrofit.LoginService
import com.example.kakao_pay.src.login.models.PostLoginRequest
import com.example.kakao_pay.src.login.models.PostLoginResponse
import com.example.kakao_pay.src.main.MainActivity

class RegisterCompleteActivity : BaseActivity<ActivitySuccessMakingProfileBinding>(ActivitySuccessMakingProfileBinding::inflate),
    ILoginView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val email = intent.getStringExtra("email")!!
        val nickname = intent.getStringExtra("nickname")!!
        val name = intent.getStringExtra("name")!!
        val birth = intent.getStringExtra("birth")!!
        val phone = intent.getStringExtra("phone")
        val password = intent.getStringExtra("password")!!

        val edit =  ApplicationClass.sSharedPreferences.edit()
        edit.putString("name", name).putString("birth", birth).putString("phone", phone)
        edit.apply()

        binding.successProfileImg.background = resources.getDrawable(R.drawable.imgbox_default, null)
        binding.successProfileImg.clipToOutline = true
        binding.profileEmail.text = email
        binding.profileNickname.text = nickname

        binding.btnStart.setOnClickListener {
            val postLogin = PostLoginRequest(
                email = email,
                password = password
            )
            showLoadingDialog(this)
            LoginService(this).tryPostLogin(postLogin)
        }
    }

    override fun onPostLoginSuccess(response: PostLoginResponse) {
        dismissLoadingDialog()
        when(response.code) {
            1000 -> {
                val token = response.jwt
                val editor = ApplicationClass.sSharedPreferences.edit()
                editor.putString(ApplicationClass.X_ACCESS_TOKEN,token)
                editor.apply()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    override fun onPostLoginFailure(message: String) {
        dismissLoadingDialog()
    }
}