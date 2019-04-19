package com.example.lesson7_1



import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager

import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    var total: Int = 0
    var ave: Int = 0
    var grade: String = ""
    var java: Int = 0
    var network: Int = 0
    var database: Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener(){
            if(editTextJava.text.isNotEmpty())
                java = editTextJava.text.toString().toInt()
            else{
                java = 0
                editTextJava.setText("0")
            }
            if(editTextNetwork.text.isNotEmpty())
                network = editTextNetwork.text.toString().toInt()
            else{
                network = 0
                editTextNetwork.setText("0")
            }
            if(editTextDB.text.isNotEmpty())
                database = editTextDB.text.toString().toInt()
            else {
                database = 0
                editTextDB.setText("0")
            }

            total = setTotal(java, network, database)
            ave = setAve(java, network, database)
            grade = setGrade(ave)

            editTextTotal.setText(total.toString())
            editTextAve.setText(ave.toString())
            editTextGrade.setText(grade)

            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(btnSubmit.windowToken, 0)
        }

        btnChange.setOnClickListener(){
            startActivity(Intent(this@MainActivity, Activity2::class.java))
            finish()
        }
    }

    private fun setTotal(vararg score: Int): Int{
        var sum = 0

        for(i in score)  sum += i
        return sum
    }

    private fun setAve(vararg score: Int): Int{
        var sum = 0

        for(i in score)
            sum += i
        return sum/score.size
    }

    private fun setGrade(score: Int): String{
        return when{
            score < 60 -> "F"
            score < 70 -> "D"
            score < 80 -> "C"
            score < 90 -> "B"
            else -> "A"
        }
    }

}
