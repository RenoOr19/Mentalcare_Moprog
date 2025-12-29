package com.example.mentalcare


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class test : AppCompatActivity() {

    private lateinit var tvQuestion: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var btnNext: Button

    private var currentQuestionIndex = 0
    private var totalScore = 0

    // Daftar pertanyaan
    private val questions = listOf(
        "Saya merasa sulit untuk beristirahat.",
        "Saya merasa tidak ada hal baik yang akan terjadi pada saya.",
        "Saya merasa mudah tersinggung atau marah.",
        "Saya merasa jantung berdebar tanpa alasan fisik.",
        "Saya merasa hidup ini tidak berharga."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        tvQuestion = findViewById(R.id.tvQuestion)
        radioGroup = findViewById(R.id.radioGroup)
        btnNext = findViewById(R.id.btnNext)

        showQuestion()

        btnNext.setOnClickListener {
            val selectedOptionId = radioGroup.checkedRadioButtonId

            if (selectedOptionId != -1) {
                val radioButton = findViewById<RadioButton>(selectedOptionId)
                val score = radioGroup.indexOfChild(radioButton)
                totalScore += score

                currentQuestionIndex++

                if (currentQuestionIndex < questions.size) {
                    showQuestion()
                } else {
                    // Pindah ke ResultActivity
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("TOTAL_SCORE", totalScore)
                    startActivity(intent)
                    finish()
                }
            } else {
                Toast.makeText(this, "Pilih salah satu jawaban!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showQuestion() {
        radioGroup.clearCheck()
        tvQuestion.text = questions[currentQuestionIndex]
        btnNext.text = if (currentQuestionIndex == questions.size - 1) "LIHAT HASIL" else "SELANJUTNYA"
    }
}