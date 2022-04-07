package br.senai.tic_tac_toy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val btnClose: ImageButton = findViewById(R.id.btnClose);
        btnClose.setOnClickListener { finish() };

    }
}