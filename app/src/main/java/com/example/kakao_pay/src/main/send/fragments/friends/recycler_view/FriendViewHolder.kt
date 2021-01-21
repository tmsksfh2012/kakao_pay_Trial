package com.example.kakao_pay.src.main.send.fragments.friends.recycler_view

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kakao_pay.R
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.User
import com.example.kakao_pay.src.main.send.fragments.friends.models.recycler_view.IFriendRecyclerView
import com.example.kakao_pay.src.main.send.fragments.usual.CheckboxData
import com.example.kakao_pay.src.utils.Constants.TAG
import kotlinx.android.synthetic.main.item_friend.view.*

class FriendViewHolder (itemView : View, iFriendRecyclerView: IFriendRecyclerView)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var myFriendRecyclerViewInterface: IFriendRecyclerView

    private var friendProfileImg = itemView.success_profile_img
    private var friendTextView = itemView.friend_text
    var friendBookmarkSet = itemView.img_friend_check

    private val linearFriendItem = itemView.linear_profile_friend
    private val linearFriendImg = itemView.linear_img_friend

    private lateinit var state : String
    private var positionTmp : Int = 0

    companion object {
        var checkboxList = arrayListOf<CheckboxData>()
    }


    init {
        // 리스너 연결
        linearFriendItem.setOnClickListener(this)
        linearFriendImg.setOnClickListener(this)
        this.myFriendRecyclerViewInterface = iFriendRecyclerView
    }


    override fun onClick(v: View?) {
//        when(v) {
//            // 송금창 열기
//            linearFriendItem -> {
//                Log.d(TAG, "onClick: Item here")
//            }
//            linearFriendImg -> {
//                Log.d(TAG, "onClick: Img here")
//                if(friendBookmarkSet.isChecked) {
//                    checkboxList[positionTmp].checked = true
//                    state = 1.toString()
//                }
//                else if(!friendBookmarkSet.isChecked) {
//                    checkboxList[positionTmp].checked = false
//                    state = 2.toString()
//                }
//            }
//        }
    }

    // 데이터와 뷰를 묶는다.
    fun bindWithView(data : User, position: Int){

        positionTmp = position
        Log.d(TAG, "bindWithView: "+ checkboxList.size)

        if( position >= checkboxList.size) {
            if(data.book_mark == 2.toString()) {
                checkboxList.add(position, CheckboxData(true))
            }
            else if(data.book_mark == 1.toString()) {
                checkboxList.add(position, CheckboxData(false))
            }
        }

        friendBookmarkSet.isChecked = checkboxList[position].checked

        Glide.with(itemView).load(data.user_image).into(friendProfileImg)
        friendProfileImg.background = itemView.context.resources.getDrawable(R.drawable.imgbox_default, null)
        friendProfileImg.clipToOutline = true
        friendTextView.text = data.nickname

    }

//    fun binding(item : User, onClickListener: View.OnClickListener) {
//
//        Log.d(TAG, "onClick img: iscalled")
//        if(friendBookmarkSet.isChecked) {
//            Log.d(TAG, "onClick selected img: iscalled")
//            friendBookmarkSet.isChecked = false
//        }
//        else {
//            Log.d(TAG, "onClick unselected img: iscalled")
//            friendBookmarkSet.isChecked = true
//        }
//        itemView.img_friend_check.isChecked = false
//    }

    fun getState() : String {
        if (friendBookmarkSet.isChecked) {
            Log.d(TAG, "onClick selected img: iscalled")
            friendBookmarkSet.isChecked = false
            checkboxList[positionTmp].checked = false
            state = 2.toString()
        } else {
            Log.d(TAG, "onClick unselected img: iscalled")
            checkboxList[positionTmp].checked = true
            friendBookmarkSet.isChecked = true
            state = 1.toString()
        }
            return state
    }

}