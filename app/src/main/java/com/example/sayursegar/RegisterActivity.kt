package com.example.sayursegar

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sayursegar.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var fullnameeditText: EditText
    private lateinit var unameeditText: EditText
    private lateinit var passeditText: EditText
    private lateinit var registButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fullnameeditText = findViewById(R.id.fullnameeditText)
        unameeditText = findViewById(R.id.unameeditText)
        passeditText = findViewById(R.id.PasseditText)
        registButton = findViewById(R.id.loginButton)

        registButton.setOnClickListener {
            val fullName = fullnameeditText.text.toString().trim()
            val username = unameeditText.text.toString().trim()
            val password = passeditText.text.toString().trim()

//            Log.d("Registration", "Name: $Username")
//            Log.d("Registration", "Password: $Password")

            // Validasi form registrasi dan penyimpanan ke SharedPreferences
            if (fullName.isEmpty() || username.isEmpty() ||password.isEmpty()){
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("fullname", fullName)
                editor.putString("username", username)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
