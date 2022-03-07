package com.example.districtofbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class testActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        /*BottomNavigationView.OnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.HomeNavigation->{
                    true
                }
                R.id.FavoriteNavigation->{
                    true
                }
                R.id.AddBookNavigation->{
                    true
                }
                R.id.SearchNavigation->{
                    true
                }
                R.id.ProfileNavigation->{
                    true
                }
                else-> false
            }
        }*/
    }
}