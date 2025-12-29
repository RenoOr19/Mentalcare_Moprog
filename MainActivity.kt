package com.example.mentalcare


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartTest = findViewById<Button>(R.id.btnStartTest)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // Tombol cepat ke halaman Tes
        btnStartTest.setOnClickListener {
            val intent = Intent(this, test::class.java)
            startActivity(intent)
        }

        // Logika Navigasi Bawah
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Sudah di Home", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_test -> {
                    startActivity(Intent(this, test::class.java))
                    true
                }
                R.id.nav_history -> {
                    // Nantinya arahkan ke HistoryActivity
                    Toast.makeText(this, "Fitur Riwayat Segera Datang", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}