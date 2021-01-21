package com.example.kakao_pay.src.main.send

import com.example.kakao_pay.src.utils.Constants.TAG
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentSendBinding
import com.example.kakao_pay.src.main.send.fragments.adapter.FragmentAdapter
import com.example.kakao_pay.src.main.send.fragments.friends.FriendService
import com.example.kakao_pay.src.main.send.fragments.friends.IFriendView
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.GetFriendsResponse
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.User
import com.example.kakao_pay.src.main.send.fragments.recent.IRecentView
import com.example.kakao_pay.src.main.send.fragments.recent.RecentService
import com.example.kakao_pay.src.main.send.fragments.usual.BookmarkService
import com.example.kakao_pay.src.main.send.fragments.usual.IGetBookmarkView
import com.example.kakao_pay.src.main.send.fragments.usual.models.Bookmark
import com.example.kakao_pay.src.main.send.fragments.usual.models.GetBookmarkResponse
import com.example.kakao_pay.src.main.send.models.recentList.GetRecentResponse
import com.example.kakao_pay.src.main.send.models.recentList.Recent

class SendFragment : BaseFragment<FragmentSendBinding>(FragmentSendBinding::bind, R.layout.fragment_send),
    IFriendView, IRecentView, IGetBookmarkView, DeliveryData {

    lateinit var adapter : FragmentAdapter
    lateinit var friendsList : ArrayList<User>
    lateinit var recentList : ArrayList<Recent>
    lateinit var bookmarkList : ArrayList<Bookmark>

    init {
        FriendService(this).tryGetUsers()
        RecentService(this).tryGetRecent()
        BookmarkService(this).tryGetBookmark()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.layoutUsual.setOnClickListener {
            binding.usualLine.setImageResource(R.drawable.rounded_black_line)
            binding.usual.setTextColor(ContextCompat.getColor(context!!, R.color.black))

            binding.friendsLine.setImageResource(R.drawable.rounded_white_line)
            binding.friends.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            binding.accountLine.setImageResource(R.drawable.rounded_white_line)
            binding.account.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            binding.recentLine.setImageResource(R.drawable.rounded_white_line)
            binding.recent.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            BookmarkService(this).tryGetBookmark()
            binding.fragmentViewpager.setCurrentItem(0, true)
        }

        binding.layoutRecent.setOnClickListener {

            binding.recentLine.setImageResource(R.drawable.rounded_black_line)
            binding.recent.setTextColor(ContextCompat.getColor(context!!, R.color.black))

            binding.usualLine.setImageResource(R.drawable.rounded_white_line)
            binding.usual.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            binding.accountLine.setImageResource(R.drawable.rounded_white_line)
            binding.account.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            binding.friendsLine.setImageResource(R.drawable.rounded_white_line)
            binding.friends.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            binding.fragmentViewpager.setCurrentItem(1, true)
        }

        binding.layoutFriends.setOnClickListener {

            binding.friendsLine.setImageResource(R.drawable.rounded_black_line)
            binding.friends.setTextColor(ContextCompat.getColor(context!!, R.color.black))

            binding.usualLine.setImageResource(R.drawable.rounded_white_line)
            binding.usual.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            binding.accountLine.setImageResource(R.drawable.rounded_white_line)
            binding.account.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            binding.recentLine.setImageResource(R.drawable.rounded_white_line)
            binding.recent.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))
//            FriendService(this).tryGetUsers()

            binding.fragmentViewpager.setCurrentItem(2, true)
        }

        binding.layoutAccount.setOnClickListener {
            binding.friendsLine.setImageResource(R.drawable.rounded_white_line)
            binding.friends.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            binding.usualLine.setImageResource(R.drawable.rounded_white_line)
            binding.usual.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            binding.accountLine.setImageResource(R.drawable.rounded_black_line)
            binding.account.setTextColor(ContextCompat.getColor(context!!, R.color.black))

            binding.recentLine.setImageResource(R.drawable.rounded_white_line)
            binding.recent.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

            binding.fragmentViewpager.setCurrentItem(3, true)
        }

        binding.fragmentViewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                when(position) {
                    0->{
                        binding.usualLine.setImageResource(R.drawable.rounded_black_line)
                        binding.usual.setTextColor(ContextCompat.getColor(context!!, R.color.black))

                        binding.friendsLine.setImageResource(R.drawable.rounded_white_line)
                        binding.friends.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

                        binding.accountLine.setImageResource(R.drawable.rounded_white_line)
                        binding.account.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

                        binding.recentLine.setImageResource(R.drawable.rounded_white_line)
                        binding.recent.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))
                    }
                    1->{
                        binding.recentLine.setImageResource(R.drawable.rounded_black_line)
                        binding.recent.setTextColor(ContextCompat.getColor(context!!, R.color.black))

                        binding.usualLine.setImageResource(R.drawable.rounded_white_line)
                        binding.usual.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

                        binding.accountLine.setImageResource(R.drawable.rounded_white_line)
                        binding.account.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

                        binding.friendsLine.setImageResource(R.drawable.rounded_white_line)
                        binding.friends.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))
                    }
                    2->{
                        binding.friendsLine.setImageResource(R.drawable.rounded_black_line)
                        binding.friends.setTextColor(ContextCompat.getColor(context!!, R.color.black))

                        binding.usualLine.setImageResource(R.drawable.rounded_white_line)
                        binding.usual.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

                        binding.accountLine.setImageResource(R.drawable.rounded_white_line)
                        binding.account.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

                        binding.recentLine.setImageResource(R.drawable.rounded_white_line)
                        binding.recent.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))
                    }
                    3->{
                        binding.friendsLine.setImageResource(R.drawable.rounded_white_line)
                        binding.friends.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

                        binding.usualLine.setImageResource(R.drawable.rounded_white_line)
                        binding.usual.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))

                        binding.accountLine.setImageResource(R.drawable.rounded_black_line)
                        binding.account.setTextColor(ContextCompat.getColor(context!!, R.color.black))

                        binding.recentLine.setImageResource(R.drawable.rounded_white_line)
                        binding.recent.setTextColor(ContextCompat.getColor(context!!, R.color.grayText))
                    }
                }
            }

        })

        val handler = Handler(Looper.getMainLooper())

        // 친구 불러오기랑 최근 목록 불러오기를 onViewCreated에서 호출 시 호출이 안 되는 에러 방지
        handler.postDelayed({
            adapter = FragmentAdapter(recentList,
                    friendsList, bookmarkList,
                    activity!!.supportFragmentManager, this)

            binding.fragmentViewpager.adapter = adapter
            binding.fragmentViewpager.clipToPadding = false
        }, 200)
    }

    override fun onGetFriendsSuccess(response: GetFriendsResponse) {
        if(response.code == 1000) {
                Log.d(TAG, "onGetFriendsSuccess: first")
                friendsList = response.result.user_list
        }
    }

    override fun onGetRecentSuccess(response: GetRecentResponse) {
        if(response.code == 1000) {
            recentList = response.result.recent_remit_list
        }
    }

    override fun onGetBookmarkSuccess(response: GetBookmarkResponse) {
        if(response.code == 1000) {
            bookmarkList = response.result.book_mark_list
        }
    }

    override fun onGetFriendsFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onGetRecentFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onGetBookmarkFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun setList() {

        BookmarkService(this).tryGetBookmark()
    }

    override fun getList(): ArrayList<Bookmark> {
        return bookmarkList
    }
}