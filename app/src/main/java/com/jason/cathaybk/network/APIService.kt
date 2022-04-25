package com.jason.cathaybk.network

import com.jason.cathaybk.data.User
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface APIService {
    @FormUrlEncoded
    @GET()
    fun apiUserList(): Call<List<User.UserItem>>

    @FormUrlEncoded
    @GET("")
    fun apiUserDetail(
        @Query("token") token:String
    ):Call<String>

    @GET("/MemberAPI/signupCheck.php?")
    fun memberCheck(
        @Query("account") account: String,
        @Query("nickname") nickname: String,
        @Query("email") email: String)
            : Call<String>


}