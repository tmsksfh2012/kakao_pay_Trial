package com.example.kakao_pay.src.main.send.fragments.friends

import com.example.kakao_pay.src.main.send.fragments.friends.models.about_send.PostSendMoneyRequest
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_send.PostSendMoneyResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IPostSendRetrofit {
    @POST("/remits")
    fun getBookmark(@Body sendRequest : PostSendMoneyRequest) : Call<PostSendMoneyResponse>
}