package Heror.hero.view

import Heror.hero.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Heror.hero.databinding.ActivityDetalleBinding.inflate
import Heror.hero.databinding.ActivityListaHeroBinding.inflate
import Heror.hero.databinding.FragmentPowerstatsBinding
import Heror.hero.databinding.FragmentWorkBinding.inflate
import Heror.hero.model.PowerStats
import android.util.Log

class PowerstatsFragment : Fragment() {


    private  var _binding: FragmentPowerstatsBinding? = null
    public val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPowerstatsBinding .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (arguments != null){
            binding.detalleTxtIntelligence.text = requireArguments().getString("intelligence","")
            binding.detalleTxtStrength.text = requireArguments().getString("strength","")
            binding.detalleTxtSpeed.text = requireArguments().getString("speed","")
            binding.detalleTxtDurability.text = requireArguments().getString("durability","")
            binding.detalleTxtPower.text = requireArguments().getString("power","")
            binding.detalleTxtCombat.text = requireArguments().getString("combat","")
        }
    }
}