package com.example.kakao_pay.src.login.register.input_phone

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.login.register.input_phone.models.PostPhoneRequest
import com.example.kakao_pay.src.login.register.input_phone.models.PostPhoneResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterInputPhoneService(val view: IRegisterInputPhoneView) {
    fun tryPostPhone(phoneRequest: PostPhoneRequest){
        val registerPhoneRetrofitInterface = ApplicationClass.sRetrofit
            .create(IRegisterInputPhoneRetrofit::class.java)
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