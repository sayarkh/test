package com.example.myfirstapp

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var counter: TextView
    private lateinit var btnCount: Button
    private var cnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity", "onCreate Called")

        counter = findViewById(R.id.counter)
        btnCount = findViewById(R.id.btn_count)

        btnCount.setOnClickListener {
            cnt++
            counter.text = cnt.toString()
        }
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR;

    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart called")
    }

    fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello, Toast", Toast.LENGTH_SHORT)
        myToast.show()
    }
    fun randomMe(view: View) {
        val randomIntent = Intent(this, SecondActivity::class.java)
        val textValue = counter.text.toString()
        val intValue = textValue.toInt()

        randomIntent.putExtra(SecondActivity.TOTAL_COUNT,intValue)
        startActivity(randomIntent)
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause called")
    }

    /*fun countMe(view: View) {
        val countString = counter.toString()
        var count:Int = Integer.parseInt(countString)
        count++
        counter.text = count.toString()
    }*/
    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("KEY", counter.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        counter.text = savedInstanceState?.getString("KEY")
        super.onRestoreInstanceState(savedInstanceState)
    }
}