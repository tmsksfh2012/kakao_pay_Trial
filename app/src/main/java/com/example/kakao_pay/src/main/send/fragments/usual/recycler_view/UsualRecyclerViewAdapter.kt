package com.example.kakao_pay.src.main.send.fragments.usual.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_pay.R
import com.example.kakao_pay.src.main.send.fragments.usual.models.Bookmark

class UsualRecyclerViewAdapter(iUsualRecyclerView: IUsualRecyclerView) :
    RecyclerView.Adapter<UsualViewHolder>() {

    private var friendsProfileList = ArrayList<Bookmark>()
    private lateinit var friendsProfileViewHolder : UsualViewHolder
    private var iFriendsRecyclerView : IUsualRecyclerView? = null

    init {
        this.iFriendsRecyclerView = iUsualRecyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsualViewHolder {
        friendsProfileViewHolder =
                UsualViewHolder(
                        LayoutInflater
                                .from(parent.context)
                                .inflate(R.layout.item_friend_usual, parent, false)
                        , this.iFriendsRecyclerView!!
                )
        return friendsProfileViewHolder
    }

    override fun getItemCount(): Int {
        return friendsProfileList.size
    }

    override fun onBindViewHolder(holder: UsualViewHolder, position: Int) {
        val dataItem = this.friendsProfileList[position]
        if(dataItem.nickname == null) {
            holder.bindWithView(dataItem.name, dataItem.image)
        }
        else {
            holder.bindWithView(dataItem.nickname, dataItem.image)
        }
    }

    // 외부에서 어답터에 UserBookmark 배열을 넣어준다.
    fun submitList(friendsProfileList: ArrayList<Bookmark>){
        this.friendsProfileList = friendsProfileList
    }

    fun addItem(user : Bookmark) {
        friendsProfileList.add(user)
    }

    fun removeItem(position: Int) {
        friendsProfileList.removeAt(position)
        // 갱신 처리
        notifyDataSetChanged()
    }
}