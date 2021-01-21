package com.example.kakao_pay.src.main.send.fragments

import com.example.kakao_pay.src.main.send.models.PostBookMarkResponse


interface IBookMarkView {
    fun onPostBookMarkSuccess(response: PostBookMarkResponse)
    fun onPostBookMarkFailure(message : String)
}