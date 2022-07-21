package Heror.hero.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Heror.hero.R
import Heror.hero.databinding.FragmentAppearanceBinding
import Heror.hero.databinding.FragmentBiographyBinding
import android.util.Log

class AppearanceFragment : Fragment() {
    private  var _binding: FragmentAppearanceBinding? = null
    public val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAppearanceBinding .inflate(inflater, container, false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (arguments != null){
            binding.detalleTxtGender.text = requireArguments().getString("gender","")
            binding.detalleTxtRace.text = requireArguments().getString("race","")
            binding.detalleTxtHeight.text = requireArguments().getString("height","")
            binding.detalleTxtWeight.text = requireArguments().getString("weight","")
            binding.detalleTxtEyeColor.text = requireArguments().getString("eye-color","")
            binding.detalleTxtHairColor.text = requireArguments().getString("hair-color","")
        }
    }


}