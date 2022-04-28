package br.senai.tic_tac_toy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode)

        // botões dos modos:

        // botão de modo Player vs Player
        val btnPvsPMode: ImageButton = findViewById(R.id.btn_p_vs_p)
        btnPvsPMode.setOnClickListener { startModePvsP() }

        // botão de moto Player vs Machine
        val btnPvsMmode = I
    }

    fun startModePvsP() {
        val modePvsP = Intent(this, PvsPActivity::class.java)
        startActivity(modePvsP)
    }

    fun startModePvsM() {
        val modePvsM = Intent(this, PvsMActivity::class.java)
        startActivity(modePvsM)
    }
}