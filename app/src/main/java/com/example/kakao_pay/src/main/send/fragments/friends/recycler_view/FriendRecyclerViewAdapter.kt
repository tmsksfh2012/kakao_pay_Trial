package com.example.kakao_pay.src.main.send.fragments.friends.recycler_view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_pay.R
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.User
import com.example.kakao_pay.src.main.send.fragments.friends.models.recycler_view.IFriendRecyclerView
import com.example.kakao_pay.src.utils.Constants.TAG

class FriendRecyclerViewAdapter (iFriendRecyclerView: IFriendRecyclerView)
    : RecyclerView.Adapter<FriendViewHolder>() {

    private var friendsProfileList = ArrayList<User>()
    private lateinit var friendsProfileViewHolder : FriendViewHolder
    private var iFriendsRecyclerView : IFriendRecyclerView? = null

    init {
        this.iFriendsRecyclerView = iFriendRecyclerView
    }

    // 뷰홀더가 메모리에 올라갔을때
    // 뷰홀더와 레이아웃을 연결 시켜준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        friendsProfileViewHolder =
            FriendViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_friend, parent, false)
                , this.iFriendsRecyclerView!!
            )
        return friendsProfileViewHolder
    }

    override fun getItemCount(): Int {
        return friendsProfileList.size
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
//        Log.d(TAG, "onBindViewHolder: $position")
//        Log.d(TAG, "onBindViewHolder: " +friendsProfileList[position].nickname)
        Log.d(TAG, "onBindViewHolder: position is $position bookmark is "+ friendsProfileList[position].book_mark)
        val dataItem = this.friendsProfileList[position]

        holder.bindWithView(dataItem, position)

        holder.friendBookmarkSet.setOnCheckedChangeListener(null)


        holder.itemView.findViewById<ViewGroup>(R.id.linear_img_friend).setOnClickListener {
            val state = holder.getState()
            itemClickListener.onClickImg(it, position, state)

        }
        holder.itemView.findViewById<ViewGroup>(R.id.linear_profile_friend).setOnClickListener {
            itemClickListener.onClickProfile(it, position)
        }
    }

    // 외부에서 어답터에 User 배열을 넣어준다.
    fun submitList(friendsProfileList: ArrayList<User>){
        this.friendsProfileList = friendsProfileList
    }


    interface OnItemClickListener {
        fun onClickImg(v : View, position : Int, state: String)
        fun onClickProfile(v: View, position: Int)
    }


    private lateinit var itemClickListener: OnItemClickListener

    fun setItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}