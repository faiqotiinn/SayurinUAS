package com.example.sayursegar.application

import android.app.Application
import com.example.sayursegar.application.FreshDatabase
import com.example.sayursegar.repository.FreshRepository

class FreshApp: Application() {
    val database by lazy {FreshDatabase.getDatabase(this) }
    val repository by lazy { FreshRepository(database.freshDao() )}
}