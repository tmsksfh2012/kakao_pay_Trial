package com.example.kakao_pay.src.main.send.models

import com.google.gson.annotations.SerializedName

data class PostBookMarkResponse (
        @SerializedName("isSuccess") val isSuccess : Boolean,
        @SerializedName("code") val code : Int,
        @SerializedName("message") val message : String,
        @SerializedName("book_mark") val book_mark : String
)