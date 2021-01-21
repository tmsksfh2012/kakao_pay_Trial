package com.example.kakao_pay.src.main.send.fragments.usual.recycler_view

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kakao_pay.R
import com.example.kakao_pay.src.utils.Constants.TAG
import kotlinx.android.synthetic.main.item_friend_usual.view.*

class UsualViewHolder(itemView : View, iUsualRecyclerView: IUsualRecyclerView)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var myUsualRecyclerViewInterface: IUsualRecyclerView

    private var friendProfileImg = itemView.img_grid_view_friend_usual
    private var friendTextView = itemView.text_grid_view_friend_usual

    private val linearUsualItem = itemView.linear_usual_item

    init {
        // 리스너 연결
        linearUsualItem.setOnClickListener(this)
        this.myUsualRecyclerViewInterface = iUsualRecyclerView
    }

    override fun onClick(v: View?) {
    }

    // 데이터와 뷰를 묶는다.
    fun bindWithView(friendNickname: String, friendProfileImageURL : String){

        Log.d(TAG, "bindWithView: IMG_URL_ON")
        Glide.with(itemView).load(friendProfileImageURL).into(friendProfileImg)
        friendProfileImg.background = itemView.context.resources.getDrawable(R.drawable.imgbox_usual, null)
        friendProfileImg.clipToOutline = true
        friendTextView.text = friendNickname

    }
}