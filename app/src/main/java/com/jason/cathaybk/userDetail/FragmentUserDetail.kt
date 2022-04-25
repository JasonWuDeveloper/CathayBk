package com.jason.cathaybk.userDetail

import android.view.View
import android.widget.TextView
import com.jason.cathaybk.R
import com.jason.cathaybk.base.BaseFragment

class FragmentUserDetail: BaseFragment() {

    private var mView: View? =null

    private lateinit var tVuserName: TextView
    private lateinit var tVlogin: TextView
    private lateinit var tVstaff: TextView
    private lateinit var tVlocal: TextView
    private lateinit var tVurl: TextView
    override fun getLayoutId(): Int {
       return R.layout.fragment_user_detail
    }

    override fun setUpViews(reValue: View) {
        super.setUpViews(reValue)

        mView = reValue

        tVuserName = reValue.findViewById(R.id.tv_user_name)
        tVlogin = reValue.findViewById(R.id.tv_login)
        tVstaff = reValue.findViewById(R.id.tv_staff)
        tVlocal = reValue.findViewById(R.id.tv_local)
        tVurl = reValue.findViewById(R.id.tv_url)

    }
}