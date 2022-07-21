package Heror.hero.model

import com.google.gson.annotations.SerializedName

data class PowerStats(@SerializedName("intelligence") var inteligencia:String,
                      @SerializedName("strength") var fuerza:String,
                      @SerializedName("speed") var velocidad: String,
                      @SerializedName("durability") var durabilidad:String,
                      @SerializedName("power") var poder:String,
                      @SerializedName("combat") var combate: String)