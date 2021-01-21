package com.example.kakao_pay.src.splash.retrofit

import android.util.Log
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.splash.models.GetAutoLoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AutoLoginService(val view : IAutoLoginView) {
    fun tryGetLogin() {
        val iAutoLoginRetrofit = ApplicationClass.sRetrofit.create(IAutoLoginRetrofit::class.java)
        iAutoLoginRetrofit.getAutoLogin().enqueue(object : Callback<GetAutoLoginResponse> {
            override fun onFailure(call: Call<GetAutoLoginResponse>, t: Throwable) {
                view.onGetAutoLoginFailure(t.message ?: "통신 오류")
            }

            override fun onResponse(call: Call<GetAutoLoginResponse>, response: Response<GetAutoLoginResponse>) {
                if(response.body() == null) {
                    val nullResponse = GetAutoLoginResponse(code = 2001, isSuccess = false, message = "로그인 되어 있지 않습니다.",result = null)
                    view.onGetAutoLoginSuccess(nullResponse)
                }
                else{
                    view.onGetAutoLoginSuccess(response.body() as GetAutoLoginResponse)
                }
            }
        })
    }
}