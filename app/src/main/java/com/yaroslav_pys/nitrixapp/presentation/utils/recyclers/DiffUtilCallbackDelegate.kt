package com.yaroslav_pys.nitrixapp.presentation.utils.recyclers

import androidx.recyclerview.widget.DiffUtil

abstract class DiffUtilCallbackDelegate <T> : DiffUtil.ItemCallback<T>() {
    abstract fun isForViewType(data: T): Boolean
}