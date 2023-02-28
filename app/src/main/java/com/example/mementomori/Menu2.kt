package com.example.mementomori

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class Menu2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#701313")))

        val btn_SaverMas = findViewById<Button>(R.id.btn_SaverMAs)

        btn_SaverMas.setOnClickListener {
            val intent = Intent(this, InicioJuego::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.nav_item_one ->{
                Toast.makeText(baseContext, "Estas en Inicio :D", Toast.LENGTH_SHORT).show()
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

    override fun onBackPressed() {
        return
    }

}