package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.repository.search.SearchKeywordsRepository
import com.pancake.footballfever.domain.mappers.search.KeywordEntityToKeywordMapper
import com.pancake.footballfever.domain.mappers.search.KeywordToKeywordEntityMapper
import com.pancake.footballfever.domain.models.SearchKeyword
import javax.inject.Inject

class GetSearchKeywordsUseCase @Inject constructor(
    private val searchKeywordsRepository: SearchKeywordsRepository,
    private val keywordEntityToKeywordMapper: KeywordEntityToKeywordMapper,
    private val keywordToKeywordEntityMapper: KeywordToKeywordEntityMapper
) {

    suspend fun getSearchKeywords():List<SearchKeyword>{
        return searchKeywordsRepository.getSearchKeywords().map(keywordEntityToKeywordMapper::map)
    }

    suspend fun insertSearchKeywords(searchKeyword: SearchKeyword){
         searchKeywordsRepository.insertKeyword(searchKeyword.let { keywordToKeywordEntityMapper.map(it)})
    }

}