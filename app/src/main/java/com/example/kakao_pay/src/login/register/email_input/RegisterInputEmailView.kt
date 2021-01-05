package com.example.kakao_pay.src.login.register.email_input

import com.example.kakao_pay.src.login.register.email_input.models.PostEmailResponse

interface RegisterInputEmailView {

    fun onPostEmailSuccess(response: PostEmailResponse)
    fun onPostEmailFailure(message : String)
}