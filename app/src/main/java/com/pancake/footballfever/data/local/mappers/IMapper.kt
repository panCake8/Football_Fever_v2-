package com.pancake.footballfever.data.local.mappers

interface IMapper<I, O> {
    fun map(input: I): O
}