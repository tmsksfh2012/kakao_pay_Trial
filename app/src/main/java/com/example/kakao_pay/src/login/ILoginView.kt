package com.example.kakao_pay.src.login

import com.example.kakao_pay.src.login.models.PostLoginResponse

interface ILoginView {
    fun onPostLoginSuccess(response: PostLoginResponse)
    fun onPostLoginFailure(message: String)
}