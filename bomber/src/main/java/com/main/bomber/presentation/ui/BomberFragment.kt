package com.main.bomber.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.lifecycleScope
import com.main.bomber.R
import com.main.bomber.databinding.FragmentBomberBinding
import com.main.bomber.presentation.viewmodel.BomberViewModel
import com.main.core.data.BaseFragment
import com.main.services.some.ServiceInteractor
import com.main.services.some.list.RozetkaService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BomberFragment : BaseFragment<BomberViewModel>() {

    override val binding by lazy { FragmentBomberBinding.inflate(layoutInflater) }
    override val viewModelClass = BomberViewModel::class.java

    private val COUNTRY_CODES = arrayOf("380", "")
    private val COUNTRY_FLAGS = intArrayOf(R.drawable.ic_uk, R.drawable.ic_all)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val counterCodeAdapter = CountryCodeAdapter(requireActivity(), COUNTRY_FLAGS, COUNTRY_CODES)
        binding.phoneCode.adapter = counterCodeAdapter

        val hints = resources.getStringArray(R.array.hints)
        binding.phoneNumber.hint = hints[0]
        binding.phoneCode.isClickable = false

        binding.phoneCode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                selectedItemView: View?, index: Int, l: Long,
            ) {
                selectedItemView?.let { _ ->
                    binding.phoneNumber.hint = hints[index]
                } ?: {
                    binding.phoneNumber.hint = hints[0]
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) = Unit
        }

        val serviceInteractor = ServiceInteractor(
            rozetkaService = RozetkaService.build()
        )

        binding.btnStartAttack.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                serviceInteractor.startAttack("+380977854850")
            }
        }
    }
}