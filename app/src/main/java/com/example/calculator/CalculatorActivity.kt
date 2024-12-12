package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {

    private lateinit var num1EditText: EditText
    private lateinit var num2EditText: EditText
    private lateinit var operationTextView: TextView
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button
    private lateinit var sendDataButton: Button

    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        num1EditText = findViewById(R.id.num1_edit_text)
        num2EditText = findViewById(R.id.num2_edit_text)
        operationTextView = findViewById(R.id.operation_text_view)
        addButton = findViewById(R.id.add_button)
        subtractButton = findViewById(R.id.subtract_button)
        multiplyButton = findViewById(R.id.multiply_button)
        divideButton = findViewById(R.id.divide_button)
        sendDataButton = findViewById(R.id.send_data_button)

        addButton.setOnClickListener {
            operation = "+"
            operationTextView.text = "+"
        }

        subtractButton.setOnClickListener {
            operation = "-"
            operationTextView.text = "-"
        }

        multiplyButton.setOnClickListener {
            operation = "*"
            operationTextView.text = "*"
        }

        divideButton.setOnClickListener {
            operation = "/"
            operationTextView.text = "/"
        }

        sendDataButton.setOnClickListener {
            val num1 = num1EditText.text.toString().toDouble()
            val num2 = num2EditText.text.toString().toDouble()
            var result = 0.0

            when (operation) {
                "+" -> result = num1 + num2
                "-" -> result = num1 - num2
                "*" -> result = num1 * num2
                "/" -> result = num1 / num2
            }

            val intent = Intent()
            intent.putExtra("result", result.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}