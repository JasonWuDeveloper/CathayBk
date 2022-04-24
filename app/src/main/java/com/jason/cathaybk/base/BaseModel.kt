package com.jason.cathaybk.base

import android.content.Context
import com.google.gson.Gson
import com.jason.cathaybk.network.NetworkManager

abstract class BaseModel {
    val mContext:Context? = null
    var gson = Gson()
    val networkManager = mContext?.let { NetworkManager.getInstance(it) }

    companion object {
        const val ERROR_OPERATION_FAILED = "network operation failed"
        const val ERROR_NO_DATA = "no data"
        const val ERROR_PARSE_FAILED = "parse failed"
        const val ERROR_UNKNOWN = "unknown error"
        const val ERROR_CONNECTION = "connection failed"
        const val ERROR_DISCONNECT = "Disconnect"
        const val ERROR_DOWNLOAD_PIC = "download pic failed"
    }
}