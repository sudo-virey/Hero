package Heror.hero.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Heror.hero.R
import Heror.hero.databinding.FragmentBiographyBinding
import Heror.hero.databinding.FragmentWorkBinding
import android.util.Log

class WorkFragment : Fragment() {

    private  var _binding: FragmentWorkBinding? = null
    public val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWorkBinding .inflate(inflater, container, false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (arguments != null){
            binding.detalleTxtOccupation.text = requireArguments().getString("occupation","")
            binding.detalleTxtBase.text = requireArguments().getString("base","")
        }
    }

}