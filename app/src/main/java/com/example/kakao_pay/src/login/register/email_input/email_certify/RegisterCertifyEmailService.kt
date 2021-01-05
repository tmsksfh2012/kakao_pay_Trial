package com.example.kakao_pay.src.login.register.email_input.email_certify

import android.util.Log
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.login.register.email_input.RegisterInputEmailRetrofitInterface
import com.example.kakao_pay.src.login.register.email_input.email_certify.models.GetEmailRequest
import com.example.kakao_pay.src.login.register.email_input.email_certify.models.GetEmailResponse
import com.example.kakao_pay.src.utils.Constants.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterCertifyEmailService(val view : RegisterCertifyEmailView) {

    fun tryGetEmail(certifyRequest : GetEmailRequest){
        val registerEmailRetrofitInterface
                = ApplicationClass.sRetrofit.create(RegisterCertifyEmailRetrofitInterface::class.java)

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