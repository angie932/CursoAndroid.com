package com.cursoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun main(View:View){
        numero2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i("beforeTextChanged: ", "not override")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i("beforeTextChanged: ", "not override")
            }

            override fun afterTextChanged(p0: Editable?) {
                if(numero2.length()>=1){
                    btnsumar.isEnabled = true
                } else btnsumar.isEnabled = false
            }
        })

        numero1.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i("beforeTextChanged: ", "not override")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i("beforeTextChanged: ", "not override")
            }

            override fun afterTextChanged(p0: Editable?) {
                if(numero1.length()>=1){
                    btnsumar.isEnabled = true
                } else btnsumar.isEnabled = false
            }
        })

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
}