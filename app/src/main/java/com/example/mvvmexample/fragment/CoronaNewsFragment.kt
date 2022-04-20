package com.example.mvvmexample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexample.adapter.NewsAdapter
import com.example.mvvmexample.databinding.FragmentCoronaNewsBinding
import com.example.mvvmexample.viewmodel.CoronaNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoronaNewsFragment : Fragment() {


    private val newsAdapter: NewsAdapter = NewsAdapter()

    private var _binding: FragmentCoronaNewsBinding? = null
    private val binding get() = _binding!!

    private val viewModel:CoronaNewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCoronaNewsBinding.inflate(inflater, container, false)
        binding.apply {
            this.lifecycleOwner=this@CoronaNewsFragment
            this.coronaNewsViewModel=viewModel

        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCoronaNews.observe(viewLifecycleOwner, Observer {
            newsAdapter.apply {
                this.newsList.addAll(it)
                binding.recylerView.apply {
                    this.adapter = newsAdapter
                    this.layoutManager = LinearLayoutManager(requireContext())
                    setHasFixedSize(true)
                }
            }
        })

    }




}