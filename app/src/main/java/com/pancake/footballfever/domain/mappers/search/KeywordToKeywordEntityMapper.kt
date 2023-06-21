package com.pancake.footballfever.domain.mappers.search

import com.pancake.footballfever.data.local.database.entity.SearchKeywordEntity
import com.pancake.footballfever.domain.mappers.Mapper
import com.pancake.footballfever.domain.models.SearchKeyword
import javax.inject.Inject

class KeywordToKeywordEntityMapper @Inject constructor():
    Mapper<SearchKeyword, SearchKeywordEntity> {
    override fun map(input: SearchKeyword): SearchKeywordEntity {
        return SearchKeywordEntity(null , input.keyword)
    }
}