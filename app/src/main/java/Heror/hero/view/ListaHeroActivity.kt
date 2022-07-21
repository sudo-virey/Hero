package Heror.hero.view

import Heror.hero.databinding.ActivityListaHeroBinding
import Heror.hero.extras.Constantes
import Heror.hero.model.HeroResponse
import Heror.hero.viewmodel.HeroViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaHeroActivity : AppCompatActivity(), HeroAdapter.onClickHero {

    private lateinit var binding:ActivityListaHeroBinding

    private lateinit var adapter: HeroAdapter
    private val heroImagenes = mutableListOf<HeroResponse>()//Lista de imagenes

    private val heroviewmodel :HeroViewModel by viewModels()

    private var idLoad: Int = 1;//posición de la carga de personajes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Manejo de cambios del modelo
        heroviewmodel.heroModel.observe(this, Observer {
            heroImagenes.add(it.copy())
            adapter.notifyDataSetChanged()
        })

        //Se inicializa la lista
        inicializarRecycler()

        //Llamado a la descarga del primer lote de imagenes
        controlCarga()
    }


    /**
     * Se construye la vista de la lista
     */
    private fun inicializarRecycler() {
        adapter = HeroAdapter( heroImagenes,this)
        binding.ListaHero.layoutManager = LinearLayoutManager(this)
        binding.ListaHero.adapter = adapter

        //Control de carga para la lista infinita
        binding.ListaHero.addOnScrollListener(scroll())
    }


    /**
     * Validación de la posición de la lista para la descarga de imagenes
     */
    private fun scroll(): RecyclerView.OnScrollListener {
        val scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                if (linearLayoutManager != null) {

                    //Total de items = a la posicion del ultimo item visto
                    if (linearLayoutManager?.itemCount == linearLayoutManager.findLastVisibleItemPosition() + 1) {
                        controlCarga()
                    }
                }
            }
        }
        return scrollListener;
    }

    /**
     * Coordinación de descarga de lotes de imagenes
     */
    private fun controlCarga(){
        //Recorrido de IDs
        for(i in idLoad..(idLoad+5) step 1){
            heroviewmodel.searchById(i)//Se llama a la descarga
        }
        idLoad += 6;//Se prepara para la descarga del sig lote
    }



    /**
     * Evento para el clic sobre el item
     */
    override fun onClickItem(position: Int) {
        val intent = Intent(this, DetalleActivity::class.java).apply {
            putExtra(Constantes().ID_HERO, position)
        }
        startActivity(intent)
    }
}