package com.example.lib.src.remote.model

import com.example.lib.src.utils.ConverterUtils
import com.google.gson.annotations.SerializedName

data class People(
    @SerializedName("count")
    val itemCount: Int ?= null,
    @SerializedName("next")
    val nextPage: String ?= null,
    @SerializedName("previous")
    val prevPage: String ?= null,
    @SerializedName("results")
    val dataList: List<PeopleData> ?= null,
) {
    fun getEyeColors() : List<String?>? {
        return dataList?.let { ConverterUtils.getEyeColorFromPeople(it) }
    }
}

data class PeopleData(

	@field:SerializedName("films")
	val films: List<String?>? = null,

	@field:SerializedName("homeworld")
	val homeworld: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("skin_color")
	val skinColor: String? = null,

	@field:SerializedName("edited")
	val edited: String? = null,

	@field:SerializedName("created")
	val created: String? = null,

	@field:SerializedName("mass")
	val mass: String? = null,

	@field:SerializedName("vehicles")
	val vehicles: List<String?>? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("hair_color")
	val hairColor: String? = null,

	@field:SerializedName("birth_year")
	val birthYear: String? = null,

	@field:SerializedName("eye_color")
	val eyeColor: String? = null,

	@field:SerializedName("species")
	val species: List<Any?>? = null,

	@field:SerializedName("starships")
	val starships: List<String?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("height")
	val height: String? = null
)
