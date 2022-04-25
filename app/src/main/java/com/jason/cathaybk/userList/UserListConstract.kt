package com.jason.cathaybk.userList

import com.jason.cathaybk.userDetail.UserDetailModel

interface UserListConstract {

    interface View {

    }

    interface Prensenter {
        fun getLogin(): String
        fun getId(): Int
        fun getAvatarUrl(): String
        fun getSiteAdmin(): Boolean

    }

    interface Model {
        fun getLogin(): String
        fun getId(): Int
        fun getAvatarUrl(): String
        fun getSiteAdmin(): Boolean
        fun setOnGetUserListListener(listener: UserListModel.OnGetUserListListener)
        fun sendGetUserListRequest()
    }
}