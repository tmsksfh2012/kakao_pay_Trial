package com.example.kakao_pay.src.login.register.input_email

import com.example.kakao_pay.src.login.register.input_email.models.PostEmailResponse

interface IRegisterInputEmailView {

    fun onPostEmailSuccess(response: PostEmailResponse)
    fun onPostEmailFailure(message : String)
}