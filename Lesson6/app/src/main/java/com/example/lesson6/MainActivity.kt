package com.example.lesson6

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var color : Int = 0

        btn.setOnClickListener{
            color++
            if(color == 3) color = 0
            when(color){
                0 -> bg.setBackgroundResource(R.color.red)
                1 -> bg.setBackgroundResource(R.color.green)
                2 -> bg.setBackgroundResource(R.color.white)
            }
        }
    }
}


