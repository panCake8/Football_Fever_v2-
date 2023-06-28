package com.pancake.footballfever.data.repository.search

import com.pancake.footballfever.data.local.database.entity.SearchKeywordEntity

interface SearchKeywordsRepository {

    suspend fun insertKeyword(keyword: SearchKeywordEntity)

    suspend fun getSearchKeywords(): List<SearchKeywordEntity>

    suspend fun deleteAllKeyword()

}