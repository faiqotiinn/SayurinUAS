package com.example.sayursegar

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameField: EditText
    private lateinit var passField: EditText
    private lateinit var loginButton: Button
    private lateinit var registtextView: TextView
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Mengambil referensi ke elemen-elemen UI
        usernameField = findViewById(R.id.usernameField)
        passField = findViewById(R.id.passField)
        loginButton = findViewById(R.id.loginButton)
        registtextView = findViewById(R.id.registtextView)

//        Log.d("Registration", "Name: $Username")
//        Log.d("Registration", "Password: $Password")

        sharedPreferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE)

        // Menambahkan listener pada tombol login
        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passField.text.toString()

            // Lakukan validasi login di sini
            if (isValidLogin(username, password)) {
                // Jika login berhasil, pindah ke HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Jika login gagal, tampilkan pesan kesalahan atau action yang sesuai
                Toast.makeText(this, "Invalid login credentials", Toast.LENGTH_SHORT).show()
            }
        }

        registtextView.setOnClickListener {
            // Aksi yang dijalankan saat teks "or Register" diklik
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidLogin(username: String, password: String): Boolean {
        // Mengambil data registrasi dari SharedPreferences
        val savedUsername = sharedPreferences.getString("username", "username")
        val savedPassword = sharedPreferences.getString("password", "password")

        // Melakukan validasi login berdasarkan data yang tersimpan
        return username == savedUsername && password == savedPassword

    }
}

