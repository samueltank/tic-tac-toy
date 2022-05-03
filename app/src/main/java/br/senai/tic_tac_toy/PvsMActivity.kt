package br.senai.tic_tac_toy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PvsMActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvs_m)

        // botão para o modo fácil
        var btnEaseBot = findViewById<Button>(R.id.btn_ease_bot)
        btnEaseBot.setOnClickListener {
            var intent = Intent(this, PvsMEaseModeActivity::class.java)
            startActivity(intent)
        }

        // botão para o modo médio
        var btnMediumBot = findViewById<Button>(R.id.btn_medium_bot)
        btnMediumBot.setOnClickListener {
            var intent = Intent(this, PvsMMediumModeActivity::class.java)
            startActivity(intent)
        }

        // botão para o modo impossível
        var btnImpossibleBot = findViewById<Button>(R.id.btn_hard_bot)
        btnImpossibleBot.setOnClickListener {
            var intent = Intent(this, PvsMImpossibleActivity::class.java)
            startActivity(intent)
        }
    }
}