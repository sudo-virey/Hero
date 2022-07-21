package Heror.hero.model

import com.google.gson.annotations.SerializedName

data class Connections (@SerializedName("group-affiliation") var grupo:String,
                        @SerializedName("relatives") var parientes:String)