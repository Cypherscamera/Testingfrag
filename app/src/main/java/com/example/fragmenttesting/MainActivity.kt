package com.example.fragmenttesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragmenttesting.Fragments.Homefrag
import com.example.fragmenttesting.Fragments.Lookfrag
import com.example.fragmenttesting.Fragments.Scrollfrag
import com.example.fragmenttesting.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val homefrag = Homefrag()
    private val lookfrag = Lookfrag()
    private val scrollfrag = Scrollfrag()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomnav : BottomNavigationView = findViewById(R.id.bottomnav)
        loadfrag(homefrag)
        bottomnav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.Chat -> loadfrag(scrollfrag)
                R.id.Look -> loadfrag(lookfrag)
                R.id.home -> loadfrag(homefrag)
            }
            true
        }
    }
    private fun loadfrag(fragment: Fragment){
        if (fragment!= null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragcontainer, fragment)
            transaction.commit()
        }
    }
}