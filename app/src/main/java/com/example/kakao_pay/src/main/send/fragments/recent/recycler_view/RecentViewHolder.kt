package com.example.kakao_pay.src.main.send.fragments.recent.recycler_view

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kakao_pay.R
import com.example.kakao_pay.src.utils.Constants
import com.example.kakao_pay.src.utils.Constants.TAG
import kotlinx.android.synthetic.main.item_recent.view.*

class RecentViewHolder(itemView : View, iRecentRecyclerView: IRecentRecyclerView)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var myRecentRecyclerViewInterface: IRecentRecyclerView

    private var recentProfileImg = itemView.recent_profile_img
    private var recentTextView = itemView.recent_text
    private var recentBookmarkSet = itemView.img_recent_check
    private var recentAccount = itemView.account_text

    private val constraintRecentItem = itemView.constraint_recent_item

    init {
        // 리스너 연결
        constraintRecentItem.setOnClickListener(this)
        this.myRecentRecyclerViewInterface = iRecentRecyclerView
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    // 데이터와 뷰를 묶는다.
    fun bindWithView(friendNickname: String, friendProfileImageURL : String, friendBookMark : String,
                        friendAccount: String?){
        Log.d(Constants.TAG, "SearchItemViewHolder - bindWithView() called")

        if(friendBookMark == 2.toString()) {
            recentBookmarkSet.background = itemView.context.resources.getDrawable(R.drawable.img_star_filled, null)
        }

        Glide.with(itemView).load(friendProfileImageURL).into(recentProfileImg)
        recentProfileImg.background = itemView.context.resources.getDrawable(R.drawable.imgbox_default, null)
        recentProfileImg.clipToOutline = true
        recentTextView.text = friendNickname
        if(friendAccount != "null") {
            Log.d(TAG, "bindWithView: $friendAccount")
            Log.d(TAG, "bindWithView: is called")
            recentAccount.text = friendAccount
        }
        else {
            recentAccount.text = ""
        }

    }
}