package com.example.kakao_pay.src.main.send.fragments.adapter

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.kakao_pay.src.main.send.DeliveryData
import com.example.kakao_pay.src.main.send.fragments.account.AccountFragment
import com.example.kakao_pay.src.main.send.fragments.friends.FriendFragment
import com.example.kakao_pay.src.main.send.fragments.friends.SetBookmarksList
import com.example.kakao_pay.src.main.send.fragments.usual.UsualFragment
import com.example.kakao_pay.src.main.send.fragments.usual.UsualFragmentDefault
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.User
import com.example.kakao_pay.src.main.send.fragments.recent.RecentFragment
import com.example.kakao_pay.src.main.send.fragments.recent.RecentFragmentDefault
import com.example.kakao_pay.src.main.send.fragments.usual.models.Bookmark
import com.example.kakao_pay.src.main.send.models.recentList.Recent
import com.example.kakao_pay.src.utils.Constants.TAG

class FragmentAdapter(private val recentList : ArrayList<Recent>?, private val friendsList : ArrayList<User>,
                      private val bookmarkList : ArrayList<Bookmark>?, fragmentManager: FragmentManager, private val parentFragment : DeliveryData)
    : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT), SetBookmarksList {

    private val list : ArrayList<Fragment> = ArrayList()
    private val friendFragment = FriendFragment(friendsList, this)
//    var friendsBookMarksList : ArrayList<User>? = null

    init {
        Log.d(TAG, "FragmentAdapter init: is called")
        if(bookmarkList!!.isEmpty()) {
            list.add(UsualFragmentDefault())
        }
        else {
            list.add(UsualFragment(bookmarkList)) }

        if(recentList!!.isEmpty()) {
            list.add(RecentFragmentDefault())
        } else {
            list.add(RecentFragment(recentList))
       }
        list.add(friendFragment)
        list.add(AccountFragment())
    }


    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun setBookmarksList(state : Boolean) {
        parentFragment.setList()

        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed({
            val newBookmarkList = parentFragment.getList()
            Log.d(TAG, "setBookmarksList: $newBookmarkList")
            if(newBookmarkList.isEmpty()) {
                list[0] = UsualFragmentDefault()
            }
            else {
                list[0] = UsualFragment(newBookmarkList)
            }
        }, 300)
    }
}