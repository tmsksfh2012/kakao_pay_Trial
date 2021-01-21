package com.example.kakao_pay.src.login.retrofit

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.login.models.PostLoginRequest
import com.example.kakao_pay.src.login.models.PostLoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: ILoginView) {
    fun tryPostLogin(loginRequest: PostLoginRequest) {
        val iLoginRetrofit = ApplicationClass.sRetrofit
            .create(ILoginRetrofit::class.java)
        iLoginRetrofit.postLogin(loginRequest).enqueue(object : Callback<PostLoginResponse> {
            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                view.onPostLoginFailure(t.message ?: "통신 오류")
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) {
                view.onPostLoginSuccess(response.body() as PostLoginResponse)
            }
        })
    }
}