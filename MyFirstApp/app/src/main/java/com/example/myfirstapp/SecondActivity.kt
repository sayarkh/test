package com.example.myfirstapp

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf

class SecondActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var btn: Button
    companion object {
        const val TOTAL_COUNT = "total_count"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textView = findViewById(R.id.textViewValue)
        btn = findViewById(R.id.button2)
        showNumber()
        Log.i("SecondActivity", "onCreate called")
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR;
    }

    private fun showNumber() {
      val count = intent.getIntExtra(TOTAL_COUNT, 0)
        textView.text = count.toString()
    }

    fun countMe(view: View) {
        val newVal = textView.text.toString()
        val intVal = newVal.toInt() + 1;
        textView.text = intVal.toString()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("KEY", textView.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        textView.text = savedInstanceState?.getString("KEY")
        super.onRestoreInstanceState(savedInstanceState)
    }







    override fun onResume() {
        super.onResume()
        Log.i("SecondActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("SecondActivity", "onPause called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("SecondActivity", "onStart called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("SecondActivity", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("SecondActivity", "onDestroy called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("SecondActivity", "onRestart called")
    }




}