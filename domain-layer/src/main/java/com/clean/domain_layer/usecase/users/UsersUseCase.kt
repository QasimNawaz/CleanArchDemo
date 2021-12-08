package com.clean.domain_layer.usecase.users

import androidx.paging.PagingData
import com.clean.domain_layer.model.DataItem
import com.clean.domain_layer.repository.UsersRepository
import com.clean.domain_layer.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val movieRepository: UsersRepository,
) : UseCase<Unit, Flow<@JvmSuppressWildcards PagingData<DataItem>>> {

    override fun execute(params: Unit) = movieRepository.getPagedUsers()
}