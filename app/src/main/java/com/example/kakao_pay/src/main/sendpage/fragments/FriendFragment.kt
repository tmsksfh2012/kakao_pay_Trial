package com.example.kakao_pay.src.main.sendpage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.RecyclerviewMoreViewBinding
import com.example.kakao_pay.src.main.sendpage.IFriendView
import com.example.kakao_pay.src.main.sendpage.models.GetFriendsResponse
import com.example.kakao_pay.src.main.sendpage.recycler_view.FriendRecyclerViewAdapter
import com.example.kakao_pay.src.main.sendpage.recycler_view.IFriendRecyclerView

class FriendFragment : BaseFragment<RecyclerviewMoreViewBinding>(RecyclerviewMoreViewBinding::bind, R.layout.recyclerview_more_view),
    IFriendRecyclerView, IFriendView {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_friends, container, false)



        return view
    }

    override fun onFriendItemClicked(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onGetFriendsSuccess(response: GetFriendsResponse) {
//        if(response.code == 1000) {
//
//            val myFriendsRecyclerViewAdapter = FriendRecyclerViewAdapter(this)
//
//            myFriendsRecyclerViewAdapter.submitList(response.result.user_list)
//
//            val myLinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//
//            binding.friendsRecyclerView.apply {
//                layoutManager = myLinearLayoutManager
//                adapter = myFriendsRecyclerViewAdapter
//            }
//
//        }
    }

    override fun onGetFriendsFailure(message: String) {
        TODO("Not yet implemented")
    }
}