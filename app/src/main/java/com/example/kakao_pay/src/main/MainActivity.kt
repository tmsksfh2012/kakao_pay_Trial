package com.example.kakao_pay.src.main

import android.os.Bundle
import android.util.Log
import com.example.kakao_pay.R
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityMainBinding
import com.example.kakao_pay.src.main.invest.InvestFragment
import com.example.kakao_pay.src.main.manage.ManageFragment
import com.example.kakao_pay.src.main.more.MoreViewFragment
import com.example.kakao_pay.src.main.pay.PayFragment
import com.example.kakao_pay.src.main.send.SendFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    lateinit var name : String
    lateinit var email : String
    lateinit var phone : String
    lateinit var birth : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = intent.getStringExtra("name").toString()
        email = intent.getStringExtra("email").toString()
        birth = intent.getStringExtra("birthday").toString()
        phone = intent.getStringExtra("phone").toString()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_manage -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ManageFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_send -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, SendFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_pay -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, PayFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_invest -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, InvestFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_more_view -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MoreViewFragment(name, email, phone, birth))
                            .commitAllowingStateLoss()

                        return@OnNavigationItemSelectedListener true
                    }
                }
                true
            })
    }
}