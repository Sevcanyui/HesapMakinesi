package com.example.hesapmakinesi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        class MainActivity : AppCompatActivity() {

            private lateinit var tvResult: TextView
            private var currentInput = ""
            private var total = 0

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                tvResult = findViewById(R.id.tvResult)

                val numberButtons = listOf(
                    R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                    R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
                    R.id.btn8, R.id.btn9
                )

                for (id in numberButtons) {
                    findViewById<Button>(id).setOnClickListener {
                        currentInput += (it as Button).text
                        tvResult.text = currentInput
                    }
                }

                findViewById<Button>(R.id.btnAdd).setOnClickListener {
                    if (currentInput.isNotEmpty()) {
                        total += currentInput.toInt()
                        currentInput = ""
                        tvResult.text = "+"
                    }
                }

                findViewById<Button>(R.id.btnEqual).setOnClickListener {
                    if (currentInput.isNotEmpty()) {
                        total += currentInput.toInt()
                        currentInput = ""
                    }
                    tvResult.text = total.toString()
                }

                findViewById<Button>(R.id.btnClear).setOnClickListener {
                    total = 0
                    currentInput = ""
                    tvResult.text = "0"
                }
            }
        }

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}