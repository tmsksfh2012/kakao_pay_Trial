package com.example.kakao_pay.src.main.sendpage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentAccountBinding

class AccountFragment: BaseFragment<FragmentAccountBinding>(FragmentAccountBinding::bind, R.layout.fragment_account) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        return view
    }
}