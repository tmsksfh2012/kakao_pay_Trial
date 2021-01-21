package com.example.kakao_pay.src.splash.retrofit

import com.example.kakao_pay.src.splash.models.GetAutoLoginResponse

interface IAutoLoginView {
    fun onGetAutoLoginSuccess(response: GetAutoLoginResponse)
    fun onGetAutoLoginFailure(message: String)
}