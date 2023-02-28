package com.example.mementomori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.mementomori.databinding.ActivityLlenadoCuentaBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LLenadoCuenta : AppCompatActivity() {

    private lateinit var binding: ActivityLlenadoCuentaBinding
    private lateinit var database: DatabaseReference

    //val paises = arrayOf("Mexico", "Usa", "España")
    //val generos = arrayOf("Masculino", "Femenino")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLlenadoCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        //val pais = findViewById<Spinner>(R.id.spinnerPais)
        //val genero = findViewById<Spinner>(R.id.spinnerGenero)
        //val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, paises)
        //pais.adapter = arrayAdapter

        //val arrayAdapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, generos)
        //genero.adapter = arrayAdapter1




        binding.btnGuardar.setOnClickListener{

            val nickname = binding.txtIngresarNombre.text.toString()
            val pais = binding.txtIngresarPais.text.toString()
            val genero = binding.txtIngresarGenero.text.toString()
            val edad = binding.txtIngresarEdad.text.toString()


            if (nickname.isNotEmpty() && pais.isNotEmpty() && genero.isNotEmpty() && edad.isNotEmpty()){
                database = FirebaseDatabase.getInstance().getReference("Cuenta")

                val CuentaBD = CuentaBD(nickname,pais,genero,edad)

                database.child(nickname).setValue(CuentaBD).addOnSuccessListener {

                    binding.txtIngresarNombre.setText("")
                    binding.txtIngresarEdad.setText("")
                    binding.txtIngresarGenero.setText("")
                    binding.txtIngresarPais.setText("")

                    Toast.makeText(this, "Guardado exitoso", Toast.LENGTH_SHORT).show()

                }.addOnFailureListener {
                    Toast.makeText(this, "Gurdado fallido", Toast.LENGTH_SHORT).show()

                }

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Los campos están vacios", Toast.LENGTH_SHORT).show()
            }
        }

    }

}