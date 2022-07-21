package Heror.hero.model

import com.google.gson.annotations.SerializedName

data class HeroResponse(
    @SerializedName("id") var idHero:Int,
    @SerializedName("name") var nombre:String,
    @SerializedName("url") var imagen: String)