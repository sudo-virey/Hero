package Heror.hero.view

import Heror.hero.databinding.ActivityDetalleBinding
import Heror.hero.extras.Constantes
import Heror.hero.model.APIService
import Heror.hero.model.HeroDetailsResponse
import Heror.hero.viewmodel.HeroViewModel
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding
    private var idview = 1;
    val supportFragment = supportFragmentManager
    lateinit var hero : HeroDetailsResponse

    private val heroviewmodel :HeroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Obtención del ID del personaje
        var idHero = intent.getIntExtra(Constantes().ID_HERO,0)

        //Solicitud de descarga de datos del personaje
        heroviewmodel.getImagenById(idHero)

        //Manejo de cambios del modelo
        heroviewmodel.heroDetailsModel.observe(this, Observer {
            Picasso.get().load(it.imagen.imagen).into(binding.detalleImgImage)//Descarga la imagen
            binding.detalleTxtNombre.text = it.nombre
            hero = it.copy()
            supportFragment.beginTransaction().replace(Heror.hero.R.id.fragmentContainerView, manegarFragment()).commit()
        })

        //Eventos para los botones de atras y siguiente
        binding.detalleBtnAtras.setOnClickListener{ acccionAtras() }
        binding.detalleBtnSiguiente.setOnClickListener{ accionSiguiente() }
    }


    /**
     * Manejado de idView ascendente
     */
    private fun accionSiguiente() {
        if(idview==5){
            idview = 1;
        }else{
            idview++;
        }
        supportFragment.beginTransaction().replace(Heror.hero.R.id.fragmentContainerView,manegarFragment()).commit()
    }

    /**
     * Manejado de idView descendente
     */
    private fun acccionAtras() {
        if(idview==1){
            idview = 5;
        }else{
            idview--;
        }
        supportFragment.beginTransaction().replace(Heror.hero.R.id.fragmentContainerView,manegarFragment()).commit()
    }

    /**
     * Responde con el Fragment correspondiente de acorde al idView
     */
    private fun manegarFragment(): Fragment {
        return when (idview) {
            1 -> getPowerstatsFragment()
            2 -> getBiographyFragment()
            3 -> getAppearanceFragment()
            4 -> getWorkFragment()
            5 -> getConnectionsFragment()
            else-> getPowerstatsFragment()
        }
    }

    /**
     * Eventos para la carga de parametros
     */
    fun getPowerstatsFragment():PowerstatsFragment{
        binding.detalleTxtTituloFragment.text ="Power Stats"
        val powerstatsFragment =  PowerstatsFragment()
        val bundle = Bundle()
        bundle.putString("intelligence",hero.estadistica.inteligencia)
        bundle.putString("strength",hero.estadistica.fuerza)
        bundle.putString("speed",hero.estadistica.velocidad)
        bundle.putString("durability",hero.estadistica.durabilidad)
        bundle.putString("power",hero.estadistica.poder)
        bundle.putString("combat",hero.estadistica.combate)
        powerstatsFragment.arguments = bundle
        return powerstatsFragment
    }

    fun getBiographyFragment():BiographyFragment{
        binding.detalleTxtTituloFragment.text ="Biography"
        val biographyFragment = BiographyFragment()
        val bundle = Bundle()
        bundle.putString("full-name",hero.biografia.fullname)
        bundle.putString("alter-egos",hero.biografia.alter_egos)
        bundle.putString("aliases", hero.biografia.alias.toString())
        bundle.putString("place-of-birth",hero.biografia.lugar_nacimiento)
        bundle.putString("first-appearance",hero.biografia.aparicion)
        bundle.putString("publisher",hero.biografia.editotial)
        bundle.putString("alignment",hero.biografia.alineacion)
        biographyFragment.arguments = bundle
        return biographyFragment
    }

    fun getAppearanceFragment():AppearanceFragment{
        binding.detalleTxtTituloFragment.text ="Appearance"
        val appearanceFragment = AppearanceFragment()
        val bundle = Bundle()
        bundle.putString("gender",hero.apariencia.genero)
        bundle.putString("race",hero.apariencia.raza)
        bundle.putString("height","${hero.apariencia.altura[0]}, ${hero.apariencia.altura[1]}")
        bundle.putString("weight","${hero.apariencia.peso[0]}, ${hero.apariencia.peso[1]}")
        bundle.putString("eye-color",hero.apariencia.color_ojos)
        bundle.putString("hair-color",hero.apariencia.color_cabello)
        appearanceFragment.arguments = bundle
        return appearanceFragment
    }

    fun getWorkFragment():WorkFragment{
        binding.detalleTxtTituloFragment.text ="Work"
        val workFragment = WorkFragment()
        val bundle = Bundle()
        bundle.putString("occupation",hero.trabajo.ocupacion)
        bundle.putString("base",hero.trabajo.base)
        workFragment.arguments = bundle
        return workFragment
    }

    fun getConnectionsFragment():ConnectionsFragment{
        binding.detalleTxtTituloFragment.text ="Connections"
        val connectionsFragment = ConnectionsFragment()
        val bundle = Bundle()
        bundle.putString("group-affiliation",hero.conexion.grupo)
        bundle.putString("relatives",hero.conexion.parientes)
        connectionsFragment.arguments = bundle
        return connectionsFragment
    }
    
    
    
    
    
    
    


}



