package com.example.kakao_pay.src.main.sendpage

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentFriendsBinding
import com.example.kakao_pay.src.main.sendpage.models.GetFriendsResponse
import com.example.kakao_pay.src.main.sendpage.recycler_view.FriendRecyclerViewAdapter
import com.example.kakao_pay.src.main.sendpage.recycler_view.IFriendRecyclerView

class SendFragment : BaseFragment<FragmentFriendsBinding>(FragmentFriendsBinding::bind, R.layout.fragment_friends),
        IFriendRecyclerView, IFriendView{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FriendService(this).tryGetUsers()
    }




    override fun onFriendItemClicked(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onGetFriendsSuccess(response: GetFriendsResponse) {
        if(response.code == 1000) {

            val myFriendsRecyclerViewAdapter = FriendRecyclerViewAdapter(this)

            myFriendsRecyclerViewAdapter.submitList(response.result.user_list)

            val myLinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            binding.friendsRecyclerView.apply {
                layoutManager = myLinearLayoutManager
                adapter = myFriendsRecyclerViewAdapter
            }

        }
    }

    override fun onGetFriendsFailure(message: String) {
        TODO("Not yet implemented")
    }
}