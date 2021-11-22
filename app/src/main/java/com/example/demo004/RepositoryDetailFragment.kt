package com.example.demo004

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.demo004.databinding.FragmentRepositoryDetailBinding

class RepositoryDetailFragment : Fragment() {
    private var _binding: FragmentRepositoryDetailBinding? = null
    private val binding
        get() = _binding !!
    private lateinit var clickMe : TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestData()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun requestData(){

    }
}