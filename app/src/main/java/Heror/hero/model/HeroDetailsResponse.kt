package Heror.hero.model

import com.google.gson.annotations.SerializedName

data class HeroDetailsResponse(
    @SerializedName("name") var nombre:String,
    @SerializedName("powerstats") var estadistica:PowerStats,
    @SerializedName("biography") var biografia:Biography,
    @SerializedName("appearance") var apariencia: Appearance,
    @SerializedName("work") var trabajo: Work,
    @SerializedName("connections") var conexion: Connections,
    @SerializedName("image") var imagen: Image)