package com.example.kakao_pay.src.main.send.fragments.usual

import com.example.kakao_pay.src.main.send.fragments.usual.models.GetBookmarkResponse
import retrofit2.Call
import retrofit2.http.GET

interface IGetBookmarkRetrofit {
    @GET("/bookmarks")
    fun getBookmark() : Call<GetBookmarkResponse>
}