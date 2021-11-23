package com.example.fragmenttesting.Fragments

import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.example.fragmenttesting.R
import com.example.fragmenttesting.gameviewmodel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_lookfrag.*

class Lookfrag : Fragment() {

    private val viewmodel: gameviewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lookfrag, container, false)
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onstart()
        skip.setOnClickListener{
            getnextscramword()
            showscore()
        }
        submit.setOnClickListener {
            val textbyuser = userinput.text.toString()
                if (textbyuser.equals(viewmodel.currentword)) {
                    viewmodel.count += 2
                    userinput.text.clear()
                    showscore()
                    getnextscramword()
                    endgame()
                } else {
                    viewmodel.count -= 1
                    showscore()
                }
             }
    }

    private fun exitGame() {
        activity?.finish()
    }

    fun getnextscramword(){

        currentword.text = viewmodel.getscramword()
    }

    fun showscore(){
        score.text = viewmodel.count.toString()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun timer(){
        timer.isCountDown = false
        timer.base = SystemClock.elapsedRealtime()
        timer.start()
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun endgame(){
        if(viewmodel.count >10)
        {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("YOU WON in ${timer.text.toString()}")
                .setMessage("Restart or Exit")
                .setCancelable(false)
                .setNegativeButton("Exit"){ _, _ ->
                    exitGame()
                }
                .setPositiveButton("Restart"){ _, _ ->
                    restart()
                }.show()
    }

}

    @RequiresApi(Build.VERSION_CODES.N)
    private fun restart() {
        viewmodel.restart()
        getnextscramword()
        showscore()
        timer()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun onstart(){
        currentword.text = viewmodel.getscramword()
        score.text = viewmodel.count.toString()
        timer()
    }
}

