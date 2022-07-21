package Heror.hero.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Heror.hero.R
import Heror.hero.databinding.FragmentBiographyBinding
import Heror.hero.databinding.FragmentPowerstatsBinding
import android.util.Log

class BiographyFragment : Fragment() {
    private  var _binding: FragmentBiographyBinding? = null
    public val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentBiographyBinding .inflate(inflater, container, false)
        return binding.root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (arguments != null){
            binding.detalleTxtFullName.text = requireArguments().getString("full-name","")
            binding.detalleTxtAlterEgos.text = requireArguments().getString("alter-egos","")
            binding.detalleTxtAlices.text = requireArguments().getString("aliases","")
            binding.detalleTxtPlaceOfBirth.text = requireArguments().getString("place-of-birth","")
            binding.detalleTxtFirstAppearance.text = requireArguments().getString("first-appearance","")
            binding.detalleTxtPublisher.text = requireArguments().getString("publisher","")
            binding.detalleTxtAlignment.text = requireArguments().getString("alignment","")
        }
    }

}