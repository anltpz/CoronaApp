package com.example.mvvmexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mvvmexample.viewmodel.DataViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val dataViewModel: DataViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var navView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        var navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)


    }


}

