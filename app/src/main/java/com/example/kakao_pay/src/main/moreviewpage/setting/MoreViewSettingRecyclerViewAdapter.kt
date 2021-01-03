package com.example.kakao_pay.src.main.moreviewpage.setting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_pay.R
import com.example.kakao_pay.src.main.moreviewpage.setting.models.SettingContents

class MoreViewSettingRecyclerViewAdapter : RecyclerView.Adapter<MoreViewSettingItemViewHolder>() {
    private var contentsList = ArrayList<SettingContents>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoreViewSettingItemViewHolder {
        val contentsItemViewHolder = MoreViewSettingItemViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_fragment_setting, parent, false))
        return contentsItemViewHolder
    }

    override fun getItemCount(): Int {
        return this.contentsList.size
    }

    // 뷰가 묶였을 때 데이터를 뷰홀더에 넘겨준다.
    override fun onBindViewHolder(holder: MoreViewSettingItemViewHolder, position: Int) {
        holder.bindWithView(this.contentsList[position])
    }
    // 외부에서 어답터에 데이터 배열에 넘겨준다.
    fun submitList(contentsList:ArrayList<SettingContents>){
        this.contentsList = contentsList
    }
}