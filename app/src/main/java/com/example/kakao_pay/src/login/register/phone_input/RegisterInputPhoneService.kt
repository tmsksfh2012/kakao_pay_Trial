package com.example.kakao_pay.src.login.register.phone_input

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.login.register.phone_input.models.PostPhoneRequest
import com.example.kakao_pay.src.login.register.phone_input.models.PostPhoneResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterInputPhoneService(val view: RegisterInputPhoneView) {
    fun tryPostPhone(phoneRequest: PostPhoneRequest){
        val registerPhoneRetrofitInterface = ApplicationClass.sRetrofit
            .create(RegisterInputPhoneRetrofitInterface::class.java)
        registerPhoneRetrofitInterface.postPhone(phoneRequest).enqueue(object :
            Callback<PostPhoneResponse> {
            override fun onResponse(
                call: Call<PostPhoneResponse>,
                response: Response<PostPhoneResponse>
            ) {
                view.onPostPhoneSuccess(response.body() as PostPhoneResponse)
            }

            override fun onFailure(call: Call<PostPhoneResponse>, t: Throwable) {
                view.onPostPhoneFailure(t.message ?: "통신 오류")
            }
        })
    }
}