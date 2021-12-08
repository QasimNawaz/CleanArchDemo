package com.clean.domain_layer.repository

import androidx.paging.PagingData
import com.clean.domain_layer.model.DataItem
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getPagedUsers(): Flow<PagingData<DataItem>>
}