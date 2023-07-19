package com.example.sayursegar.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.sayursegar.model.Fresh
import kotlinx.coroutines.flow.Flow

@Dao
interface FreshDao {
    @Query("SELECT * FROM 'fresh_table' ORDER BY name ASC")
    fun getAllFresh(): Flow<List<Fresh>>

    @Insert
    suspend fun insertFresh(fresh: Fresh)

    @Delete
    suspend fun deleteFresh(fresh: Fresh)

    @Update
    suspend fun updateFresh(fresh: Fresh)
}