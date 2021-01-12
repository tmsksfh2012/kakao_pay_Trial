package com.example.kakao_pay.src.main.sendpage.recycler_view

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kakao_pay.R
import com.example.kakao_pay.src.utils.Constants
import kotlinx.android.synthetic.main.item_friend.view.*

class FriendViewHolder (itemView : View, friendRecyclerViewInterface: IFriendRecyclerView)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var myFriendRecyclerViewInterface: IFriendRecyclerView

    private var friendProfileImg = itemView.profile_img
    private var friendTextView = itemView.friend_text
    private var friendBookmarkSet = itemView.img_friend_check

    private val constraintFriendItem = itemView.constraint_friend_item

    init {
        Log.d(Constants.TAG, "SearchItemViewHolder - init() called")
        // 리스너 연결
        constraintFriendItem.setOnClickListener(this)
        this.myFriendRecyclerViewInterface = friendRecyclerViewInterface
    }


    override fun onClick(v: View?) {
        when(v) {
            constraintFriendItem -> {
                Log.d(Constants.TAG, "onClick: 지역번호 선택")
                this.myFriendRecyclerViewInterface.onFriendItemClicked(adapterPosition)
            }
            friendBookmarkSet -> {

            }
        }
    }

    // 데이터와 뷰를 묶는다.
    fun bindWithView(friendNickname: String, friendProfileImageURL : String, friendBookMark : String){
        Log.d(Constants.TAG, "SearchItemViewHolder - bindWithView() called")

        if(friendBookMark == 2.toString()) {
            friendBookmarkSet.background = itemView.context.resources.getDrawable(R.drawable.img_star_filled, null)
        }

        Glide.with(itemView).load(friendProfileImageURL).into(friendProfileImg)
        friendProfileImg.background = itemView.context.resources.getDrawable(R.drawable.imgbox_default, null)
        friendProfileImg.clipToOutline = true
        friendTextView.text = friendNickname

    }

}