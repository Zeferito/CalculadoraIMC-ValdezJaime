package jaime.valdez.asignacion4_calculadoraimc_valdez_jaime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


    var imcVal: Double = 0.0
    var rangeImc: String = ""


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val avatar : ImageView = findViewById(R.id.avatar)
        val weight : EditText = findViewById(R.id.weight)
        val height : EditText = findViewById(R.id.height)
        val calculate : Button = findViewById(R.id.btnCalcular)
        val imc : TextView = findViewById(R.id.imc)
        val range : TextView = findViewById(R.id.range)


        calculate.setOnClickListener{
            val weightVal: Double = weight.getText().toString().toDouble()
            val heightVal: Double = height.getText().toString().toDouble()

            imcVal = calcular(heightVal, weightVal)
            rangeImc = rango(imcVal)

            imc.setText(imcVal.toString())
            range.setText(rangeImc.toString())

        }
    }

    fun calcular(height: Double, weight: Double) : Double{
        return(weight / (height*height))
    }

    fun rango(imcRa: Double): String{
        when{
            imcRa < 18.5 -> return "Bajo peso"
            imcRa >= 18.5 && imcRa <= 24.9 -> return "Saludable"
            imcRa >= 25 && imcRa <= 29.9 -> return "Sobrepeso"
            imcRa >= 30 && imcRa <= 34.9 -> return "Obesidad grado 1"
            imcRa >= 35 && imcRa <= 39.9 -> return "Obesidad grado 2"
            imcRa >= 40 -> return "Obesidad grado 3"
        }
        return "Error"
    }

}