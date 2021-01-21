package com.example.kakao_pay.src.main.send.fragments.usual.models

import com.google.gson.annotations.SerializedName

data class GetBookmarkResponse (
        @SerializedName("isSuccess") val isSuccess : Boolean,
        @SerializedName("code") val code : Int,
        @SerializedName("message") val message : String,
        @SerializedName("result") val result : Result
)