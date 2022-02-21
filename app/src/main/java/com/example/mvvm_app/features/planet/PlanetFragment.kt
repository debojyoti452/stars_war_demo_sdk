package com.example.mvvm_app.features.planet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_app.adapter.PopulationAdapter
import com.example.mvvm_app.base.BaseFragment
import com.example.mvvm_app.databinding.FragmentPlanetBinding
import com.example.mvvm_app.features.vms.MainViewModel
import com.example.mvvm_app.utils.Extensions.show

class PlanetFragment : BaseFragment<FragmentPlanetBinding>() {

    private val viewModel: MainViewModel by activityViewModels()
    private val populationAdapter by lazy { PopulationAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.planetRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = populationAdapter
        }
        viewModel.getPlanetData()
    }

    override fun vmObserver() {
        viewModel.populationData.observe(viewLifecycleOwner) {
            binding.planetRV.show(true)
            if (it != null) {
                populationAdapter.addData(it)
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            binding.planetRV.show(false)
            Toast.makeText(requireContext(), it.second, Toast.LENGTH_LONG).show()
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.show(it)
            binding.planetRV.show(show = !it)
        }
    }

    override fun onDeviceBack() {
        findNavController().popBackStack()
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlanetBinding {
        return FragmentPlanetBinding.inflate(inflater, container, false)
    }

}
