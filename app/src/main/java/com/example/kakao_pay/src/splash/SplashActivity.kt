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
import com.example.kakao_pay.src.splash.models.GetAutoLoginResponse
import com.example.kakao_pay.src.splash.retrofit.AutoLoginService
import com.example.kakao_pay.src.splash.retrofit.IAutoLoginView

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate),
    IAutoLoginView{

    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handler = Handler(Looper.getMainLooper())

        handler.postDelayed({
        }, 1500)
        AutoLoginService(this).tryGetLogin()

    }

    override fun onGetAutoLoginSuccess(response: GetAutoLoginResponse) {
        when(response.code) {
            1000 -> {
                finish()
                startActivity(Intent(this, MainActivity::class.java)
                    .putExtra("email",response.result!!.email).putExtra("name", response.result.name)
                    .putExtra("phone", response.result.phone).putExtra("birthday", response.result.birthday))
            }
            2001 -> {
                finish()
                startActivity(Intent(this, LoginMainActivity::class.java))
            }
        }
    }

    override fun onGetAutoLoginFailure(message: String) {
        startActivity(Intent(this, LoginMainActivity::class.java))
    }
}