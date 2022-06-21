package com.example.calculator

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var workingsTV: TextView
    private lateinit var resultsTV: TextView
    private var canAddOperation = false
    private var canAddDecimal = true
    private var commaPosition = 0
    private lateinit var equalsButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        equalsButton = findViewById(R.id.equalsButton)
        workingsTV = findViewById(R.id.workingsTV)
        resultsTV = findViewById(R.id.resultsTV)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR;
    }


    fun numberAction(view: View) {
        if(view is Button) {
            if (view.text == ".") {
                if(canAddDecimal) {
                    workingsTV.append(view.text)
                    canAddDecimal = false
                }
            } else
                workingsTV.append(view.text)
            canAddOperation = true
        }
    }

    fun operationAction(view: View) {
        if(view is Button && canAddOperation) {
            workingsTV.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }

    fun allClearAction(view: View) {
        workingsTV.text = ""
        resultsTV.text = ""
        canAddDecimal = true
    }
    fun equalsAction(view: View) {
        resultsTV.text = calculateResults()
        }

    private fun calculateResults(): String {
        val digitsOperators = digitsOperators()
        if (digitsOperators.isEmpty()) return ""
        val timesDivision = timesDivisionCalculate(digitsOperators)
        if (timesDivision.isEmpty()) return ""
        val result = addSubtractCalculate(timesDivision)
        return result.toString()
    }

    private fun addSubtractCalculate(passedList: MutableList<Any>): Float {
        var result = passedList[0] as Float
        for(i in passedList.indices) {
            if(passedList[i] is Char && i != passedList.lastIndex ) {
                val operator = passedList[i]
                val nextDigit = passedList[i + 1] as Float
                if(operator == '+')
                    result += nextDigit
                if(operator == '-')
                    result -= nextDigit
            }
        }
        return result

    }

    private fun timesDivisionCalculate(passedList: MutableList<Any>): MutableList<Any> {
        var  list = passedList
        while (list.contains('x') || list.contains('/')) {
            list = calcTimesDiv(list)
        }
        return list
    }

    private fun calcTimesDiv(passedList: MutableList<Any>): MutableList<Any> {
        val newList = mutableListOf<Any>()
        var restartIndex = passedList.size
        for(i in passedList.indices) {
            if(passedList[i] is Char && i != passedList.lastIndex && i < restartIndex) {
                val operator = passedList[i]
                val prevDigit = passedList[i - 1] as Float
                val nextDigit = passedList[i + 1] as Float
                Log.d("error", "$prevDigit")
                when(operator) {
                    'x' -> {
                        newList.add(prevDigit * nextDigit)
                        restartIndex = i + 1
                    }
                    '/' -> {
                        newList.add(prevDigit / nextDigit)
                        restartIndex = i + 1
                    }
                    else -> {
                        newList.add(prevDigit)
                        newList.add(operator)
                    }
                }
            }
            if(i > restartIndex)
                newList.add(passedList[i])
        }
        return newList
    }

    private fun digitsOperators(): MutableList<Any> {
        var currentDigit = ""
        var list = mutableListOf<Any>()
        for(character in workingsTV.text) {
            if(character.isDigit() || character == '.') {
                currentDigit += character
            }
            else {
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(character)
            }
        }

        if(currentDigit != "" && currentDigit != ".") {
            list.add(currentDigit.toFloat())
        }
        return list
    }

    fun backSpaceAction(view: View) {
        val length = workingsTV.length()
        if(length > 0) {
            workingsTV.text = workingsTV.text.subSequence(0, length-1)
            canAddDecimal = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("KEY", workingsTV.text.toString())
            putString("KEY", resultsTV.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        workingsTV.text = savedInstanceState?.getString("KEY")
        resultsTV.text = savedInstanceState?.getString("KEY")
        super.onRestoreInstanceState(savedInstanceState)
    }
}