package com.example.kakao_pay.src.main.send.fragments

import com.example.kakao_pay.src.main.send.models.PostBookMarkRequest
import com.example.kakao_pay.src.main.send.models.PostBookMarkResponse
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface IBookMarkRetrofit {
    @POST("/bookmarks")
    fun postBookmark(@Query ("friend_number") friend_number : Int?,
                     @Query("account") account : String?,
                     @Query("remit_type") remit_type : String,
                     @Query("book_mark") book_mark : String) : Call<PostBookMarkResponse>
}