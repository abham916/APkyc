package com.example.lesson8

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO Move to Activity2
        btnToB.setOnClickListener(){
            startActivity(Intent(this@MainActivity, Activity2::class.java))
        }

        // TODO Move to FragmentA
        btnToFragA.setOnClickListener(){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout1, FragmentA())
                .commit()
        }

        // TODO Move to FragmentB
        btnToFragB.setOnClickListener(){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout1, FragmentB())
                .commit()
        }
    }
}

class FragmentA : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_a,container,false)
    }
}

class FragmentB : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_b,container,false)
    }
}


