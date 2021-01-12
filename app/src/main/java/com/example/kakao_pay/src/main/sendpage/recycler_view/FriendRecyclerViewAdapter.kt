package com.example.kakao_pay.src.main.sendpage.recycler_view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_pay.R
import com.example.kakao_pay.src.main.sendpage.models.User
import com.example.kakao_pay.src.utils.Constants.TAG

class FriendRecyclerViewAdapter(friendRecyclerViewInterface: IFriendRecyclerView)
    : RecyclerView.Adapter<FriendViewHolder>() {

    private lateinit var countryCodeTitle: String
    private var friendList = ArrayList<User>()
    private var iFriendRecyclerView : IFriendRecyclerView? = null
    private lateinit var friendItemViewHolder : FriendViewHolder

    init {
        Log.d(TAG, "CountryCodeRecyclerViewAdapter - init() called")
        this.iFriendRecyclerView = friendRecyclerViewInterface
    }

    // 뷰홀더가 메모리에 올라갔을때
    // 뷰홀더와 레이아웃을 연결 시켜준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        friendItemViewHolder = FriendViewHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_friend, parent, false)
                , this.iFriendRecyclerView!!
        )
//        countryCodeItemViewHolder.bindWithView(countryCodeTitle)
//        countryCodeItemViewHolder.itemView.country_code_radio_button.isChecked = true

        return friendItemViewHolder
    }

    override fun getItemCount(): Int {
        return friendList.size
    }

    // 외부에서 어답터에 문자열 배열을 넣어준다.
    fun submitCode(countryCode: String){
        countryCodeTitle = countryCode
    }

    // 외부에서 어답터에 문자열 배열을 넣어준다.
    fun submitList(friendList: ArrayList<User>){
        this.friendList = friendList
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val dataItem = this.friendList[position]

        Log.d(TAG, "onBindViewHolder: "+dataItem.book_mark)
        holder.bindWithView(dataItem.nickname, dataItem.user_image, dataItem.book_mark)
    }
}