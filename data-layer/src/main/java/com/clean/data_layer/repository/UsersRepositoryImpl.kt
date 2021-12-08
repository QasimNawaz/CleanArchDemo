package com.clean.data_layer.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.clean.data_layer.local.SharedPrefs
import com.clean.data_layer.remote.WebService
import com.clean.domain_layer.repository.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val webService: WebService,
    private val sharedPrefs: SharedPrefs
) : UsersRepository {

    override fun getPagedUsers() = Pager(
        PagingConfig(pageSize = 10, prefetchDistance = 4)
    ) {
        UserPagingSource(webService, sharedPrefs)
    }.flow

}