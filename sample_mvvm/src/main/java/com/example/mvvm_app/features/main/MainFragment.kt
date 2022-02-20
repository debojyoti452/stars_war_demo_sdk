package com.example.mvvm_app.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mvvm_app.R
import com.example.mvvm_app.base.BaseFragment
import com.example.mvvm_app.databinding.FragmentMainBinding
import com.example.mvvm_app.features.vms.NavigationViewModel
import com.example.mvvm_app.utils.enums.NavEnum

class MainFragment : BaseFragment<FragmentMainBinding>(), View.OnClickListener {

    private val navViewModel: NavigationViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.planetBtn.setOnClickListener(this)
        binding.peopleBtn.setOnClickListener(this)
        binding.filmBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.peopleBtn -> {
                navViewModel.screenChange(NavEnum.PEOPLE_SCREEN)
            }

            R.id.planetBtn -> {
                navViewModel.screenChange(NavEnum.PLANET_SCREEN)
            }

            R.id.filmBtn -> {
                navViewModel.screenChange(NavEnum.FILM_SCREEN)
            }
        }
    }

    override fun vmObserver() {

    }

    override fun onDeviceBack() {

    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

}
