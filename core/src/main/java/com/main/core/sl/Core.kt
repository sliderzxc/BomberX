package com.main.core.sl

import com.main.core.presentation.DispatchersList

interface Core {

    fun provideDispatchers(): DispatchersList

    class Base: Core {

        private val dispatchersList by lazy {
            DispatchersList.Base()
        }

        override fun provideDispatchers() = dispatchersList
    }
}
