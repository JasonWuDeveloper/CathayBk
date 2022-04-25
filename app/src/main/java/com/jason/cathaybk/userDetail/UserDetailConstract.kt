package com.jason.cathaybk.userDetail

interface UserDetailConstract {

    interface View {

    }

    interface Prensenter {
       fun initDetail()

    }

    interface Model {
        fun setOnGetUserDetailListener(listener: UserDetailModel.OnGetUserDetailListener)
        fun sendGetUserDetailRequest()
    }
}