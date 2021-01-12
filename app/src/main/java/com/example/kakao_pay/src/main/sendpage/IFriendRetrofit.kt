package com.example.kakao_pay.src.main.sendpage

import com.example.kakao_pay.src.main.sendpage.models.GetFriendsResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IFriendRetrofit {
    @GET("/friends")
    fun getPhone(
    ) : Call<GetFriendsResponse>
}