package com.example.demo004

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RepositoryDetailFragment : Fragment() {
    private lateinit var clickMe : TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repository_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickMe = view.findViewById(R.id.tvClickMe)
        clickMe.setOnClickListener{
            val fg = RepositoryDetailFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fg)
                .commit()
        }
    }
}