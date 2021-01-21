package com.example.kakao_pay.src.main.send.fragments.recent

import com.example.kakao_pay.src.main.send.models.recentList.GetRecentResponse
import retrofit2.Call
import retrofit2.http.GET

interface IRecentRetrofit {
    @GET("recent-list")
    fun getRecent() : Call<GetRecentResponse>
}