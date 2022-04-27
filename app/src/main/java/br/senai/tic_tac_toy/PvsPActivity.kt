package br.senai.tic_tac_toy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class PvsPActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvs_pactivity)

        // captura os botões do Layout
        val btnSelected1: Button = findViewById(R.id.btnTicTac1)
        val btnSelected2: Button = findViewById(R.id.btnTicTac2)
        val btnSelected3: Button = findViewById(R.id.btnTicTac3)
        val btnSelected4: Button = findViewById(R.id.btnTicTac4)
        val btnSelected5: Button = findViewById(R.id.btnTicTac5)
        val btnSelected6: Button = findViewById(R.id.btnTicTac6)
        val btnSelected7: Button = findViewById(R.id.btnTicTac7)
        val btnSelected8: Button = findViewById(R.id.btnTicTac8)
        val btnSelected9: Button = findViewById(R.id.btnTicTac9)

        // aplica os listeners de click para cada botão :<
        btnSelected1.setOnClickListener { btnApplyID(btnSelected1) }
        btnSelected2.setOnClickListener { btnApplyID(btnSelected2) }
        btnSelected3.setOnClickListener { btnApplyID(btnSelected3) }
        btnSelected4.setOnClickListener { btnApplyID(btnSelected4) }
        btnSelected5.setOnClickListener { btnApplyID(btnSelected5) }
        btnSelected6.setOnClickListener { btnApplyID(btnSelected6) }
        btnSelected7.setOnClickListener { btnApplyID(btnSelected7) }
        btnSelected8.setOnClickListener { btnApplyID(btnSelected8) }
        btnSelected9.setOnClickListener { btnApplyID(btnSelected9) }
    }

    fun applyClickListener() {

    }

    fun btnApplyID(view: View) {
        val btnSelected = view as Button
        var cellID: Int = 0

        when (btnSelected.id) {
            R.id.btnTicTac1 -> cellID = 1
            R.id.btnTicTac2 -> cellID = 2
            R.id.btnTicTac3 -> cellID = 3
            R.id.btnTicTac4 -> cellID = 4
            R.id.btnTicTac5 -> cellID = 5
            R.id.btnTicTac6 -> cellID = 6
            R.id.btnTicTac7 -> cellID = 7
            R.id.btnTicTac8 -> cellID = 8
            R.id.btnTicTac9 -> cellID = 9
        }

//        Toast.makeText(this, "ID: " + cellID, Toast.LENGTH_SHORT).show();

        gameProcessor(cellID, btnSelected)
    }

    var player1      = ArrayList<Int>()
    var player2      = ArrayList<Int>()
    var playerDraw   = ArrayList<Int>()

    var activePlayer = 1

    fun gameProcessor(cellId: Int, btnSelected: Button) {
        if (activePlayer == 1 ) {
            btnSelected.setTextColor(Color.WHITE)
            btnSelected.setBackgroundColor(Color.rgb(89,2, 236))
            btnSelected.text = "X"
            player1.add(cellId)
            activePlayer = 2
        } else {
            btnSelected.setTextColor(Color.WHITE)
            btnSelected.setBackgroundColor(Color.rgb(224, 77, 176))
            btnSelected.text = "O"
            player2.add(cellId)
            activePlayer = 1
        }

        // player de empate recebe um id em cada click
        playerDraw.add(cellId)

        btnSelected.isEnabled = false
        findWinner()
    }

    fun findWinner() {
        var winner = -1

        // verifica se há ganhador na linha 1
        val row1Values = ArrayList<Int>()
        for (i in 1..3) { row1Values.add(i) }

        if (player1.containsAll(row1Values)) { winner = 1 }
        if (player2.containsAll(row1Values)) { winner = 2 }

        // verifica se há ganhador linha 2
        val row2Values = ArrayList<Int>()
        for (i in 4..6) { row2Values.add(i) }

        if (player1.containsAll(row2Values)) { winner = 1 }
        if (player2.containsAll(row2Values)) { winner = 2 }

        // verifica se há ganhador na linha 3
        val row3Values = ArrayList<Int>()
        for (i in 7..9) { row3Values.add(i) }

        if (player1.containsAll(row3Values)) { winner = 1 }
        if (player2.containsAll(row3Values)) { winner = 2 }

        // verifica se há ganhador na coluna 1
        val col1Values = ArrayList<Int>()
        for (i in 1..7 step 3) { col1Values.add(i) }

        if (player1.containsAll(col1Values)) { winner = 1 }
        if (player2.containsAll(col1Values)) { winner = 2 }

        // verifica se há ganhador na coluna 2
        val col2Values = ArrayList<Int>()
        for (i in 2..8 step 3) { col2Values.add(i) }

        if (player1.containsAll(col2Values)) { winner = 1 }
        if (player2.containsAll(col2Values)) { winner = 2 }

        // verifica se há ganhador na coluna 3
        val col3values = ArrayList<Int>()
        for (i in 3..9 step 3) { col3values.add(i) }

        if (player1.containsAll(col3values)) { winner = 1 }
        if (player2.containsAll(col3values)) { winner = 2 }

        // verifica se há ganhador na diagonal(esquerda -> direita)
        val diag1Values = ArrayList<Int>()
        for (i in 1..9 step 4) { diag1Values.add(i) }

        if (player1.containsAll(diag1Values)) { winner = 1 }
        if (player2.containsAll(diag1Values)) { winner = 2 }

        // verifica se há ganhador na diagonal(direita -> esquerda)
        val diag2Values = ArrayList<Int>()
        for (i in 3..7 step 2) { diag2Values.add(i) }

        if (player1.containsAll(diag2Values)) { winner = 1 }
        if (player2.containsAll(diag2Values)) { winner = 2 }

        // verifica se há empate
        val drawValues = ArrayList<Int>()
        for (i in 1..9) { drawValues.add(i) }

        if (playerDraw.containsAll(drawValues)) { winner = 3 }

        // verifica se há algum ganhador
        if (winner != 0) {

            // anuncia vitória do jogador X
            if (winner == 1) {
                AlertDialog.Builder(this).setTitle("Winner")
                    .setMessage("\"X\" é o vencedor!\n\nVocê quer jogar novamente?")
                    .setPositiveButton("Sim") { dialog, which ->
                        startActivity(Intent(this, PvsPActivity::class.java))
                    }.setNegativeButton("Não") { dialog, which ->
                        startActivity(Intent(this, MainActivity::class.java))
                    }.create().show()

                this.finish()
            }

            // anuncia vitória do jogador O
            if (winner == 2) {
                AlertDialog.Builder(this).setTitle("Winner")
                    .setMessage("\"O\" é o vencedo!\n\nVocê quer jogar novamente?")
                    .setPositiveButton("Sim") { dialog, which ->
                        startActivity(Intent(this, PvsPActivity::class.java))
                    }.setNegativeButton("Não") { dialog, which ->
                        startActivity(Intent(this, MainActivity::class.java))
                    }.create().show()

                this.finish()
            }

            // anuncia empate
            if (winner == 3) {
                AlertDialog.Builder(this).setTitle("Empate")
                    .setMessage("Empatou!\n\nVocê quer jogar novamente?")
                    .setPositiveButton("Sim") { dialog, which ->
                        startActivity(Intent(this, PvsPActivity::class.java))
                    }.setNegativeButton("Não") { dialog, which ->
                        startActivity(Intent(this, MainActivity::class.java))
                    }.create().show()

                this.finish()
            }
        }
    }
}
