package com.clean.data_layer.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.clean.data_layer.local.SharedPrefs
import com.clean.data_layer.remote.WebService
import com.clean.domain_layer.model.DataItem
import retrofit2.HttpException
import java.io.IOException

class UserPagingSource(
    private val webService: WebService,
    private val sharedPrefs: SharedPrefs
) : PagingSource<Int, DataItem>() {

    //todo https://developer.android.com/topic/libraries/architecture/paging/test
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, DataItem> {
        return try {

            val nextPageNumber = params.key ?: 1
            val response = webService.getUsers(
                page = nextPageNumber,
                auth = sharedPrefs.getToken()
            ).body() ?: run { return LoadResult.Error(Throwable()) }

            val nextPage = if (response.page!! < response.totalPages!!) response.page!! + 1 else null
            LoadResult.Page(
                data = response.data!!,
                prevKey = null, // Only paging forward.
                nextKey = nextPage
            )
        } catch (e: IOException) {
            // IOException for network failures.
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            // HttpException for any non-2xx HTTP status codes.
            return LoadResult.Error(e)
        }
    }

    // anchorPage is the initial page, so just return null.
    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? = null
}