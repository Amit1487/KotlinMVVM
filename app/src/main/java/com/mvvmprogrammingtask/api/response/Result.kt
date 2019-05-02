package com.mvvmprogrammingtask.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("classification")
    @Expose
    var classification: String? = null
    @SerializedName("designation")
    @Expose
    var designation: String? = null
    @SerializedName("average_height")
    @Expose
    var averageHeight: String? = null
    @SerializedName("skin_colors")
    @Expose
    var skinColors: String? = null
    @SerializedName("hair_colors")
    @Expose
    var hairColors: String? = null
    @SerializedName("eye_colors")
    @Expose
    var eyeColors: String? = null
    @SerializedName("average_lifespan")
    @Expose
    var averageLifespan: String? = null
    @SerializedName("homeworld")
    @Expose
    var homeworld: String? = null
    @SerializedName("language")
    @Expose
    var language: String? = null
    @SerializedName("people")
    @Expose
    var people: List<String>? = null
    @SerializedName("films")
    @Expose
    var films: List<String>? = null
    @SerializedName("created")
    @Expose
    var created: String? = null
    @SerializedName("edited")
    @Expose
    var edited: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null

}
