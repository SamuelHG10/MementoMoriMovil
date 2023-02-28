package com.example.mementomori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    companion object{

        lateinit var eEmail : String

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Quitar Action/statusbar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        val txt_User : TextView = findViewById(R.id.txt_Username)
        val txt_Pass : TextView = findViewById(R.id.txt_Password)

        val btn_Register= findViewById<Button>(R.id.btn_SignUp)
        val btn_Entrar= findViewById<Button>(R.id.btn_SingIn)

        auth = Firebase.auth

        btn_Entrar.setOnClickListener {

            if (txt_User.text.isNotEmpty() && txt_Pass.text.isNotEmpty()){
                signIn(txt_User.text.toString(),txt_Pass.text.toString())
            }
            else {
                Toast.makeText(this, "Los campos están vacios", Toast.LENGTH_SHORT).show()
            }
        }

        btn_Register.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }

    private fun signIn(email: String, password: String){

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    val user = auth.currentUser
                    Toast.makeText(baseContext, "Autentifacion exitosa", Toast.LENGTH_SHORT).show()
                    eEmail = email //variable global
                    //mandar a la ventana de menu
                    val intent = Intent(this, Menu2::class.java)
                    startActivity(intent)

                }
                else{
                    Toast.makeText(baseContext, "Error de Email y/o Contraseña", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onBackPressed() {
        return
    }
}