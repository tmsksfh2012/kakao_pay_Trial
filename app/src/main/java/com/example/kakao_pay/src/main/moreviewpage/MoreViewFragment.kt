package com.example.kakao_pay.src.main.moreviewpage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.kakao_pay.R
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentMoreViewBinding
import com.example.kakao_pay.src.main.moreviewpage.setting.SettingActivity
import com.example.kakao_pay.src.utils.Constants.TAG

class MoreViewFragment:BaseFragment<FragmentMoreViewBinding>(FragmentMoreViewBinding::bind, R.layout.fragment_more_view),
    MoreViewFragmentView {
    private lateinit var imageList : ArrayList<Int>
    private var stringList = ArrayList<String>()
    private lateinit var strArray : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        strArray = context!!.resources.getStringArray(R.array.more_view_title)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.initializeData()

        binding.textMyName.text =ApplicationClass.sSharedPreferences.getString("name", "")

        val adapter = MoreViewPagerAdapter(imageList, stringList)
        val indicator = binding.indicator

        binding.imgMoreViewProfile.background = resources.getDrawable(R.drawable.imgbox_default, null)
        binding.imgMoreViewProfile.clipToOutline = true

        binding.moreViewImgViewpager.adapter = adapter
        binding.moreViewImgViewpager.clipToPadding = false
        indicator.setViewPager(binding.moreViewImgViewpager)

        binding.moreViewImgSetting.setOnClickListener {
            startActivity(Intent(context, SettingActivity::class.java))
        }
    }
    private fun initializeData() {
        imageList = arrayListOf(
                R.drawable.img_more_view_2,
                R.drawable.img_more_view_1,
                R.drawable.img_more_view_3
        )

        for (element in strArray) {
            Log.d(TAG, "initializeData: $element")
            stringList.add(element)
        }
    }

}