package com.example.mvvmexample.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mvvmexample.viewmodel.DataViewModel
import com.example.mvvmexample.databinding.FragmentTotalDataBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TotalDataFragment : Fragment() {

    private val dataViewModel: DataViewModel by viewModels()
    private var _binding: FragmentTotalDataBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTotalDataBinding.inflate(inflater, container, false)

        binding.mainViewModel=dataViewModel
        binding.textView.text="aaaa"
        binding.lifecycleOwner=viewLifecycleOwner;

        val view = binding.root
        return view

    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }



}
