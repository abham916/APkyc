package com.example.superheroessqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Hero {
    var name: String =""
    var gender: String = ""
    var power: Int = 0
    var image: Int = 0
}

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragContainer, HeroFragment())
            .commit()
    }
}