package com.pancake.footballfever.data.repository.search

import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.local.database.entity.SearchKeywordEntity
import javax.inject.Inject


class SearchKeywordsRepositoryImpl @Inject constructor(
    private val footballDao: FootballDao
):SearchKeywordsRepository {

    override suspend fun insertKeyword(keyword: SearchKeywordEntity) {
        footballDao.insertSearchKeyword(keyword)
    }

    override suspend fun getSearchKeywords(): List<SearchKeywordEntity> {
      return footballDao.getAllSearchKeywords()
    }

}