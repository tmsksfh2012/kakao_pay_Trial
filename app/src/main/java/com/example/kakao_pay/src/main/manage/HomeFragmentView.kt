package com.example.kakao_pay.src.main.manage

import com.example.kakao_pay.src.main.manage.models.SignUpResponse
import com.example.kakao_pay.src.login.register.input_email.models.PostEmailResponse

interface HomeFragmentView {

    fun onGetUserSuccess(response: PostEmailResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}