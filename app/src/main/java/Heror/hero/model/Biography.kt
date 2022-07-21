package Heror.hero.model

import com.google.gson.annotations.SerializedName

data class Biography (@SerializedName("id") var idHero:Int,
                      @SerializedName("full-name") var fullname:String,
                      @SerializedName("alter-egos") var alter_egos: String,
                      @SerializedName("aliases") var alias:List<String>,
                      @SerializedName("place-of-birth") var lugar_nacimiento:String,
                      @SerializedName("first-appearance") var aparicion:String,
                      @SerializedName("publisher") var editotial:String,
                      @SerializedName("alignment") var alineacion:String
                      )