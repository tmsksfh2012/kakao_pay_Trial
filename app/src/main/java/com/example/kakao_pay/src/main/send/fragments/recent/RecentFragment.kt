package com.example.kakao_pay.src.main.send.fragments.recent

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentRecentBinding
import com.example.kakao_pay.src.main.send.fragments.recent.recycler_view.IRecentRecyclerView
import com.example.kakao_pay.src.main.send.fragments.recent.recycler_view.RecentRecyclerViewAdapter
import com.example.kakao_pay.src.main.send.models.recentList.GetRecentResponse
import com.example.kakao_pay.src.main.send.models.recentList.Recent

class RecentFragment(private val recentList : ArrayList<Recent>) :
        BaseFragment<FragmentRecentBinding>(FragmentRecentBinding::bind, R.layout.fragment_recent),
        IRecentRecyclerView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myRecentRecyclerViewAdapter = RecentRecyclerViewAdapter(this)

        myRecentRecyclerViewAdapter.submitList(recentList)

        val myLinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recentRecyclerView.apply {
            layoutManager = myLinearLayoutManager
            adapter = myRecentRecyclerViewAdapter
        }
    }

    override fun onRecentItemClicked(position: Int) {
        TODO("Not yet implemented")
    }


}