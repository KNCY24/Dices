package com.e.dices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bouton = findViewById<Button> (R.id.rollButton)
        val image = findViewById<ImageView> (R.id.faceImage)
        val image2 = findViewById<ImageView> (R.id.faceImage2)
        val image3 = findViewById<ImageView> (R.id.faceImage3)
        val score = findViewById<TextView>(R.id.score)
        val seekbar = findViewById<SeekBar> (R.id.seekBar)

        var nombreDes = 0
        image2.visibility = View.GONE
        image3.visibility = View.GONE

        val faces = listOf (android.R.drawable.ic_menu_help, R.drawable.un, R.drawable.deux, R.drawable.trois, R.drawable.quatre, R.drawable.cinq, R.drawable.six)

        val facesImages = listOf(image, image2, image3)

        bouton.setOnClickListener {
            for (i in 0..2) {
                facesImages[i].setImageResource(faces[0])
            }
            Handler().postDelayed({
                var total = 0
                for (i in 0..2) {
                    if(nombreDes >= i) {
                        val random = Random.nextInt(1,6)
                        facesImages[i].setImageResource(faces[random])
                        total += random
                    }
                }
                score.setText(total.toString())
            }, 1000)

        }

        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                nombreDes = p1
                for (i in 0..2) {
                    if (nombreDes >= i) facesImages[i].visibility = View.VISIBLE
                    else facesImages[i].visibility = View.GONE
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
}
