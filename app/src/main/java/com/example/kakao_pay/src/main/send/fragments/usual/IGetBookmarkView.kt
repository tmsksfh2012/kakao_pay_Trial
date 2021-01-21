package com.example.kakao_pay.src.main.send.fragments.usual

import com.example.kakao_pay.src.main.send.fragments.usual.models.GetBookmarkResponse

interface IGetBookmarkView {
    fun onGetBookmarkSuccess(response: GetBookmarkResponse)
    fun onGetBookmarkFailure(message : String)
}