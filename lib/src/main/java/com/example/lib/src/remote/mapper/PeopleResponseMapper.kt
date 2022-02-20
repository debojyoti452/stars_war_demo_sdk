package com.example.lib.src.remote.mapper

import com.example.lib.src.remote.model.People
import com.example.lib.src.utils.ConverterUtils

/**
 * [PeopleResponseMapper] will work as Data Mapper (In general it will convert the data as per your
 * requirement).
 * [PeopleResponseMapper] is extended to [BaseMapper] Interface with take @FROM and @TO as Params.
 */
internal class PeopleResponseMapper : BaseMapper<People, List<String?>? > {
    override fun mapFrom(from: People): List<String?>? {
        return from.dataList?.let { ConverterUtils.getEyeColorFromPeople(it) }
    }
}
