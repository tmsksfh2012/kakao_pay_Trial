package com.example.kakao_pay.src.main.managepage

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.main.managepage.models.PostSignUpRequest
import com.example.kakao_pay.src.main.managepage.models.SignUpResponse
import com.example.kakao_pay.src.login.register.input_email.models.PostEmailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val view: HomeFragmentView) {
    fun tryGetUsers(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getUsers().enqueue(object : Callback<PostEmailResponse> {
            override fun onResponse(call: Call<PostEmailResponse>, response: Response<PostEmailResponse>) {
                view.onGetUserSuccess(response.body() as PostEmailResponse)
            }

            override fun onFailure(call: Call<PostEmailResponse>, t: Throwable) {
                view.onGetUserFailure(t.message ?: "통신 오류")
            }
        })
    }
    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<SignUpResponse>{
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                view.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }
}