package com.deloitte.retrofitproject.retrofit

import com.deloitte.retrofitproject.model.Albums
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

  @GET("albums")
  fun getAlbums() : Call<List<Albums>>
}