package Heror.hero.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getAllImages(@Url url:String):Response<HeroResponse>

    @GET
    suspend fun getHerodata(@Url url:String):Response<HeroDetailsResponse>
}