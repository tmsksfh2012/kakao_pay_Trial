package com.example.kakao_pay.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivitySplashBinding
import com.example.kakao_pay.src.login.LoginMainActivity
import com.example.kakao_pay.src.main.MainActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            val jwtToken: String? = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)
            if(jwtToken != null) startActivity(Intent(this, MainActivity::class.java))
            else startActivity(Intent(this, LoginMainActivity::class.java))
            finish()
        }, 1500)
    }
}