package com.main.bomber.sl

import com.main.bomber.presentation.viewmodel.BomberViewModel
import com.main.core.sl.Module

class BomberModule : Module<BomberViewModel> {
    override fun viewModel(): BomberViewModel {
        return BomberViewModel()
    }
}