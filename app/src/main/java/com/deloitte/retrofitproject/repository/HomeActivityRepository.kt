package com.deloitte.retrofitproject.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.deloitte.retrofitproject.model.Albums
import com.deloitte.retrofitproject.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object  HomeActivityRepository {
  val albumData = MutableLiveData<List<Albums>>()

  fun getServicesApiCall(): MutableLiveData<List<Albums>> {
    val call = RetrofitClient.apiInterface.getAlbums()

    call.enqueue(object : Callback<List<Albums>>{
      override fun onResponse(call: Call<List<Albums>>, response: Response<List<Albums>>) {
          albumData.postValue(response.body())
      }

      override fun onFailure(call: Call<List<Albums>>, t: Throwable) {

      }

    })


    return albumData
  }
}