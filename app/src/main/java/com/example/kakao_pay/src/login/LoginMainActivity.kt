package com.example.kakao_pay.src.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityLoginMainBinding


class LoginMainActivity:BaseActivity<ActivityLoginMainBinding>(ActivityLoginMainBinding::inflate) {
    lateinit var imageList : ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.initializeData()

        val adapter = LoginViewPagerAdapter(imageList)
        val indicator = binding.indicator
        binding.viewpager.adapter = adapter
        binding.viewpager.clipToPadding = false
        indicator.setViewPager(binding.viewpager)

        binding.moreViewBtnLogin.setOnClickListener {
            showLoadingDialog(this)
            Handler(Looper.getMainLooper()).postDelayed({
                dismissLoadingDialog()
                startActivity(Intent(this, LoginActivity::class.java))
            },500)
        }
    }
    private fun initializeData() {
        imageList = arrayListOf(
            R.drawable.img_login_1,
            R.drawable.img_login_2,
            R.drawable.img_login_3,
            R.drawable.img_login_4
        )
    }
}