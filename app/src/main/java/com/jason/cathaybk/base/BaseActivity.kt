package com.jason.cathaybk.base

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference

public abstract class BaseActivity: AppCompatActivity() {

    private var mToast:Toast? = null

    private class MainHandler(activity: BaseActivity) :Handler() {
        private val mActivity: WeakReference<BaseActivity> = WeakReference(activity)
        override fun handleMessage(msg: Message) {
            mActivity.get()?.onHandleMessage(msg)
        }
    }

    protected abstract fun onHandleMessage(msg: Message)

    private lateinit var mHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHandler = MainHandler(this)
    }



}

