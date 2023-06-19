package com.pancake.footballfever.domain.usecases

interface Mapper<I, O> {
    fun map(input: I): O
}