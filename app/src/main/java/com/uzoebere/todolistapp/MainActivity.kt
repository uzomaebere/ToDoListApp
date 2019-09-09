package com.uzoebere.todolistapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment







class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private lateinit var toolbar: ActionBar
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var fragment: Fragment
        when (item.itemId) {
            R.id.navigation_task -> {
            //    textMessage.setText(R.string.title_task)
                fragment = TaskFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_calendar -> {
            //    textMessage.setText(R.string.title_calendar)
                fragment = CalendarFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
            //    textMessage.setText(R.string.title_settings)
                fragment = SettingsFragment()
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val actionBar = supportActionBar
        actionBar?.title = "My Lists"
    //    textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        loadFragment(TaskFragment())
    }
}
