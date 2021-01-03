package com.example.kakao_pay.src.main.managepage

import com.example.kakao_pay.src.main.managepage.models.SignUpResponse
import com.example.kakao_pay.src.main.managepage.models.UserResponse

interface HomeFragmentView {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}