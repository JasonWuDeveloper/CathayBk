package com.jason.cathaybk.userList

class UserListPresenter:UserListConstract.Prensenter {

    private val model:UserListConstract.Model = UserListModel()
    override fun getLogin(): String {
        return model.getLogin()
    }

    override fun getId(): Int {
        return model.getId()
    }

    override fun getAvatarUrl(): String {
        return model.getAvatarUrl()
    }

    override fun getSiteAdmin(): Boolean {
        return model.getSiteAdmin()
    }
}