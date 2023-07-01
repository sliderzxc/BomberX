package com.main.bomber.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.main.bomber.presentation.viewmodel.BomberViewModel
import com.main.core.R
import com.main.core.data.BaseFragment
import com.main.core.databinding.FragmentBomberBinding

class BomberFragment : BaseFragment<BomberViewModel>() {

    override val binding by lazy { FragmentBomberBinding.inflate(layoutInflater) }
    override val viewModelClass = BomberViewModel::class.java

    private val COUNTRY_CODES = arrayOf("380", "")
    private val COUNTRY_FLAGS = intArrayOf(R.drawable.ic_uk, R.drawable.ic_all)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.phoneCode.adapter = CountryCodeAdapter(requireActivity(), COUNTRY_FLAGS, COUNTRY_CODES)

        val hints = resources.getStringArray(R.array.hints)
        binding.phoneNumber.hint = hints[0]
        binding.phoneCode.isClickable = false

        binding.phoneCode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?, view: View,
                index: Int, l: Long,
            ) {
                binding.phoneNumber.hint = hints[index]
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
    }
}