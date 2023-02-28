package com.example.mementomori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    companion object{

        lateinit var pEmail : String

    }


    private lateinit var userN: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Quitar Action/statusbar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        auth = Firebase.auth

        userN = findViewById(R.id.txt_UserRead)
        password = findViewById(R.id.txt_PasswordRead)

        val btnRegistrar = findViewById<Button>(R.id.btn_GoRegister)

        btnRegistrar.setOnClickListener {
            if (userN.text.isNotEmpty() && password.text.isNotEmpty()){
                createAccount(userN.text.toString(),password.text.toString())
            }
            else {
                Toast.makeText(this, "Los campos están vacios", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun createAccount(userN: String, password:String){
        auth.createUserWithEmailAndPassword(userN,password)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){

                    var dbRegister = FirebaseFirestore.getInstance()
                    dbRegister.collection("usuarios").document(userN).set(
                        hashMapOf(
                            "email" to userN,
                            "muertes" to 0,
                            "tiempo" to 0,
                            "enemigos" to 0
                        )
                    )
                    pEmail = userN //global
                    Toast.makeText(baseContext, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show()
                    //mandar a la pantalla principal
                    val intent = Intent(this, LLenadoCuenta::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(baseContext, "Algo salio mal, Error: "+task.exception, Toast.LENGTH_SHORT).show()
                }
            }
    }


}