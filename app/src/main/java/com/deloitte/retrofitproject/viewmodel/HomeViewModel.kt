package com.deloitte.retrofitproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deloitte.retrofitproject.model.Albums
import com.deloitte.retrofitproject.repository.HomeActivityRepository

class HomeViewModel : ViewModel() {

  var albumLiveData: MutableLiveData<List<Albums>>? = null

  fun getUser() : LiveData<List<Albums>>? {
    albumLiveData = HomeActivityRepository.getServicesApiCall()
    return albumLiveData
  }

}