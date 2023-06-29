package com.pancake.footballfever.utilities

sealed class DataState<out T>{

    data class Success<T>(val data:List<T>):DataState<T>()

    data class Error(val message:String):DataState<Nothing>()

    object Loading:DataState<Nothing>()

    object Empty:DataState<Nothing>()

    fun toDate():List<T>? = if (this is Success) data else null

    object ShowKeywordSuggests : DataState<Nothing>()

}
