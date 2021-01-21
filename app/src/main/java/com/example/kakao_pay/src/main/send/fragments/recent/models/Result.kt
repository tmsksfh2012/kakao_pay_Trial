package com.example.kakao_pay.src.main.send.models.recentList

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("recent_remit_list") val recent_remit_list : ArrayList<Recent>
)