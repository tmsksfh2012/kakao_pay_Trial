package com.example.kakao_pay.src.main.send.fragments.usual

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentUsualBinding
import com.example.kakao_pay.src.main.send.fragments.usual.models.Bookmark
import com.example.kakao_pay.src.main.send.fragments.usual.recycler_view.IUsualRecyclerView
import com.example.kakao_pay.src.main.send.fragments.usual.recycler_view.UsualRecyclerViewAdapter

class UsualFragment(var friendsList : ArrayList<Bookmark>)
    : BaseFragment<FragmentUsualBinding>(FragmentUsualBinding::bind, R.layout.fragment_usual),
    IUsualRecyclerView{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UsualRecyclerViewAdapter(this)
        adapter.submitList(friendsList)

        val myGridLayoutManager = GridLayoutManager(context, 4)

        binding.recyclerViewFriendsUsual.adapter = adapter
        binding.recyclerViewFriendsUsual.layoutManager = myGridLayoutManager
    }

    override fun onUsualItemClicked(position: Int) {
        TODO("Not yet implemented")
    }
}