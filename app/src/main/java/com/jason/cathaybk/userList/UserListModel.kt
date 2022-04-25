package com.jason.cathaybk.userList

import android.content.Context
import com.jason.cathaybk.base.BaseModel
import com.jason.cathaybk.data.User
import com.jason.cathaybk.network.MyCallBack
import com.jason.cathaybk.userDetail.UserDetailModel
import retrofit2.Call
import retrofit2.Response

class UserListModel(): UserListConstract.Model, BaseModel() {
    interface OnGetUserListListener {
        fun onGetUserListRequestSuccess(response: String)
        fun onGetUserListFailed(error: String)

    }

    private lateinit var mOnGetUserListListener: OnGetUserListListener
    override fun getLogin(): String {
        return String()
    }

    override fun getId(): Int {
        var id = 0
        return id
    }

    override fun getAvatarUrl(): String {
        return String()
    }

    override fun getSiteAdmin(): Boolean {
        return true
    }

    override fun setOnGetUserListListener(listener: OnGetUserListListener) {
        mOnGetUserListListener = listener
    }

    override fun sendGetUserListRequest() {
        networkManager
            .services
            .apiUserList()
            .enqueue(object : MyCallBack<List<User.UserItem>> {
                override fun handleConnectFailure() {
                    mOnGetUserListListener.onGetUserListFailed(ERROR_CONNECTION)
                }

                override fun handleResponseNull() {
                    mOnGetUserListListener.onGetUserListFailed("NO DATA!")
                }

                override fun handleResponse200(response: Response<List<User.UserItem>>) {
                  val s = response.body().toString()
                    mOnGetUserListListener.onGetUserListRequestSuccess(s)
                }

                override fun handleResponseNot200(response: Response<List<User.UserItem>>) {
                    mOnGetUserListListener.onGetUserListFailed(ERROR_CONNECTION)
                }

                override fun handleResponseNotSuccess(response: Response<List<User.UserItem>>) {
                    mOnGetUserListListener.onGetUserListFailed("RESPONSE ERROR")
                }

            })
    }
}

private fun <T> Call<T>.enqueue(myCallBack: MyCallBack<String>) {

}
