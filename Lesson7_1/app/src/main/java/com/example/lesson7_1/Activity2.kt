package com.example.lesson7_1

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_2.*


class Activity2 : AppCompatActivity() {

    var total: Int = 0
    var ave: Int = 0
    var grade: String = ""
    var java: Int = 0
    var network: Int = 0
    var database: Int = 0
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)


        btnSubmit2.setOnClickListener(){
            if(editTextJava2.text.isNotEmpty())
                java = editTextJava2.text.toString().toInt()
            else{
                java = 0
                editTextJava2.setText("0")
            }
            if(editTextNetwork2.text.isNotEmpty())
                network = editTextNetwork2.text.toString().toInt()
            else{
                network = 0
                editTextNetwork2.setText("0")
            }
            if(editTextDB2.text.isNotEmpty())
                database = editTextDB2.text.toString().toInt()
            else {
                database = 0
                editTextDB2.setText("0")
            }

            total = setTotal(java, network, database)
            ave = setAve(java, network, database)
            grade = setGrade(ave)

            editTextTotal2.setText(total.toString())
            editTextAve2.setText(ave.toString())
            editTextGrade2.setText(grade)

            imm.hideSoftInputFromWindow(btnSubmit2.windowToken, 0)
        }

        btnChange2.setOnClickListener(){
            val intent = Intent(this@Activity2, MainActivity::class.java)
            finish()
            startActivity(intent)
        }

    }


    fun setTotal(vararg score: Int): Int{
        var sum = 0

        for(i in score)
            sum += i
        return sum
    }

    fun setAve(vararg score: Int): Int{
        var sum = 0

        for(i in score)
            sum += i
        return sum/score.size
    }

    fun setGrade(score: Int): String{
        when{
            score < 60 -> return "F"
            score < 70 -> return "D"
            score < 80 -> return "C"
            score < 90 -> return "B"
            else -> return "A"
        }
    }

}

