package com.jason.cathaybk.network

import android.content.Context
import com.jason.cathaybk.R
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

class NetworkManager private constructor(context: Context) {

    private val retrofit: Retrofit
    val services: APIService
    private val baseUrl: String
    private val interceptor = HttpLoggingInterceptor()

    init {

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .cookieJar(cookieJar)
            .addInterceptor(interceptor)
            .build()

        baseUrl = "https://api.github.com/"

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(StringConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        services = retrofit.create(APIService::class.java)

    }



    companion object {

        private var instance: NetworkManager? = null

        val cookieStore: MutableMap<String, List<Cookie>> = HashMap()
        val cookieJar: CookieJar = object : CookieJar {
            override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                cookieStore[url.host()] = cookies
            }

            override fun loadForRequest(url: HttpUrl): List<Cookie> {
                val cookies = cookieStore[url.host()]
                return cookies ?: ArrayList()
            }
        }

        @Synchronized
        fun getInstance(context: Context): NetworkManager {
            if (instance == null) {
                instance = NetworkManager(context)
            }
            return instance!!
        }

        @Synchronized
        fun getInstance(): NetworkManager {
            if (instance == null) {

                throw IllegalStateException(NetworkManager::class.java.simpleName + "is not initialized, call getInstance(...) first")

            }
            return instance!!
        }
    }

    class StringConverter : Converter<ResponseBody, String> {

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): String {
            return value.string()
        }

        companion object {
            val INSTANCE = StringConverter()
        }
    }

    class StringConverterFactory : Converter.Factory() {

        // 只實作ResponseBody轉換為String
        override fun responseBodyConverter(
            type: Type,
            annotations: Array<Annotation>,
            retrofit: Retrofit
        ): Converter<ResponseBody, *>? {
            return if (type === String::class.java) {
                StringConverter.INSTANCE
            } else null
            //其他類型不處理，返回null
        }

        companion object {
            val INSTANCE = StringConverterFactory()
            fun create(): StringConverterFactory {
                return INSTANCE
            }
        }
    }
}