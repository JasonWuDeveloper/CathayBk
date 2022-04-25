package com.jason.cathaybk.userDetail

import com.jason.cathaybk.base.BaseModel
import com.jason.cathaybk.network.MyCallBack
import retrofit2.Response

class UserDetailModel:UserDetailConstract.Model, BaseModel() {

    interface OnGetUserDetailListener {
        fun onGetUserDetailRequestSuccess(response: String)
        fun onGetUserDetailFailed(error: String)

    }

    private lateinit var mOnGetUserDetailListener: OnGetUserDetailListener

    override fun setOnGetUserDetailListener(listener: OnGetUserDetailListener) {
        mOnGetUserDetailListener = listener
    }
    override fun sendGetUserDetailRequest() {
       networkManager
           .services
           .apiUserDetail("")
           .enqueue(object : MyCallBack<String> {
               override fun handleConnectFailure() {
                   mOnGetUserDetailListener.onGetUserDetailFailed(ERROR_CONNECTION)
               }

               override fun handleResponseNull() {
                   mOnGetUserDetailListener.onGetUserDetailFailed("NO DATA")
               }

               override fun handleResponse200(response: Response<String>) {
                   val s = response.body().toString()
                   mOnGetUserDetailListener.onGetUserDetailRequestSuccess(s)
               }

               override fun handleResponseNot200(response: Response<String>) {
                   TODO("Not yet implemented")
               }

               override fun handleResponseNotSuccess(response: Response<String>) {
                   TODO("Not yet implemented")
               }

           })
    }


}