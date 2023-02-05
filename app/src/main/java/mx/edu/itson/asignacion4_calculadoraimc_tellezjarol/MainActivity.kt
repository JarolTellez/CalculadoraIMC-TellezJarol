package mx.edu.itson.asignacion4_calculadoraimc_tellezjarol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import  android.widget.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variables

        var txtResultado: TextView = findViewById(R.id.tvResultado)
        var txtEstado: TextView = findViewById(R.id.tvEstado)

        val etEstatura: EditText = findViewById(R.id.etEstatura)
        val etPeso: EditText = findViewById(R.id.etPeso)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        //evento buttonclick o


        btnCalcular.setOnClickListener {
            try
            {
            if (!etEstatura.text.isBlank() || !etPeso.text.isBlank()) {
                val imcNum = this.calcularImc(
                    etEstatura.text.toString().toDouble(),
                   etPeso.text.toString().toDouble()
                )
                txtResultado.setText(imcNum.toString())

                val estado = this.obtenEstado(imcNum)
                txtEstado.setText(estado)

                when (estado) {
                    "Bajo peso" -> txtEstado.setBackgroundResource(R.color.colorRed)
                    "Saludable" -> txtEstado.setBackgroundResource(R.color.colorGreenish)
                    "Sobrepeso" -> txtEstado.setBackgroundResource(R.color.colorYellow)
                    "Obesidad de grado 1" -> txtEstado.setBackgroundResource(R.color.colorOrange)
                    "Obesidad de grado 2" -> txtEstado.setBackgroundResource(R.color.colorBrown)
                    "Obesidad de grado 3" -> txtEstado.setBackgroundResource(R.color.colorRed)

                }
            }

        }catch (e:java.lang.Exception){
            txtResultado.setText("Ingresar valores reales")
            }

            }
    }

    fun calcularImc(altura: Double, peso: Double): Double {
        val imc: Double = (peso / (Math.pow(altura, 2.0)))
        return imc

    }

    fun obtenEstado(imc: Double): String {
        when
        {
            imc <18.5 -> return "Bajo peso"
            imc >= 18.5 && imc <= 24.9 -> return "Saludable"
            imc > 24.9 && imc <= 29.9 -> return "Sobrepeso"
            imc > 29.9 && imc <= 34.9 -> return "Obesidad de grado 1"
            imc > 34.9 && imc <= 39.9-> return "Obesidad de grado 2"
            imc >= 40 -> return "Obesidad de grado 3"
        }

        return "error"

    }

    // funcion que pide la practica
}