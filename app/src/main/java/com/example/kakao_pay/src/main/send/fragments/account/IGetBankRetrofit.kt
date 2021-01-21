package com.example.kakao_pay.src.main.send.fragments.account

import com.example.kakao_pay.src.main.send.fragments.account.models.GetBankResponse
import retrofit2.Call
import retrofit2.http.GET

interface IGetBankRetrofit {
    @GET("/banks")
    fun getBanks() : Call<GetBankResponse>
}