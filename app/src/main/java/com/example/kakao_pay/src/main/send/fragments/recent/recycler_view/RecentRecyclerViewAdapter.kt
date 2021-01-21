package com.example.kakao_pay.src.main.send.fragments.recent.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_pay.R
import com.example.kakao_pay.src.main.send.models.recentList.Recent

class RecentRecyclerViewAdapter(iRecentRecyclerView: IRecentRecyclerView)
    : RecyclerView.Adapter<RecentViewHolder>(){

    private var recentProfileList = ArrayList<Recent>()
    lateinit var recentProfileViewHolder: RecentViewHolder
    var iRecentRecyclerView : IRecentRecyclerView? = null

    init {
        this.iRecentRecyclerView = iRecentRecyclerView
    }

    // 뷰홀더가 메모리에 올라갔을때
    // 뷰홀더와 레이아웃을 연결 시켜준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
        recentProfileViewHolder =
                RecentViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_recent, parent, false)
                , this.iRecentRecyclerView!!)
        return recentProfileViewHolder
    }

    override fun getItemCount(): Int {
        return recentProfileList.size
    }

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        val dataItem = this.recentProfileList[position]

        if(dataItem.nickname == null) {
            holder.bindWithView(dataItem.name, dataItem.image, dataItem.book_mark, dataItem.account)
        }
        else {
            holder.bindWithView(dataItem.nickname, dataItem.image, dataItem.book_mark, dataItem.account)
        }
    }

    // 외부에서 어답터에 User 배열을 넣어준다.
    fun submitList(recentProfileList: ArrayList<Recent>){
        this.recentProfileList = recentProfileList
    }
}