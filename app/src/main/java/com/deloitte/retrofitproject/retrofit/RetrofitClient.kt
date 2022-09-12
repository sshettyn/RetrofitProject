package com.deloitte.retrofitproject.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


  const val baseUrl = "https://jsonplaceholder.typicode.com/"

  val retrofitClient: Retrofit.Builder by lazy {

    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    val okhttpClient = OkHttpClient.Builder()
    okhttpClient.addInterceptor(logging)

    Retrofit.Builder()
      .baseUrl(baseUrl)
      .client(okhttpClient.build())
      .addConverterFactory(GsonConverterFactory.create())
  }

  val apiInterface: ApiInterface by lazy {
    retrofitClient
      .build()
      .create(ApiInterface::class.java)
  }

}