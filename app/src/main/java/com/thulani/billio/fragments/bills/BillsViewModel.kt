package com.thulani.billio.fragments.bills

import androidx.lifecycle.ViewModel
import com.thulani.billio.data.repository.BillRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class BillsViewModel(
 private val repository: BillRepository
):ViewModel(){
    val coroutineScope = CoroutineScope(Dispatchers.IO)


}