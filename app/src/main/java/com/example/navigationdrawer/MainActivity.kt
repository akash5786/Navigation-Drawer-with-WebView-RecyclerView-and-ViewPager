package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
/*import com.example.navbar.FirstFragment*/
/*import com.example.navbar.SecondFragment*/
/*import com.example.navbar.ThirdFragment*/
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.os.Build.VERSION_CODES.O
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {
    @RequiresApi(O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailfab.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val recipients = arrayOf("abc@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
            intent.type = "text/html"
            intent.setPackage("com.google.android.gm")
            startActivity(Intent.createChooser(intent, "Send mail"))

        }
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        val notificationFragment = NotificationFragment()
        val contactUs = ContactUs()
        val privacyFragment = PrivacyFragment()
        val settingFragment = SettingFragment()

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val imgMenu = findViewById<ImageView>(R.id.imgMenu)

        val navView = findViewById<NavigationView>(R.id.navDrawer)
        navView.itemIconTintList = null
        imgMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.miHome -> setCurrentFragment(firstFragment)
                R.id.miMessages -> setCurrentFragment(secondFragment)
                R.id.miProfile -> setCurrentFragment(thirdFragment)
            }
            true
        }
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(firstFragment)
                R.id.profile -> setCurrentFragment(thirdFragment)
                R.id.notification -> setCurrentFragment(notificationFragment)
                R.id.contactus -> setCurrentFragment(contactUs)
                R.id.privacy -> setCurrentFragment(privacyFragment)
                R.id.setting -> setCurrentFragment(settingFragment)
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment, fragment)
            commit()
        }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
            return
        }
        super.onBackPressed()
    }
}