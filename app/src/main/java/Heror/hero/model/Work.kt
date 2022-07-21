package Heror.hero.model

import com.google.gson.annotations.SerializedName

data class Work ( @SerializedName("occupation") var ocupacion:String,
                  @SerializedName("base") var base:String)