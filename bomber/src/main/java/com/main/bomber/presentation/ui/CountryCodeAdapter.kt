package com.main.bomber.presentation.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.main.bomber.databinding.CountryCodeRowBinding

class CountryCodeAdapter(
    private val context: Context,
    private val flags: IntArray,
    private val countryCodes: Array<String>
) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return flags.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(index: Int, view: View?, parent: ViewGroup): View {
        val holder: ViewHolder
        var convertedView = view

        if (convertedView == null) {
            val binding = CountryCodeRowBinding.inflate(inflater, parent, false)

            convertedView = binding.root
            convertedView.tag = ViewHolder(binding)
            holder = convertedView.tag as ViewHolder
        } else {
            holder = convertedView.tag as ViewHolder
        }

        holder.binding.countryFlag.setImageResource(flags[index])
        holder.binding.countryCode.text = String.format("+%s", countryCodes[index])

        return convertedView
    }

    private class ViewHolder(val binding: CountryCodeRowBinding)
}