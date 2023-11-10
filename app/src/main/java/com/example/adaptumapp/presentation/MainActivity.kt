package com.example.adaptumapp.presentation

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.adaptumapp.AdaptumApp
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.common.Navigator
import com.example.adaptumapp.presentation.common.ToolbarVisibilityListener
import com.example.adaptumapp.presentation.fragments.EventsFragment
import com.example.adaptumapp.presentation.fragments.HelpFragment
import com.example.adaptumapp.presentation.fragments.LoginFragment
import com.example.adaptumapp.presentation.fragments.ProfileFragment
import com.example.adaptumapp.presentation.fragments.TasksFragment
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), ToolbarVisibilityListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as AdaptumApp).appComponent.inject(this)
        setContentView(R.layout.activity_main)
        initToolbar()
        openTasksFragment()
//        openLoginFragment()
    }

    private fun initToolbar() {
        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        findViewById<NavigationView>(R.id.nav_view).setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_profile -> {
                    Navigator.navigateReplace(ProfileFragment(), supportFragmentManager)
                }

                R.id.nav_my_tasks -> {
                    Navigator.navigateReplace(TasksFragment(), supportFragmentManager)
                }

                R.id.nav_events -> {
                    Navigator.navigateReplace(EventsFragment(), supportFragmentManager)
                }

                R.id.nav_help -> {
                    Navigator.navigateReplace(HelpFragment(), supportFragmentManager)
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        val headerView = navigationView.getHeaderView(0)
        val navHeaderTextView = headerView.findViewById<View>(R.id.name_tv) as TextView
        navHeaderTextView.text = "Анфиса Питонова"

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        } else super.onOptionsItemSelected(item)
    }

    fun openTasksFragment(){
        Navigator.navigateReplace(TasksFragment(), supportFragmentManager)
    }

    fun openLoginFragment(){
        Navigator.navigateReplace(LoginFragment(), supportFragmentManager)
    }

    override fun showToolbar() {
        supportActionBar?.show()
    }

    override fun hideToolbar() {
        supportActionBar?.hide()
    }
}