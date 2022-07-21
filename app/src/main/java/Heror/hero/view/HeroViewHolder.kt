package Heror.hero.view

import Heror.hero.databinding.LayoutItemHeroBinding
import Heror.hero.model.HeroResponse
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class HeroViewHolder(view : View): RecyclerView.ViewHolder(view)  {

    private val binding = LayoutItemHeroBinding.bind(view)
    fun bind(image: HeroResponse,onclik: HeroAdapter.onClickHero){
        Picasso.get().load(image.imagen).into(binding.layoutItemHeroImage)//Descarga la imagen

        binding.layoutItemHeroNombre.text= image.nombre//Asignación del nombre

        binding.root.setOnClickListener{onclik.onClickItem(image.idHero)}//Asignación del evento onclik
    }


}