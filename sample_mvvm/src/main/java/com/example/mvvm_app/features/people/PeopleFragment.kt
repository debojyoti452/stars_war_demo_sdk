package com.example.mvvm_app.features.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_app.adapter.EyeColorAdapter
import com.example.mvvm_app.base.BaseFragment
import com.example.mvvm_app.databinding.FragmentPeopleBinding
import com.example.mvvm_app.features.vms.MainViewModel
import com.example.mvvm_app.utils.Extensions.show

class PeopleFragment : BaseFragment<FragmentPeopleBinding>() {

    private val viewModel: MainViewModel by activityViewModels()
    private val eyeAdapter by lazy { EyeColorAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.eyePeopleRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = eyeAdapter
        }
        viewModel.getPeopleData()
    }

    override fun vmObserver() {
        viewModel.peopleEyeData.observe(viewLifecycleOwner) {
            binding.eyePeopleRV.show(true)
            eyeAdapter.addData(it)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            binding.eyePeopleRV.show(false)
            Toast.makeText(requireContext(), it.second, Toast.LENGTH_LONG).show()
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.show(it)
            binding.eyePeopleRV.show(show = !it)
        }
    }

    override fun onDeviceBack() {
        findNavController().popBackStack()
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPeopleBinding {
        return FragmentPeopleBinding.inflate(inflater, container, false)
    }
}
