package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.SearchKeywordEntity
import com.pancake.footballfever.data.repository.search.SearchKeywordsRepository
import com.pancake.footballfever.domain.models.SearchKeyword
import javax.inject.Inject

class GetSearchKeywordsUseCase @Inject constructor(
    private val searchKeywordsRepository: SearchKeywordsRepository,
) {

    suspend fun getSearchKeywords():List<SearchKeyword>{
        return searchKeywordsRepository.getSearchKeywords().map{it.toSearchKeyword()}
    }

    suspend fun insertSearchKeywords(searchKeyword: SearchKeyword){
         searchKeywordsRepository.insertKeyword(searchKeyword.toSearchKeywordEntity())
    }
    private fun SearchKeywordEntity.toSearchKeyword(): SearchKeyword {
        return SearchKeyword(
           this.keyword
        )
    }

    private fun SearchKeyword.toSearchKeywordEntity():SearchKeywordEntity{
        return SearchKeywordEntity(
            null , this.keyword
        )
    }

}