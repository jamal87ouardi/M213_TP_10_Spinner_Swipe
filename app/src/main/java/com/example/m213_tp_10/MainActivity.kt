package com.example.m213_tp_10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val villes = arrayOf("Rabat ", "Casablanca" , "Fes" , "El Jadida" , "Kenitra", "Agadir")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,villes)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinnerResult = findViewById<TextView>(R.id.spinnerText)
        val cl = findViewById<ConstraintLayout>(R.id.cl)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                spinnerResult.text = villes[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }


        }

        cl.setOnTouchListener(object : OnSwipeTouchListener(applicationContext),
            View.OnTouchListener {
            override fun onSwipeRight(): Boolean {
                val i = Intent(applicationContext,Products::class.java )
                startActivity(i)
                return true;
            }
            override fun onSwipeLeft(): Boolean {
                val i = Intent(applicationContext,Services::class.java )
                startActivity(i)
                return true;
            }
        })



    }
}