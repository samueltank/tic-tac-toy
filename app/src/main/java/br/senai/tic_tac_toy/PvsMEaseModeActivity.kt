package br.senai.tic_tac_toy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class PvsMEaseModeActivity : AppCompatActivity() {

    var  player: ArrayList<Int> = ArrayList()
    var     bot: ArrayList<Int> = ArrayList()
    var    draw: ArrayList<Int> = ArrayList()
    var arrCont: ArrayList<Int> = ArrayList()

    var winner: Int = 0
    var activePlayer: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvs_mease_mode)

        // função para fechar voltar para a home do game
        val btn_exit: ImageButton = findViewById(R.id.btn_exit_game_screen)
        btn_exit.setOnClickListener { this.finish() }

        // contador para as células do jogo
        for (n in 1..9) {arrCont.add(n)}

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

        btnSelected1.setOnClickListener {
            if (activePlayer == 1) btnApplyID(btnSelected1)
        }
        btnSelected2.setOnClickListener {
            if (activePlayer == 1) btnApplyID(btnSelected2)
        }
        btnSelected3.setOnClickListener {
            if (activePlayer == 1) btnApplyID(btnSelected3)
        }
        btnSelected4.setOnClickListener {
            if (activePlayer == 1) btnApplyID(btnSelected4)
        }
        btnSelected5.setOnClickListener {
            if (activePlayer == 1) btnApplyID(btnSelected5)
        }
        btnSelected6.setOnClickListener {
            if (activePlayer == 1) btnApplyID(btnSelected6)
        }
        btnSelected7.setOnClickListener {
            if (activePlayer == 1) btnApplyID(btnSelected7)
        }
        btnSelected8.setOnClickListener {
            if (activePlayer == 1) btnApplyID(btnSelected8)
        }
        btnSelected9.setOnClickListener {
            if (activePlayer == 1) btnApplyID(btnSelected9)
        }
    }


    fun btnApplyID(button: Button) {
        val btnSelected = button
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

        // função para startar o game
        gameStart(btnSelected, cellID)
    }

    fun gameStart(btnSelected: Button, cellID: Int) {
        if (activePlayer == 1 ) {
            btnSelected.setTextColor(Color.WHITE)
            btnSelected.setBackgroundColor(Color.rgb(89,2, 236))
            btnSelected.text = "X"
            player.add(cellID)
            arrCont.remove(cellID)
            activePlayer = 2

            // executa o bot
            easeBotExe()
        } else {
            Timer().schedule(800) {
                btnSelected.setTextColor(Color.WHITE)
                btnSelected.setBackgroundColor(Color.rgb(224, 77, 176))
                btnSelected.text = "O"
                bot.add(cellID)
                arrCont.remove(cellID)
                activePlayer = 1
            }
        }

        // player de empate recebe um id em cada click
        draw.add(cellID)
        btnSelected.isEnabled = false

        findWinner()
    }

    fun randomNumber(from: Int, to: Int) : Int {
        val random = Random()
        return (random.nextInt(to - from) + from)
    }

    // função bot no modo ease
    fun easeBotExe() {

        if (bot.size < 4 && winner == 0) {

            var random   = randomNumber(1, arrCont.size)
            var randomID = arrCont.get(random)

            if (!player.contains(randomID) && !bot.contains(randomID)) {
                var btnSelected: Button

                // captura o botão de acordo com o ID aleatório
                when (randomID) {
                    1 -> btnSelected = findViewById(R.id.btnTicTac1)
                    2 -> btnSelected = findViewById(R.id.btnTicTac2)
                    3 -> btnSelected = findViewById(R.id.btnTicTac3)
                    4 -> btnSelected = findViewById(R.id.btnTicTac4)
                    5 -> btnSelected = findViewById(R.id.btnTicTac5)
                    6 -> btnSelected = findViewById(R.id.btnTicTac6)
                    7 -> btnSelected = findViewById(R.id.btnTicTac7)
                    8 -> btnSelected = findViewById(R.id.btnTicTac8)
                    9 -> btnSelected = findViewById(R.id.btnTicTac9)
                    else -> {
                        btnSelected = findViewById(R.id.btnTicTac1)
                    }
                }

                btnApplyID(btnSelected)
            }
        }
    }

    fun findWinner() {

        // verifica se há ganhador na linha 1
        val row1Values = ArrayList<Int>()
        for (i in 1..3) { row1Values.add(i) }

        if (player.containsAll(row1Values)) { winner = 1 }
        if (bot.containsAll(row1Values)) { winner = 2 }

        // verifica se há ganhador linha 2
        val row2Values = ArrayList<Int>()
        for (i in 4..6) { row2Values.add(i) }

        if (player.containsAll(row2Values)) { winner = 1 }
        if (bot.containsAll(row2Values)) { winner = 2 }

        // verifica se há ganhador na linha 3
        val row3Values = ArrayList<Int>()
        for (i in 7..9) { row3Values.add(i) }

        if (player.containsAll(row3Values)) { winner = 1 }
        if (bot.containsAll(row3Values)) { winner = 2 }

        // verifica se há ganhador na coluna 1
        val col1Values = ArrayList<Int>()
        for (i in 1..7 step 3) { col1Values.add(i) }

        if (player.containsAll(col1Values)) { winner = 1 }
        if (bot.containsAll(col1Values)) { winner = 2 }

        // verifica se há ganhador na coluna 2
        val col2Values = ArrayList<Int>()
        for (i in 2..8 step 3) { col2Values.add(i) }

        if (player.containsAll(col2Values)) { winner = 1 }
        if (bot.containsAll(col2Values)) { winner = 2 }

        // verifica se há ganhador na coluna 3
        val col3values = ArrayList<Int>()
        for (i in 3..9 step 3) { col3values.add(i) }

        if (player.containsAll(col3values)) { winner = 1 }
        if (bot.containsAll(col3values)) { winner = 2 }

        // verifica se há ganhador na diagonal(esquerda -> direita)
        val diag1Values = ArrayList<Int>()
        for (i in 1..9 step 4) { diag1Values.add(i) }

        if (player.containsAll(diag1Values)) { winner = 1 }
        if (bot.containsAll(diag1Values)) { winner = 2 }

        // verifica se há ganhador na diagonal(direita -> esquerda)
        val diag2Values = ArrayList<Int>()
        for (i in 3..7 step 2) { diag2Values.add(i) }

        if (player.containsAll(diag2Values)) { winner = 1 }
        if (bot.containsAll(diag2Values)) { winner = 2 }

        // verifica se há empate
        val drawValues = ArrayList<Int>()
        for (i in 1..9) { drawValues.add(i) }

        if (draw.containsAll(drawValues) && winner == 0) { winner = 3 }

        // verifica se há algum ganhador
        if (winner != 0) {

            // anuncia vitória do jogador X (player)
            if (winner == 1) {
                AlertDialog.Builder(this).setTitle("Winner")
                    .setMessage("\"X\" é o vencedor!\n\nVocê quer jogar novamente?")
                    .setPositiveButton("Sim") { _,_ ->
                        startActivity(Intent(this, PvsMEaseModeActivity::class.java))
                        this.finish()
                    }.setNegativeButton("Não") { _,_ ->
                        startActivity(Intent(this, ModeActivity::class.java))
                        this.finish()
                    }.create().show()
            }

            // anuncia vitória do jogador O (bot)
            if (winner == 2) {
                AlertDialog.Builder(this).setTitle("Winner")
                    .setMessage("O BOT é o vencedo!\n\nVocê quer jogar novamente?")
                    .setPositiveButton("Sim") { _,_ ->
                        startActivity(Intent(this, PvsMEaseModeActivity::class.java))
                        this.finish()
                    }.setNegativeButton("Não") { _,_ ->
                        startActivity(Intent(this, ModeActivity::class.java))
                        this.finish()
                    }.create().show()
            }

            // anuncia empate
            if (winner == 3) {
                AlertDialog.Builder(this).setTitle("Empate")
                    .setMessage("Empatou!\n\nVocê quer jogar novamente?")
                    .setPositiveButton("Sim") { _,_ ->
                        startActivity(Intent(this, PvsMEaseModeActivity::class.java))
                        this.finish()
                    }.setNegativeButton("Não") { _,_ ->
                        startActivity(Intent(this, ModeActivity::class.java))
                        this.finish()
                    }.create().show()
            }
        }
    }
}