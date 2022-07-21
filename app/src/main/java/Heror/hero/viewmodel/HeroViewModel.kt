package Heror.hero.viewmodel

import Heror.hero.model.APIService
import Heror.hero.model.HeroDetailsResponse
import Heror.hero.model.HeroResponse
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroViewModel:ViewModel() {

    val heroModel = MutableLiveData<HeroResponse>()
    val heroDetailsModel = MutableLiveData<HeroDetailsResponse>()

    /**
     * Base url de la API
     */
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.superheroapi.com/api.php/1363651877463707/")
            .addConverterFactory(
                GsonConverterFactory
                .create()).build()
    }

    /**
     * Descarga el registro de la imagen
     */
    public fun searchById(idHero: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit()
                .create(APIService::class.java)
                .getAllImages("${idHero}/image")

            val hero = call.body()

            //Validación si el llamado fue correcto
            if(call.isSuccessful){
                if (hero != null) {
                    heroModel.postValue(hero)//Publicación del cambio en el modelo
                }
            }
        }
    }

    fun getImagenById(idHero:Int){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit()
                .create(APIService::class.java)
                .getHerodata("${idHero}")

            val hero = call.body()!!

            //Validación si el llamado fue correcto
            if(call.isSuccessful) {
                if (hero != null) {
                    heroDetailsModel.postValue(hero)//Publicación del cambio en el modelo
                }
            }
        }
    }


}