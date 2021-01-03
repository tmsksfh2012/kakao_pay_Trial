package com.example.kakao_pay.src.main.managepage

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentHomeBinding
import com.example.kakao_pay.src.main.managepage.models.PostSignUpRequest
import com.example.kakao_pay.src.main.managepage.models.SignUpResponse
import com.example.kakao_pay.src.main.managepage.models.UserResponse

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
        HomeFragmentView{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeButtonTryGetJwt.setOnClickListener{
            showLoadingDialog(context!!)
            HomeService(this).tryGetUsers()
        }
        binding.homeBtnTryPostHttpMethod.setOnClickListener {
            val email = binding.homeEtId.text.toString()
            val password = binding.homeEtPw.text.toString()
            val postRequest = PostSignUpRequest(email = email, password = password,
                confirmPassword = password, nickname = "test", phoneNumber = "010-0000-0000")
            showLoadingDialog(context!!)
            HomeService(this).tryPostSignUp(postRequest)
        }
    }

    override fun onGetUserSuccess(response: UserResponse) {
        dismissLoadingDialog()
        for (User in response.result) {
            Log.d("HomeFragment", User.toString())
        }
        binding.homeButtonTryGetJwt.text = response.message
        showCustomToast("Get JWT 성공")
    }

    override fun onGetUserFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        dismissLoadingDialog()
        binding.homeBtnTryPostHttpMethod.text = response.message
        showCustomToast(response.message)
    }

    override fun onPostSignUpFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}