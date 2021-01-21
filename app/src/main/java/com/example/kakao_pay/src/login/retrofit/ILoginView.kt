package com.example.kakao_pay.src.login.retrofit

import com.example.kakao_pay.src.login.models.PostLoginResponse

interface ILoginView {
    fun onPostLoginSuccess(response: PostLoginResponse)
    fun onPostLoginFailure(message: String)
}