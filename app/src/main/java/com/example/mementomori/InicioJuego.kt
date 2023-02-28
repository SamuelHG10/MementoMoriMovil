package com.example.mementomori

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class InicioJuego : AppCompatActivity() {

    val list = mutableListOf<CarouselItem>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_juego)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#701313")))

        val carousel: ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/315018563_5535625126556567_6650475215712880700_n.jpg?stp=dst-jpg_p180x540&_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_eui2=AeF9EW4pW4jHAX-o8nyLsgnEXYLWqCvfor5dgtaoK9-ivgMVBMM6geDCRFTMscdwOgjz5OxxTeij6f6inJj48nzP&_nc_ohc=iBQHL_ToxA8AX-10SzZ&tn=1Je_-VzcwCwf7PUh&_nc_ht=scontent.fjal2-1.fna&oh=00_AfAoLg3K6gdmhgIoY3pdJvoLX6CtbpGqxNphH77-8cVz1Q&oe=636F2108"))
        list.add(CarouselItem("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/315039926_5535625366556543_1152953650444473075_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=ad2b24&_nc_eui2=AeG66yTa8rN_-0QrJrqoWt5Q4Vy3nx_jjevhXLefH-ON6wUc3FpncaQ3tzIQmYUBCHWU0tXiVSJF8fAtMuRIzc79&_nc_ohc=KIFYXdOv0zwAX9k-pLH&_nc_ht=scontent.fjal2-1.fna&oh=00_AfC5VIuorKXNb7wJogRddevfnCac6VwVzW12lEwS2-WGFQ&oe=636F5BD5"))
        list.add(CarouselItem("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/315035198_5535625629889850_2781681740862794908_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=ad2b24&_nc_eui2=AeF3i3zzFX07gdK7sLY7Eg5OINNtqyFic1gg022rIWJzWBxaqZAO1cjrE4GKRy4971H2OSHlOTVaXfaVnxh6B9PA&_nc_ohc=9gqqZ1glCWEAX_yJ6oD&_nc_ht=scontent.fjal2-1.fna&oh=00_AfDEFw68gfvH3GOjUOfrI6TK_mffZe4mrY2xFH1mM9I32A&oe=636F37BF"))
        list.add(CarouselItem("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/315000201_5535625863223160_8377320982535689475_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=ad2b24&_nc_eui2=AeE61QX00nG2z5MpBMv-wX2oS0OhG0hH1ZxLQ6EbSEfVnENZFSAq2tlyIfbAEOkavYdPgbrnfuD56oRutn4QOv5Z&_nc_ohc=-wa8L2KT1cEAX8YAMj0&_nc_ht=scontent.fjal2-1.fna&oh=00_AfDh3WUbdukFW23fbqFU5s87T2dd7-vTlS99ToMWsGsoxA&oe=636FD8E1"))
        list.add(CarouselItem("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/315061666_5535626059889807_9184221295411202065_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=ad2b24&_nc_eui2=AeHPLUqKrmzGnxQm5_HWU89Sc-Qq_pg7ft1z5Cr-mDt-3TAAQVolilI7AiPpuLiRNggPPdAimerJDexgGRd0yY5_&_nc_ohc=bj6_hRf30pIAX_SyCtZ&_nc_ht=scontent.fjal2-1.fna&oh=00_AfA4iOFrxLLj61_OFGU5CrY9n9LlsC7rzg9KRutd6aKjnw&oe=636EDA36"))
        carousel.addData(list)

        val btnPlay = findViewById<Button>(R.id.btn_InicioJuego)
        val btnDescarga = findViewById<Button>(R.id.btn_Descarga)

        btnPlay.setOnClickListener {

            Toast.makeText(baseContext, "Iniciando Memento Mori...", Toast.LENGTH_SHORT).show()
            startActivity(packageManager.getLaunchIntentForPackage("com.DelaTorreHernandez.MementoMori"))

        }

        btnDescarga.setOnClickListener {
            val webIntent: Intent = Uri.parse("https://drive.google.com/drive/folders/1wvj7Xah3agsDsgkAEhhHK20UYbH8Pv8a?usp=sharing").let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            startActivity(webIntent)
        }

    }

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
                Toast.makeText(baseContext, "Estas en Jugar :D", Toast.LENGTH_SHORT).show()
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