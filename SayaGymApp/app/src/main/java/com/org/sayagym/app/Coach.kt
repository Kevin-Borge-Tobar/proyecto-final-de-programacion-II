package com.org.sayagym.app

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class Coach : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coach)

        val couches = arrayOf("luna", "marta","Marcos", "Fernando")
        val routines = arrayOf("Calistenia","Masa Muscular", "Cardio")


        val adapter2 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            couches
        )
        val spinner: Spinner = findViewById(R.id.spinnerCoaches)
        spinner.adapter =adapter2

        spinner.onItemClickListener=object:
            AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?,
                                     view: View?,
                                     position: Int,
                                     id: Long) {

            }
        }
    }
}

