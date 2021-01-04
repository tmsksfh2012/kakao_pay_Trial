package com.example.kakao_pay.src.main.moreviewpage.setting

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_pay.databinding.ItemFragmentSettingBinding
import com.example.kakao_pay.src.main.moreviewpage.setting.models.SettingContents

class MoreViewSettingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var itemViews : ItemFragmentSettingBinding

    private val settingContent = itemViews.settingTitle


    fun bindWithView(contentsItem: SettingContents){
        Log.d("SettingItemViewHolder", "bindWithView")

        settingContent.text = contentsItem.title

    }
}