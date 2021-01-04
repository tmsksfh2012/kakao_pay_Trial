package com.example.kakao_pay.src.main.moreviewpage.setting

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentSettingBinding
import com.example.kakao_pay.src.main.moreviewpage.setting.models.SettingContents

class MoreViewSettingFragment:BaseFragment<FragmentSettingBinding>
    (FragmentSettingBinding::bind, R.layout.fragment_setting),
    MoreViewSettingFragmentView, View.OnClickListener {

    // 데이터
    private var contentsList = ArrayList<SettingContents>()

    private lateinit var settingContentsAdapter: MoreViewSettingRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.settingContentsRecyclerViewSetting(this.contentsList)

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    private fun settingContentsRecyclerViewSetting(contentsList: ArrayList<SettingContents>){
        Log.d("setting", "settingContentsRecyclerViewSetting")
        this.settingContentsAdapter = MoreViewSettingRecyclerViewAdapter()
        this.settingContentsAdapter.submitList(contentsList)

    }

}