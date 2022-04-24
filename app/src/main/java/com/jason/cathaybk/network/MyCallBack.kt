package com.jason.cathaybk.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface MyCallBack<T> : Callback<T> {
    override fun onFailure(call: Call<T>?, t: Throwable?) {
        handleConnectFailure()
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        if (response == null) {
            handleResponseNull()
            return
        }

        if (response.isSuccessful) {
            if (response.code() == 200) {
                handleResponse200(response)
            } else {
                handleResponseNot200(response)
            }
        } else {
            handleResponseNotSuccess(response)
        }
    }

    fun handleConnectFailure()
    fun handleResponseNull()
    fun handleResponse200(response: Response<T>)
    fun handleResponseNot200(response: Response<T>)
    fun handleResponseNotSuccess(response: Response<T>)
}