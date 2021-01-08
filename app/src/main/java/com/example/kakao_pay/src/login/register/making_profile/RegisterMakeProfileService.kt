package com.example.kakao_pay.src.login.register.making_profile

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.login.register.making_profile.models.PostProfileRequest
import com.example.kakao_pay.src.login.register.making_profile.models.PostProfileResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterMakeProfileService(val view : RegisterMakeProfileView) {
    fun tryPostProfile(profileRequest : PostProfileRequest){
        val registerProfileRetrofitInterface = ApplicationClass.sRetrofit
            .create(RegisterMakeProfileRetrofitInterface::class.java)
        registerProfileRetrofitInterface.postProfile(profileRequest).enqueue(object : Callback<PostProfileResponse> {
            override fun onResponse(call: Call<PostProfileResponse>, response: Response<PostProfileResponse>
            ) {
                view.onPostProfileSuccess(response.body() as PostProfileResponse)
            }

            override fun onFailure(call: Call<PostProfileResponse>, t: Throwable) {
                view.onPostProfileFailure(t.message ?: "통신 오류")
            }
        })
    }
}