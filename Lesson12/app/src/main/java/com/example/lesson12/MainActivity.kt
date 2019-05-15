package com.example.lesson12

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener {
    override fun onStartProgress() {
        Toast.makeText(this, "Start!",Toast.LENGTH_SHORT).show()
        progressBar.visibility = View.VISIBLE
    }

    override fun onStopProgress() {
        Toast.makeText(this, "Finish.",Toast.LENGTH_SHORT).show()
        progressBar.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = View.GONE
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragContainer,HomeFragment())
            .commit()
    }
}
