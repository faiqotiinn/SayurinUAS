package com.example.sayursegar.repository

import com.example.sayursegar.dao.FreshDao
import com.example.sayursegar.model.Fresh
import kotlinx.coroutines.flow.Flow

class FreshRepository(private val freshDao: FreshDao) {
    val allFresh: Flow<List<Fresh>> = freshDao.getAllFresh()
    suspend fun insertFresh(fresh: Fresh) {
        freshDao.insertFresh(fresh)
    }
    suspend fun deleteFresh(fresh: Fresh){
        freshDao.deleteFresh(fresh)
    }
    suspend fun updateFresh(fresh: Fresh){
        freshDao.updateFresh(fresh)
    }
}