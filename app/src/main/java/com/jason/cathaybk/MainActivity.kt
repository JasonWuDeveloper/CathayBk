package com.jason.cathaybk

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.os.Message
import com.jason.cathaybk.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onHandleMessage(msg: Message) {
        TODO("Not yet implemented")
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_user_detail)
    }
}