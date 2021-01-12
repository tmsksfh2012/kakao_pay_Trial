package com.example.kakao_pay.src.login.register.input_email

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.login.register.input_email.models.PostEmailRequest
import com.example.kakao_pay.src.login.register.input_email.models.PostEmailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterInputEmailService(val view: IRegisterInputEmailView) {
    fun tryPostEmail(emailRequest : PostEmailRequest){
        val registerEmailRetrofitInterface = ApplicationClass.sRetrofit
            .create(IRegisterInputEmailRetrofit::class.java)
        registerEmailRetrofitInterface.postEmail(emailRequest).enqueue(object : Callback<PostEmailResponse>{
            override fun onResponse(call: Call<PostEmailResponse>, response: Response<PostEmailResponse>) {
                view.onPostEmailSuccess(response.body() as PostEmailResponse)
            }

            override fun onFailure(call: Call<PostEmailResponse>, t: Throwable) {
                view.onPostEmailFailure(t.message ?: "통신 오류")
            }
        })
    }
}