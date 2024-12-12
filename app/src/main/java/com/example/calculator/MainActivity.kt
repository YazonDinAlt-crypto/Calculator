package com.example.calculator

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var calculatorButton: Button
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.result_text_view)
        calculatorButton = findViewById(R.id.calculator_button)

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val resultIntent = result.data
                val resultString = resultIntent?.getStringExtra("result")
                resultTextView.text = resultString
            }
        }

        calculatorButton.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}