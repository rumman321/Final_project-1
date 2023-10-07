package com.example.final_project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.final_project1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var navController = findNavController(R.id.fragmentContainerView)
        binding.bottombar.setupWithNavController(navController)


        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout, R.string.nav_open, R.string.nav_close)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.drawerNav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bmiFragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                    Toast.makeText(this, "GOING TO BMI", Toast.LENGTH_SHORT).show()
                }


                R.id.tempFragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                    Toast.makeText(this, "GOING TO Tempreture", Toast.LENGTH_SHORT).show()
                }

                R.id.setting ->{
                    binding.drawerLayout.closeDrawers()
                    Toast.makeText(this, "GOING TO Setting", Toast.LENGTH_SHORT).show()
                }
                R.id.Share ->{
                    binding.drawerLayout.closeDrawers()
                    Toast.makeText(this, "Shareing", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            true
        }else super.onOptionsItemSelected(item)
    }
}