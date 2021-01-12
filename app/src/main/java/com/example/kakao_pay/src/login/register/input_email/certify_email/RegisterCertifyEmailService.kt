package com.example.kakao_pay.src.login.register.input_email.certify_email

import android.util.Log
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.login.register.input_email.certify_email.models.GetEmailRequest
import com.example.kakao_pay.src.login.register.input_email.certify_email.models.GetEmailResponse
import com.example.kakao_pay.src.utils.Constants.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterCertifyEmailService(val view : IRegisterCertifyEmailView) {

    fun tryGetEmail(certifyRequest : GetEmailRequest){
        val registerEmailRetrofitInterface
                = ApplicationClass.sRetrofit.create(IRegisterCertifyEmailRetrofit::class.java)

        registerEmailRetrofitInterface.getEmail(certifyRequest.email, certifyRequest.authNum)
            .enqueue(object : Callback<GetEmailResponse> {
            override fun onFailure(call: Call<GetEmailResponse>, t: Throwable) {
                view.onGetEmailFailure(t.message ?: "통신 오류")
            }

            override fun onResponse(call: Call<GetEmailResponse>, response: Response<GetEmailResponse>) {
                Log.d(TAG, certifyRequest.email)
                Log.d(TAG, certifyRequest.authNum)
                response.body()?.confirm?.let { Log.d(TAG, it) }
                view.onGetEmailSuccess(response.body() as GetEmailResponse)
            }
        })
    }
}