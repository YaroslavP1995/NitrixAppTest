package com.yaroslav_pys.nitrixapp.presentation.base

import androidx.annotation.NavigationRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

open class BaseFragment <T : ViewBinding> : Fragment() {
    protected var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        binding.root.requestLayout()
    }

    protected fun navigateToDirections(
        direction: NavDirections
    ) {
        findNavController().navigate(direction)
    }

    protected fun isDestinationValid(destinationId: Int): Boolean {
        return findNavController().currentDestination?.id == destinationId
    }

    protected fun changeGraph(@NavigationRes graphId: Int) {
        findNavController().setGraph(graphId)
    }
}