package com.cursoandroid

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//-----Identificar si el campo esta lleno o no de tal modo se activara o desactivara el boton.------
        numero1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i("beforeTextChanged: ", "not override")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (numero1.length() >= 1 && numero2.length() >= 1) {
                    btnsumar.isEnabled = true
                } else if (numero1.length() >= 1 && numero2.length() == 0) {
                    btnsumar.isEnabled = false
                } else {
                    btnsumar.isEnabled = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.i("beforeTextChanged: ", "not override")
            }
        })

        numero2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i("beforeTextChanged: ", "not override")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (numero2.length() >= 1 && numero1.length() >= 1) {
                    btnsumar.isEnabled = true
                } else if (numero2.length() >= 1 && numero1.length() == 0) {
                    btnsumar.isEnabled = false
                } else {
                    btnsumar.isEnabled = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.i("beforeTextChanged: ", "not override")
            }
        })
//-----------------------------------------------------------------------------------------

//----------------------------------Tipo de tema-------------------------------------------
        val switch = findViewById<Switch>(R.id.switc)
        val image = findViewById<ImageView>(R.id.image)
        val text1 = findViewById<TextView>(R.id.text1)
        val text2 = findViewById<TextView>(R.id.text2)
        val bar = findViewById<Toolbar>(R.id.toolbar)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.ConstraintLayout)
        switch.setOnCheckedChangeListener { _, _ ->
            if (switch.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switch.text = ""
                image.setImageResource(R.drawable.ic_nig)
                text1.setTextColor(Color.parseColor("#ffffff"))
                text2.setTextColor(Color.parseColor("#ffffff"))
                bar.setBackgroundColor(Color.parseColor("#454545"))
                constraintLayout.setBackgroundResource(R.color.black)


            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switch.text = ""
                image.setImageResource(R.drawable.ic_luz)
            }

        }
//-------------------------------------------------------------------------------------------
    }
//---------------------funcion para capturar y sumar datos--------------------------------
    fun main(View:View){
        val capNumero1 = findViewById<EditText>(R.id.numero1)
        val capNumero2 = findViewById<EditText>(R.id.numero2)

        var num1 = capNumero1.text.toString().toInt()
        var num2 = capNumero2.text.toString().toInt()
        var sum = num1 + num2

        return try {
            findViewById<TextView>(R.id.respuesta).text = "Respuesta: $sum"
        } catch (e: NumberFormatException) {
            throw NullPointerException("Ingrese un Numero valido")
        }
    }
//------------------------------------------------------------------------------------------------

}