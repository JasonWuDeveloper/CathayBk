package com.jason.cathaybk

import android.os.Bundle
import android.os.Message
import com.jason.cathaybk.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onHandleMessage(msg: Message) {
        TODO("Not yet implemented")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}
