package com.example.kakao_pay.src.main.send.fragments.recent

import com.example.kakao_pay.src.main.send.models.recentList.GetRecentResponse


interface IRecentView {
    fun onGetRecentSuccess(response: GetRecentResponse)
    fun onGetRecentFailure(message : String)
}