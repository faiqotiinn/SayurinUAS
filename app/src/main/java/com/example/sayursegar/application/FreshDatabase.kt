package com.example.sayursegar.application

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.sayursegar.dao.FreshDao
import com.example.sayursegar.model.Fresh

@Database(entities = [Fresh::class], version = 2, exportSchema = false)
abstract class FreshDatabase: RoomDatabase(){
    abstract fun freshDao(): FreshDao

    companion object{
        private var INSTANCE: FreshDatabase? = null

        private val migration1To2: Migration = object: Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
              database.execSQL("ALTER TABLE fresh_table ADD COLUMN latitude Double DEFAULT 0.0")
                database.execSQL("ALTER TABLE fresh_table ADD COLUMN longitude Double DEFAULT 0.0")
            }
        }
        fun getDatabase(context: Context): FreshDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FreshDatabase::class.java,
                    "fresh_database"
                )
                    .addMigrations(migration1To2)
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
