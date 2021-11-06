package com.org.sayagym.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.org.sayagym.app.databinding.FragmentFragCoachesBinding

class Frag_Coaches:Fragment() {
    private lateinit var binding: FragmentFragCoachesBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentFragCoachesBinding.inflate(inflater,container,false)


        return binding.root
    }
}

