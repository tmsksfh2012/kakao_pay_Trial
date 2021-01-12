package com.example.kakao_pay.src.main.moreviewpage.setting

import android.os.Bundle
import android.view.MenuItem
import com.example.kakao_pay.R
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivitySettingBinding
import com.example.kakao_pay.src.main.moreviewpage.setting.dialogs.DialogLogout

class SettingActivity : BaseActivity<ActivitySettingBinding>(ActivitySettingBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.topAppBar)

        binding.imgProfileSetting.background = resources.getDrawable(R.drawable.imgbox_default, null)
        binding.imgProfileSetting.clipToOutline = true

        binding.textNameSetting.text = ApplicationClass.sSharedPreferences.getString("name", "")

        binding.layoutLogout.setOnClickListener {
            val mLogoutDialog = DialogLogout()
            mLogoutDialog.show(supportFragmentManager, mLogoutDialog.tag)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> { // 메뉴 버튼
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}