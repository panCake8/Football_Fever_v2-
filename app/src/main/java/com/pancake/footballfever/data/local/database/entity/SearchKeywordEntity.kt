package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "KEYWORD_SEARCH_TABLE")
data class SearchKeywordEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null ,
    val keyword: String?
)

