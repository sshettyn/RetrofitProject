package com.deloitte.retrofitproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deloitte.retrofitproject.model.Albums
import com.deloitte.retrofitproject.repository.HomeActivityRepository

class HomeViewModel : ViewModel() {

  var albumLiveData: MutableLiveData<List<Albums>>? = null
  var homeActivityRepository: HomeActivityRepository? = null

  fun setHomeRepository(homeActivityRepository: HomeActivityRepository){
    this.homeActivityRepository = homeActivityRepository
  }

  fun getAlbums() : LiveData<List<Albums>>? {
    albumLiveData = homeActivityRepository?.getServicesApiCall()
    return albumLiveData
  }

}