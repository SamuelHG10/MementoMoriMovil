package com.example.mementomori

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mementomori.databinding.ActivityLlenadoCuentaBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Cuenta : AppCompatActivity() {

    private lateinit var binding: ActivityLlenadoCuentaBinding
    private lateinit var database: DatabaseReference
    val db = Firebase.firestore

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuenta)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#701313")))

        val btn_Edit = findViewById<Button>(R.id.btn_Editar)

        var txt_NombreUsuario = findViewById<TextView>(R.id.txt_Tiempo)
        var txt_Pais = findViewById<TextView>(R.id.txt_Enemigos)
        var txt_Genero = findViewById<TextView>(R.id.txt_muertes)
        var txt_Edad = findViewById<TextView>(R.id.txt_Edad)

        btn_Edit.setOnClickListener(){
            val intent = Intent(this, LLenadoCuenta::class.java)
            startActivity(intent)
        }

        val docRef = db.collection("Cuenta").document("CowCrazy")
            docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    txt_NombreUsuario.setText(document.getString("userName").toString())
                    txt_Pais.setText(document.getString("pais").toString())
                    txt_Genero.setText(document.getString("genero").toString())
                    txt_Edad.setText(document.getString("edad").toString())

                    Log.d("Datos doc", "$txt_NombreUsuario $txt_Pais $txt_Genero $txt_Edad")

                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.nav_item_one ->{
                val intent2 = Intent(this, Menu2::class.java)
                startActivity(intent2)
            }
            R.id.nav_item_two ->{
                val intent2 = Intent(this, InicioJuego::class.java)
                startActivity(intent2)
            }
            R.id.nav_item_three -> {
                val intent3 = Intent(this, Estadisticas::class.java)
                startActivity(intent3)
            }
            R.id.nav_item_four -> {
                Toast.makeText(baseContext, "Estas en Cuenta :D", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_five -> {
                val intent5 = Intent(this, MainActivity::class.java)
                startActivity(intent5)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}