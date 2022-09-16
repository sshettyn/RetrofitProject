package com.deloitte.retrofitproject.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.deloitte.retrofitproject.model.Albums
import com.deloitte.retrofitproject.repository.HomeActivityRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.AssertionError

class HomeViewModelTest {

  lateinit var homeViewModel: HomeViewModel

  @MockK
  lateinit var homeActivityRepository: HomeActivityRepository

  @get:Rule
  val rule = InstantTaskExecutorRule()

//sample 1
  @Before
  fun setUp(){
    MockKAnnotations.init(this,true)
    homeViewModel = HomeViewModel()
    homeViewModel.setHomeRepository(homeActivityRepository)
  }

  @Test
  fun testAlbums(){
    every { homeActivityRepository.getServicesApiCall() } returns
        MutableLiveData<List<Albums>>().apply {
          postValue(listOf(
            Albums(
            "1","2","song"
          )
          ))
        }
    homeViewModel.getAlbums()
    Assert.assertEquals(homeViewModel.albumLiveData?.value,listOf(
      Albums(
        "1","2","song"
      )
    ))
  }
}