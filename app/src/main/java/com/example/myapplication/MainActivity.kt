package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var resultText: TextView
    private lateinit var addBtn: Button
    private lateinit var subtractBtn: Button
    private lateinit var multiplyBtn: Button
    private lateinit var divideBtn: Button
    private lateinit var percentBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        resultText = findViewById(R.id.resultText)
        addBtn = findViewById(R.id.addBtn)
        subtractBtn = findViewById(R.id.subtractBtn)
        multiplyBtn = findViewById(R.id.multiplyBtn)
        divideBtn = findViewById(R.id.divideBtn)
        percentBtn = findViewById(R.id.percentBtn)

        addBtn.setOnClickListener {
            performOperation(Operation.ADD)
        }

        subtractBtn.setOnClickListener {
            performOperation(Operation.SUBTRACT)
        }

        multiplyBtn.setOnClickListener {
            performOperation(Operation.MULTIPLY)
        }

        divideBtn.setOnClickListener {
            performOperation(Operation.DIVIDE)
        }

        percentBtn.setOnClickListener {
            performOperation(Operation.PERCENT)
        }
    }

    private fun performOperation(operation: Operation) {
        val num1Str = number1.text.toString()
        val num2Str = number2.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = num1Str.toDoubleOrNull()
        val num2 = num2Str.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            Operation.ADD -> num1 + num2
            Operation.SUBTRACT -> num1 - num2
            Operation.MULTIPLY -> num1 * num2
            Operation.DIVIDE -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                } else {
                    num1 / num2
                }
            }
            Operation.PERCENT -> {
                // Calculate num1 percent of num2, for example:
                // if num1=20 and num2=50, result = (20/100)*50 = 10
                (num1 / 100) * num2
            }
        }

        resultText.text = "Result: $result"
    }

    enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, PERCENT
    }
}
