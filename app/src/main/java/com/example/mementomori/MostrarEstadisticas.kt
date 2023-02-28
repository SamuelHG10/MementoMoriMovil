package com.example.mementomori

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MostrarEstadisticas : AppCompatActivity() {

    private  lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<CuentaBD>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_estadisticas)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#701313")))

        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<CuentaBD>()
        getUserData()

    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("Cuenta")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){

                        val user = userSnapshot.getValue(CuentaBD::class.java)
                        userArrayList.add(user!!)

                    }

                    userRecyclerview.adapter = MyAdapter(userArrayList)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }

    ////

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