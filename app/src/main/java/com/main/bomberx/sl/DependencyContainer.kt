package com.main.bomberx.sl

import androidx.lifecycle.ViewModel
import com.main.bomber.presentation.viewmodel.BomberViewModel
import com.main.bomber.sl.BomberModule
import com.main.core.sl.Core
import com.main.core.sl.Module

interface DependencyContainer {

    fun <T : ViewModel> module(clazz: Class<T>): Module<*>

    class Error : DependencyContainer {
        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> {
            throw IllegalStateException("no module found for $clazz")
        }
    }

    class Base(
        private val core: Core,
        private val dependencyContainer: DependencyContainer = Error()
    ) : DependencyContainer {

        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> = when (clazz) {
            BomberViewModel::class.java -> BomberModule()
            else -> dependencyContainer.module(clazz)
        }
    }
}
