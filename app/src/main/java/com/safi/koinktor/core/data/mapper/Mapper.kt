package com.safi.koinktor.core.data.mapper


interface Mapper<R,E>{
    fun mapFromApiResponse(type:R):E
}

fun<R,E> mapFromApiResponse(response: R, mapper: Mapper<R, E>): E {
    return mapper.mapFromApiResponse(response)
}