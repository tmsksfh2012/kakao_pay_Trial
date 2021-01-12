package com.example.kakao_pay.src.login.register.input_phone.certify_phone

import android.util.Log
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.login.register.input_email.certify_email.models.GetEmailResponse
import com.example.kakao_pay.src.login.register.input_phone.certify_phone.models.GetPhoneRequest
import com.example.kakao_pay.src.login.register.input_phone.certify_phone.models.GetPhoneResponse
import com.example.kakao_pay.src.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterCertifyPhoneService(val view: IRegisterCertifyPhoneView) {
    fun tryGetPhone(certifyRequest: GetPhoneRequest){
        val registerPhoneRetrofitInterface
            = ApplicationClass.sRetrofit.create(IRegisterCertifyPhoneRetrofit::class.java)

        registerPhoneRetrofitInterface.getPhone(certifyRequest.phone, certifyRequest.auth_number)
            .enqueue(object : Callback<GetPhoneResponse> {
            override fun onFailure(call: Call<GetPhoneResponse>, t: Throwable) {
                view.onGetPhoneFailure(t.message ?: "통신 오류")
            }

            override fun onResponse(call: Call<GetPhoneResponse>, response: Response<GetPhoneResponse>) {
                Log.d(Constants.TAG, certifyRequest.phone)
                Log.d(Constants.TAG, certifyRequest.auth_number)
                response.body()?.confirm?.let { Log.d(Constants.TAG, it) }
                view.onGetPhoneSuccess(response.body() as GetPhoneResponse)
            }
        })
    }
}