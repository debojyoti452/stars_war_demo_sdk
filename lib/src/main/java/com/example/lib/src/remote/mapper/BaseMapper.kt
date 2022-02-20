package com.example.lib.src.remote.mapper

internal interface BaseMapper<FROM, TO> {

    fun mapFrom(from: FROM): TO

    fun mapFromList(from: List<FROM>): List<TO> = from.map {
        mapFrom(from = it)
    }
}
