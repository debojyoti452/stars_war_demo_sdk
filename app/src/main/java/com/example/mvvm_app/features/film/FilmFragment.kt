package com.example.mvvm_app.features.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_app.adapter.FilmAdapter
import com.example.mvvm_app.base.BaseFragment
import com.example.mvvm_app.databinding.FragmentFilmBinding
import com.example.mvvm_app.features.vms.MainViewModel
import com.example.mvvm_app.utils.Extensions.show

class FilmFragment : BaseFragment<FragmentFilmBinding>() {
    private val viewModel: MainViewModel by activityViewModels()
    private val filmAdapter by lazy { FilmAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.filmRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = filmAdapter
        }

        viewModel.getFilmData()
    }

    override fun vmObserver() {
        viewModel.filmData.observe(viewLifecycleOwner) {
            binding.filmRV.show(true)
            if (it != null) {
                filmAdapter.addData(it)
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            binding.filmRV.show(false)
            Toast.makeText(requireContext(), it.second, Toast.LENGTH_LONG).show()
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.show(it)
            binding.filmRV.show(show = !it)
        }
    }

    override fun onDeviceBack() {
        findNavController().popBackStack()
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): FragmentFilmBinding {
        return FragmentFilmBinding.inflate(inflater, container, false)
    }
}
