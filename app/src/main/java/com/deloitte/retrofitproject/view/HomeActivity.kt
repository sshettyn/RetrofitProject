package com.deloitte.retrofitproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deloitte.retrofitproject.R
import com.deloitte.retrofitproject.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

  lateinit var homeViewModel: HomeViewModel

    //sample2
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    val progressBar: ProgressBar = findViewById(R.id.progressBar)
    progressBar.visibility = View.VISIBLE
    homeViewModel.getUser()!!.observe(this, Observer { albums ->
      progressBar.visibility = View.GONE
      val recyclerView: RecyclerView = findViewById(R.id.recycler)
      val albumAdapter = AlbumAdapter(albums)
      val layoutManager = LinearLayoutManager(applicationContext)
      recyclerView.layoutManager = layoutManager
      recyclerView.adapter = albumAdapter
    })
  }
}