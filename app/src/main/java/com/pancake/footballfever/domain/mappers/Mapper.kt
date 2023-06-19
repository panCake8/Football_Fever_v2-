package com.pancake.footballfever.domain.mappers

interface Mapper<I, O> {
    fun map(input: I): O
}