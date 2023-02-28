package com.example.mementomori

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore

class Estadisticas : AppCompatActivity() {

    private  lateinit var dbref : DatabaseReference
    private var db : FirebaseFirestore = FirebaseFirestore.getInstance()

    private lateinit var  correo : TextView
    private lateinit var  muertes1 : TextView
    private lateinit var  enemigos1 : TextView
    private lateinit var  tiempo1 : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#701313")))

        correo = findViewById(R.id.txt_Name)
        muertes1 = findViewById(R.id.txt_muertes)
        enemigos1 = findViewById(R.id.txt_Enemigos)
        tiempo1 = findViewById(R.id.txt_Tiempo)

        getUserData()

    }

    private fun getUserData() {
        var db = FirebaseFirestore.getInstance()
        db.collection("usuarios").document(MainActivity.eEmail)
            .get()
            .addOnSuccessListener {
                if(it.data?.size != null){
                    correo.text = it["email"].toString()
                    muertes1.text = it["muertes"].toString()
                    enemigos1.text = it["enemigos"].toString()
                    tiempo1.text = it["tiempo"].toString()
                }
            }
    }


    /////

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.nav_item_one ->{
                val intent1 = Intent(this, Menu2::class.java)
                startActivity(intent1)
            }
            R.id.nav_item_two ->{
                val intent2 = Intent(this, InicioJuego::class.java)
                startActivity(intent2)
            }
            R.id.nav_item_three -> {
                Toast.makeText(baseContext, "Estas en Estadisticas :D", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_four -> {
                val intent4 = Intent(this, MostrarEstadisticas::class.java)
                startActivity(intent4)
            }
            R.id.nav_item_five -> {
                val intent5 = Intent(this, MainActivity::class.java)
                startActivity(intent5)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}