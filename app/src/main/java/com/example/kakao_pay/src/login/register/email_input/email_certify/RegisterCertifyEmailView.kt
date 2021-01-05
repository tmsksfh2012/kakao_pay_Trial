package com.example.kakao_pay.src.login.register.email_input.email_certify

import com.example.kakao_pay.src.login.register.email_input.email_certify.models.GetEmailResponse

interface RegisterCertifyEmailView {
    fun onGetEmailSuccess(response: GetEmailResponse)
    fun onGetEmailFailure(message: String)

}