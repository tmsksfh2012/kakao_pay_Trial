package com.example.kakao_pay.src.main.send.fragments.friends

import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.GetFriendsResponse

import retrofit2.Call
import retrofit2.http.GET

interface IFriendRetrofit {
    @GET("/friends")
    fun getPhone() : Call<GetFriendsResponse>
}