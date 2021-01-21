package com.example.kakao_pay.src.main.send.fragments.account

import com.example.kakao_pay.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetSendLimitService(val view : IGetSendLimitView) {
    fun tryGetSendLimit(sendLimit: GetSendLimitRequest){
        val iSendLimit = ApplicationClass.sRetrofit
            .create(IGetSendLimitRetrofit::class.java)
        iSendLimit.getSendLimit(account = sendLimit.account,
            remit_type = sendLimit.remit_type)
            .enqueue(object : Callback<GetSendLimitResponse> {
                override fun onResponse(
                    call: Call<GetSendLimitResponse>,
                    response: Response<GetSendLimitResponse>
                ) {
                    view.onGetSendLimitSuccess(response.body() as GetSendLimitResponse)
                }

                override fun onFailure(call: Call<GetSendLimitResponse>, t: Throwable) {
                    view.onGetSendLimitFailure(t.message ?: "통신 오류")
                }
            })
    }
}