package com.example.mydateofbirth

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*
import java.text.SimpleDateFormat
import java.time.Month
import java.time.Year


class MainActivity : AppCompatActivity() {
    private lateinit var btnCalendario: Button
    private lateinit var textDataN: TextView
    private lateinit var textIdade: TextView
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textIdade = findViewById(R.id.txtDias)
        btnCalendario = findViewById(R.id.btnCalendario)

        btnCalendario.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                pegarData()
            }

        })
    }

    private fun pegarData() {
        val dateSetListener = object: DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                cal.set(Calendar.YEAR,year)
                cal.set(Calendar.MONTH,monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                calcularIdade(cal.get(Calendar.DAY_OF_YEAR))
            }
        }

        btnCalendario.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                DatePickerDialog(this@MainActivity,dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_YEAR)).show()
            }
        })
    }

    private fun calcularIdade(diaN: Int) {
        val cal2 = Calendar.getInstance()
        val diaA: Int = cal2.get(Calendar.DAY_OF_YEAR)

        val idade: Int = diaN - diaA
        textIdade.setText("Dias para chegar seu niver: " + idade)

    }
}