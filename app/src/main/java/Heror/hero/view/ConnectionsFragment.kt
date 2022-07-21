package Heror.hero.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Heror.hero.R
import Heror.hero.databinding.FragmentConnectionsBinding
import Heror.hero.databinding.FragmentWorkBinding
import android.util.Log

class ConnectionsFragment : Fragment() {

    private  var _binding: FragmentConnectionsBinding? = null
    public val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentConnectionsBinding .inflate(inflater, container, false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (arguments != null){
            binding.detalleTxtGroupAffiliation.text = requireArguments().getString("group-affiliation","")
            binding.detalleTxtRelatives.text = requireArguments().getString("relatives","")
        }
    }

}