package com.example.lesson7_1



import android.content.Context
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
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


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

            imm.hideSoftInputFromWindow(btnSubmit.windowToken, 0)
        }

        btnChange.setOnClickListener(){
            val intent = Intent(this@MainActivity, Activity2::class.java)
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
