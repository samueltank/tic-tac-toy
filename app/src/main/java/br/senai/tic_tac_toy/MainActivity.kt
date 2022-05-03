package br.senai.tic_tac_toy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button      = findViewById(R.id.btnStart)
        val btnClose: ImageButton = findViewById(R.id.btnClose)

        btnClose.setOnClickListener { finish() }
        btnStart.setOnClickListener { goGameScreen() }
    }

    private fun goGameScreen() {
        val gameScreen = Intent(this, ModeActivity::class.java)
        startActivity(gameScreen)
    }
}