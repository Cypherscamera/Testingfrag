package com.example.fragmenttesting.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.fragmenttesting.R
import com.example.fragmenttesting.livedatamodelclick
import kotlinx.android.synthetic.main.fragment_homefrag.*

class Homefrag : Fragment() {

 private val viewmodel : livedatamodelclick by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homefrag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickinc.setOnClickListener{
            viewmodel.inc()
        }
        viewmodel.currentnum.observe(viewLifecycleOwner, Observer {
            incnum.text = it.toString()
        })
    }

}