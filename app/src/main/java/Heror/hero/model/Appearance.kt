package Heror.hero.model

import com.google.gson.annotations.SerializedName

data class Appearance (@SerializedName("gender") var genero:String,
                       @SerializedName("race") var raza:String,
                       @SerializedName("height") var altura:List<String>,
                       @SerializedName("weight") var peso:List<String>,
                       @SerializedName("eye-color") var color_ojos:String,
                       @SerializedName("hair-color") var color_cabello:String)