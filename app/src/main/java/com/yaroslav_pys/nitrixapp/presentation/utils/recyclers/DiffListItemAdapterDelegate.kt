package com.yaroslav_pys.nitrixapp.presentation.utils.recyclers

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

data class DiffListItemAdapterDelegate<I>(
    val diffItemCallback: DiffUtilCallbackDelegate<I>,
    val delegate: AdapterDelegate<List<I>>
)