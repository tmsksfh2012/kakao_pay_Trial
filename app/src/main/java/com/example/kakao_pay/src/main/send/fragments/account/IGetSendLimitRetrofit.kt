package com.example.kakao_pay.src.main.send.fragments.account

import com.example.kakao_pay.src.main.send.fragments.account.GetSendLimitResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IGetSendLimitRetrofit {
    @GET("/accounts-check")
    fun getSendLimit(@Query("account") account : String?,
                        @Query("remit_type") remit_type : String?) : Call<GetSendLimitResponse>
}