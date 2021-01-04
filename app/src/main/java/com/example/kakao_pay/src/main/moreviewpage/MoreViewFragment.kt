package com.example.kakao_pay.src.main.moreviewpage

import android.os.Bundle
import android.view.View
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentMoreViewBinding

class MoreViewFragment:BaseFragment<FragmentMoreViewBinding>(FragmentMoreViewBinding::bind, R.layout.fragment_more_view),
    MoreViewFragmentView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moreViewImgSetting.setOnClickListener {  }
    }

}