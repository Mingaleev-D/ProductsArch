package com.example.productsarch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.productsarch.R
import com.example.productsarch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
   private lateinit var navController: NavController

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(binding.root)


      val navHostFragment =
          supportFragmentManager.findFragmentById(R.id.mainFragmentContainerView) as NavHostFragment
      navController = navHostFragment.navController
      setupWithNavController(binding.bottomNavigationView, navController)
   }


}
