package Heror.hero.view

import Heror.hero.R
import Heror.hero.model.HeroResponse
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HeroAdapter(val imagenes: List<HeroResponse>, private val click: onClickHero): RecyclerView.Adapter<HeroViewHolder>() {

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val item : HeroResponse =imagenes[position]
        holder.bind(item, click)
    }

    override fun getItemCount(): Int {
        return imagenes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
       val layoutInflater =LayoutInflater.from(parent.context)
        return HeroViewHolder(layoutInflater.inflate(R.layout.layout_item_hero, parent, false))
    }

    interface onClickHero{
        fun onClickItem(position:Int)
    }

}