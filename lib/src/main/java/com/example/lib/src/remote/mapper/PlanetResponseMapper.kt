package com.example.lib.src.remote.mapper

import com.example.lib.src.remote.model.BaseModel
import com.example.lib.src.remote.model.Planet

class PlanetResponseMapper : BaseMapper<BaseModel<Planet>, List<Planet>> {
    override fun mapFrom(from: BaseModel<Planet>): List<Planet> {
       return from.dataList ?: mutableListOf()
    }
}
