package com.example.kakao_pay.src.login

import com.example.kakao_pay.src.login.models.UserResponse

interface LoginActivityView {

    fun onGetUserSuccess(response: UserResponse)
}