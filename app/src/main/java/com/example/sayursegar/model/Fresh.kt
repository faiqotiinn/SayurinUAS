package com.example.sayursegar.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "fresh_table")
data class Fresh (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val address: String,
    val type: String,
    val latitude: Double?,
    val longitude: Double?
    //menambah data latitude dan longtitude
) : Parcelable