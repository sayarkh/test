package com.example.movies
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.movies.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    //    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavigation.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_AUTO
        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.mainFragment,
                R.id.favoritesFragment -> {}
                R.id.detailFragment -> {}
            }
        }

//        bottomNavigationView = binding.bottomNavigation
//
//        val mainFragment = MainFragment()
//        val favFragment = FavoritesFragment()
//        //setThatFragment(mainFragment)
//        bottomNavigationView.setOnNavigationItemSelectedListener {
//            when(it.itemId) {
//                R.id.mainFragment -> {
//                    setThatFragment(mainFragment)
//                }
//                R.id.favoritesFragment -> {
//                    setThatFragment(favFragment)
//                }
//                R.id.detailFragment -> {
//                    setThatFragment()
//                }
//            }
//            true
//        }

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

//    private fun setThatFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainerView, fragment)
//            .commit()
//    }

}