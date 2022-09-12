package com.deloitte.retrofitproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deloitte.retrofitproject.R
import com.deloitte.retrofitproject.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

  lateinit var homeViewModel: HomeViewModel


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    homeViewModel.getUser()!!.observe(this, Observer { albums ->
      val recyclerView: RecyclerView = findViewById(R.id.recycler)
      val albumAdapter = AlbumAdapter(albums)
      val layoutManager = LinearLayoutManager(applicationContext)
      recyclerView.layoutManager = layoutManager
      recyclerView.adapter = albumAdapter
    })
  }
}