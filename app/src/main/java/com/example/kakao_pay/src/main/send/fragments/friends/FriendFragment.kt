package com.example.kakao_pay.src.main.send.fragments.friends

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentFriendsBinding
import com.example.kakao_pay.src.main.send.fragments.BookMarkService
import com.example.kakao_pay.src.main.send.fragments.IBookMarkView
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.User
import com.example.kakao_pay.src.main.send.fragments.account.GetSendLimitRequest
import com.example.kakao_pay.src.main.send.fragments.account.GetSendLimitResponse
import com.example.kakao_pay.src.main.send.fragments.account.GetSendLimitService
import com.example.kakao_pay.src.main.send.fragments.account.IGetSendLimitView
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_send.PostSendMoneyRequest
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_send.PostSendMoneyResponse
import com.example.kakao_pay.src.main.send.fragments.friends.recycler_view.FriendRecyclerViewAdapter
import com.example.kakao_pay.src.main.send.fragments.friends.models.recycler_view.IFriendRecyclerView
import com.example.kakao_pay.src.main.send.models.PostBookMarkRequest
import com.example.kakao_pay.src.main.send.models.PostBookMarkResponse
import com.example.kakao_pay.src.utils.Constants.TAG

class FriendFragment(private val friendsList : ArrayList<User>, private val fragmentAdapter : SetBookmarksList) :
    BaseFragment<FragmentFriendsBinding>(FragmentFriendsBinding::bind, R.layout.fragment_friends),
    IFriendRecyclerView, IBookMarkView, IPostSendView,
    IGetSendLimitView {

    var positionNow: Int = 0
    lateinit var myFriendsRecyclerViewAdapter : FriendRecyclerViewAdapter
    private var balance = 0
    private lateinit var limit :String
    lateinit var remitType : String
    lateinit var image : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val getSendLimit = GetSendLimitRequest(account = null, remit_type = "kao")
        GetSendLimitService(this).tryGetSendLimit(getSendLimit)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        myFriendsRecyclerViewAdapter = FriendRecyclerViewAdapter(this)
        myFriendsRecyclerViewAdapter.submitList(friendsList)
        myFriendsRecyclerViewAdapter.setItemClickListener(object : FriendRecyclerViewAdapter.OnItemClickListener{

            override fun onClickImg(v: View, position: Int, state: String) {
                image = friendsList[position].user_image
                val postBookmark = PostBookMarkRequest(
                        friend_number = friendsList[position].friend_number,
                        account = null,
                        remit_type = friendsList[position].remit_type,
                        book_mark = state
                )
                BookMarkService(this@FriendFragment).tryPostBookMark(postBookmark)
            }

            override fun onClickProfile(v: View, position: Int) {
                val bottomSheet = FriendsBottomSheet(this@FriendFragment, friendsList[position])
                bottomSheet.show(childFragmentManager, bottomSheet.tag)
//                val bottomsheetExam = dialog
            }
        })

        val myLinearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.friendsRecyclerView.apply {
            layoutManager = myLinearLayoutManager
            adapter = myFriendsRecyclerViewAdapter
        }

    }

    override fun onFriendItemClicked(position: Int) {
        Log.d(TAG, "onFriendItemClicked in  adapter: is called")
    }

    override fun onPostBookMarkSuccess(response: PostBookMarkResponse) {
        Log.d(TAG, "북마크 변경 완료: is called")
        fragmentAdapter.setBookmarksList(true)
    }

    override fun onPostBookMarkFailure(message: String) {
        Log.d(TAG, "onPostBookMarkFailure: is called $message")
    }

    fun sendCheck(user: User, money : String) {
        FriendsBottomSheetCheck(this, user, money)
    }

    fun sendMoney(user: User, money : String) {
        val sendRequest =
            PostSendMoneyRequest(
                friend_number =  user.friend_number,
                recipient = user.name,
                image = user.user_image,
                nickname = user.nickname,
                remit_bank_name = null,
                remit_account = null,
                payment_type = "페이머니",
                amount = money,
                remit_type = remitType

            )
        SendService(this).tryPostSend(sendRequest)
    }

    override fun onGetSendLimitSuccess(response: GetSendLimitResponse) {
        if(response.code == 1000) {
            limit = response.result.remit_limit
            remitType = response.result.remit_type
            balance = response.result.balance

        }
    }

    override fun onGetSendLimitFailure(message: String) {
        TODO("Not yet implemented")
    }



    override fun onPostSendSuccess(response: PostSendMoneyResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostSendFailure(message: String) {
        TODO("Not yet implemented")
    }

    fun gettingBalance(): Int {
        return balance
    }

    fun gettingLimit() : String {
        return limit
    }

    fun gettingImg() : String {
        return image
    }

}