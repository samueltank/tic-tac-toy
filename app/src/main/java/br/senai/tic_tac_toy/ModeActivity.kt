package br.senai.tic_tac_toy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ModeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode)


        // botão de modo Player vs Machine
        val btnPvsM: ImageButton = findViewById(R.id.btn_p_vs_m)

        btnPvsM.setOnClickListener {
            Intent(this, PvsMActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }

        // botão de modo Player vs Player
        val btnPvsP: ImageButton = findViewById(R.id.btn_p_vs_p)
        btnPvsP.setOnClickListener {
            Intent(this, PvsPActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }
}