package com.example.kakao_pay.src.main.more

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentMoreViewBinding
import com.example.kakao_pay.src.main.more.setting.SettingActivity

class MoreViewFragment(val name : String, val email : String, val birth : String, val phone : String)
    :BaseFragment<FragmentMoreViewBinding>(FragmentMoreViewBinding::bind, R.layout.fragment_more_view),
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

        binding.textMyName.text = name

        val adapter = MoreViewPagerAdapter(imageList, stringList)
        val indicator = binding.indicator

        binding.imgMoreViewProfile.background = resources.getDrawable(R.drawable.imgbox_default, null)
        binding.imgMoreViewProfile.clipToOutline = true

        binding.moreViewImgViewpager.adapter = adapter
        binding.moreViewImgViewpager.clipToPadding = false
        indicator.setViewPager(binding.moreViewImgViewpager)

        binding.moreViewImgSetting.setOnClickListener {
            startActivity(Intent(context, SettingActivity()::class.java)
                    .putExtra("email",email).putExtra("name",name)
                    .putExtra("phone", phone).putExtra("birthday", birth))
        }
    }
    private fun initializeData() {
        imageList = arrayListOf(
                R.drawable.img_more_view_3,
                R.drawable.img_more_view_1,
                R.drawable.img_more_view_2
        )

        for (element in strArray) {
            stringList.add(element)
        }
    }

}