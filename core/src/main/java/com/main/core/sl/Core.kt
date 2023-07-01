package com.main.core.sl

import com.main.core.presentation.core.DispatchersList

interface Core {

    fun provideDispatchers(): DispatchersList

    class Base: Core {

        private val dispatchersList by lazy {
            DispatchersList.Base()
        }

        override fun provideDispatchers() = dispatchersList
    }
}
