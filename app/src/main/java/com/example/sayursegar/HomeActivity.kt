package com.example.sayursegar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.sayursegar.ui.FirstFragment
import com.example.sayursegar.ui.SecondFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val MenuToko = findViewById<RelativeLayout>(R.id.MenuToko)
        MenuToko.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, FirstFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            // Kode untuk menu 1
            // Untuk membuka MenuToko
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val MenuInfo = findViewById<RelativeLayout>(R.id.MenuInfo)
        MenuInfo.setOnClickListener {
            // Kode untuk menu 2
            // Untuk membuka MenuInfo
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
