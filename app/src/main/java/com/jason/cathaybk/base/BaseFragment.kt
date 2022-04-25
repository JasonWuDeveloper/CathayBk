package com.jason.cathaybk.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.jason.cathaybk.R

abstract class BaseFragment: Fragment() {
private lateinit var mContainer: HorizontalScrollView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val reValue: View = inflater.inflate(getLayoutId(), null)
        setUpViews(reValue)
        return initView(reValue)
    }

    protected open fun initView(view: View): View? {


        onFragmentShow()
        return view
    }


    abstract fun getLayoutId(): Int

    override fun onHiddenChanged(hidden: Boolean) {
        if(!hidden) {
            onFragmentShow()
        }
        super.onHiddenChanged(hidden)
    }

    protected open fun onFragmentShow() {}

    protected open fun setUpViews(reValue: View) {}


    }


