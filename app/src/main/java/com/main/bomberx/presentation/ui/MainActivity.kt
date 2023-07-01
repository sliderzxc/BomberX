package com.main.bomberx.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.main.bomberx.databinding.ActivityMainBinding
import com.main.core.sl.ProvideViewModel

class MainActivity : AppCompatActivity(), ProvideViewModel {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T {
        return (application as ProvideViewModel).provideViewModel(clazz, owner)
    }
}