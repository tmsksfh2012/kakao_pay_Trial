package com.example.kakao_pay.src.login.register.input_email.certify_email

import com.example.kakao_pay.src.login.register.input_email.certify_email.models.GetEmailResponse

interface IRegisterCertifyEmailView {
    fun onGetEmailSuccess(response: GetEmailResponse)
    fun onGetEmailFailure(message: String)

}