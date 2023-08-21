package com.example.controlandandroid.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<B: ViewBinding> : DialogFragment() {

    private var _binding: B? = null
    val binding: B
        get() = _binding!!

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = onCreateBinding(inflater)
        return binding.root
    }

    abstract fun onCreateBinding(inflater: LayoutInflater): B

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}