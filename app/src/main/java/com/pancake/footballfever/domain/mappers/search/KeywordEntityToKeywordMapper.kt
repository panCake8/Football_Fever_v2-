package com.pancake.footballfever.domain.mappers.search

import com.pancake.footballfever.data.local.database.entity.SearchKeywordEntity
import com.pancake.footballfever.domain.mappers.Mapper
import com.pancake.footballfever.domain.models.SearchKeyword
import javax.inject.Inject

class KeywordEntityToKeywordMapper @Inject constructor():
    Mapper<SearchKeywordEntity, SearchKeyword> {
    override fun map(input: SearchKeywordEntity): SearchKeyword {
        return SearchKeyword( input.keyword)
    }
}