package com.example.mentalcare


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        val tvScoreNumber = findViewById<TextView>(R.id.tvScoreNumber)
        val tvResultStatus = findViewById<TextView>(R.id.tvResultStatus)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val btnBackHome = findViewById<Button>(R.id.btnBackHome)

        // Mengambil skor yang dikirim dari TestActivity
        val score = intent.getIntExtra("TOTAL_SCORE", 0)
        tvScoreNumber.text = score.toString()

        // Logika Diagnosis berdasarkan skor kuesioner
        when {
            score <= 5 -> {
                tvResultStatus.text = "Kesehatan Mental Baik"
                tvDescription.text = "Tetap pertahankan pola hidup sehat dan selalu berpikir positif!"
            }
            score <= 10 -> {
                tvResultStatus.text = "Gejala Stres Ringan"
                tvDescription.text = "Cobalah untuk meluangkan waktu beristirahat atau meditasi sejenak."
            }
            else -> {
                tvResultStatus.text = "Indikasi Stres Berat"
                tvDescription.text = "Sangat disarankan untuk berkonsultasi dengan psikolog atau orang terpercaya."
            }
        }

        btnBackHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Menghapus tumpukan activity agar kembali bersih ke Home
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}