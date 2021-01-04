package com.example.kakao_pay.retroit

import com.example.kakao_pay.src.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetroit {
    @GET(API.SEARCH_USERS)
    fun searchUsers(@Query("query") searchTerm:String) : Call<JsonElement>
}