package com.example.kakao_pay.src.main.send.fragments

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.main.send.models.PostBookMarkRequest
import com.example.kakao_pay.src.main.send.models.PostBookMarkResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookMarkService(val view: IBookMarkView) {
    fun tryPostBookMark(postBookMark: PostBookMarkRequest){
        val iBookMark = ApplicationClass.sRetrofit
                .create(IBookMarkRetrofit::class.java)
        iBookMark.postBookmark(friend_number = postBookMark.friend_number,
                                remit_type = postBookMark.remit_type,
                                account = postBookMark.account,
                                book_mark = postBookMark.book_mark)
            .enqueue(object : Callback<PostBookMarkResponse> {
            override fun onResponse(
                    call: Call<PostBookMarkResponse>,
                    response: Response<PostBookMarkResponse>
            ) {
                view.onPostBookMarkSuccess(response.body() as PostBookMarkResponse)
            }

            override fun onFailure(call: Call<PostBookMarkResponse>, t: Throwable) {
                view.onPostBookMarkFailure(t.message ?: "통신 오류")
            }
        })
    }
}