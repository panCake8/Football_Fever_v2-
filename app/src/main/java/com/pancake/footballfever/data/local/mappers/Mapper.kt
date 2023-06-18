package com.pancake.footballfever.data.local.mappers

interface Mapper<I, O> {
    fun map(input: I): O
}