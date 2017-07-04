package com.example.lagoru.sombrerro

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.lagoru.sombrerro.mvi.MviFragment
import com.example.lagoru.sombrerro.navigator.FragmentNavigator

class MainActivity : AppCompatActivity() {

    var fragmentInContainer: MviFragment<*, *, *>? = null

    var fragmentNavigator: FragmentNavigator = FragmentNavigator(supportFragmentManager)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //mTextMessage!!.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        fragmentInContainer = fragmentNavigator.openMainScreen()
    }
}
