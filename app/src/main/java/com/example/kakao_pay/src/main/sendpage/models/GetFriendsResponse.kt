package com.example.kakao_pay.src.main.sendpage.models

import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject

data class GetFriendsResponse (
        @SerializedName("isSuccess") val isSuccess : Boolean,
        @SerializedName("code") val code : Int,
        @SerializedName("message") val message : String,
        @SerializedName("result") val result : Result
)