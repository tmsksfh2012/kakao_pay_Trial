package com.example.kakao_pay.src.main.sendpage.models

import com.google.gson.annotations.SerializedName

data class Result (
        @SerializedName("user_list") val user_list : ArrayList<User>
)