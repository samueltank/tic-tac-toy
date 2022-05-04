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
import kotlin.math.abs

class PvsMMediumModeActivity : AppCompatActivity() {

    var player: ArrayList<Int> = ArrayList()
    var playerMirror: ArrayList<Int> = ArrayList()
    var bot: ArrayList<Int> = ArrayList()
    var draw: ArrayList<Int> = ArrayList()
    var arrCont: ArrayList<Int> = ArrayList()

    var arrValidateCell1Vertical: ArrayList<Int> = ArrayList()
    var arrValidateCell1Horizontal: ArrayList<Int> = ArrayList()
    var arrValidateCell1Diagonal1: ArrayList<Int> = ArrayList()
    var arrValidateCell2Vertical: ArrayList<Int> = ArrayList()
    var arrValidateCell2Horizontal: ArrayList<Int> = ArrayList()
    var arrValidateCell3Vertical: ArrayList<Int> = ArrayList()
    var arrValidateCell3Horizontal: ArrayList<Int> = ArrayList()
    var arrValidateCell3Diagonal2: ArrayList<Int> = ArrayList()
    var arrValidateCell4Horizontal: ArrayList<Int> = ArrayList()
    var arrValidateCell4Vertical: ArrayList<Int> = ArrayList()
    var arrValidateCell5Vertical: ArrayList<Int> = ArrayList()
    var arrValidateCell5Horizontal: ArrayList<Int> = ArrayList()
    var arrValidateCell5Diagonal1: ArrayList<Int> = ArrayList()
    var arrValidateCell5Diagonal2: ArrayList<Int> = ArrayList()
    var arrValidateCell6Horizontal: ArrayList<Int> = ArrayList()
    var arrValidateCell6Vertical: ArrayList<Int> = ArrayList()
    var arrValidateCell7Vertical: ArrayList<Int> = ArrayList()
    var arrValidateCell7Horizontal: ArrayList<Int> = ArrayList()
    var arrValidateCell7Diagonal2: ArrayList<Int> = ArrayList()
    var arrValidateCell8Vertical: ArrayList<Int> = ArrayList()
    var arrValidateCell8Horizontal: ArrayList<Int> = ArrayList()
    var arrValidateCell9Vertical: ArrayList<Int> = ArrayList()
    var arrValidateCell9Horizontal: ArrayList<Int> = ArrayList()
    var arrValidateCell9Diagonal1: ArrayList<Int> = ArrayList()


    // sem ser lateinit, há excessão porque a activity é static before onCreate
    lateinit var btnSelected: Button

    var winner: Int = 0
    var activePlayer: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvs_mmedium_mode)

        // função para fechar voltar para a home do game
        val btn_exit: ImageButton = findViewById(R.id.btn_exit_game_screen)
        btn_exit.setOnClickListener { this.finish() }

        /*
        * Arrays organizados em pares na ordem correta de checagem
        * */

        // cell 1
        arrValidateCell1Vertical.add(4)
        arrValidateCell1Vertical.add(7)

        arrValidateCell1Horizontal.add(2)
        arrValidateCell1Horizontal.add(3)

        arrValidateCell1Diagonal1.add(5)
        arrValidateCell1Diagonal1.add(9)

        // cell 2
        arrValidateCell2Vertical.add(5)
        arrValidateCell2Vertical.add(8)

        arrValidateCell2Horizontal.add(1)
        arrValidateCell2Horizontal.add(3)

        // cell 3
        arrValidateCell3Vertical.add(6)
        arrValidateCell3Vertical.add(9)

        arrValidateCell3Horizontal.add(1)
        arrValidateCell3Horizontal.add(2)

        arrValidateCell3Diagonal2.add(5)
        arrValidateCell3Diagonal2.add(7)

        // cell 4
        arrValidateCell4Horizontal.add(5)
        arrValidateCell4Horizontal.add(6)

        arrValidateCell4Vertical.add(1)
        arrValidateCell4Vertical.add(7)

        // cell 5
        arrValidateCell5Vertical.add(2)
        arrValidateCell5Vertical.add(8)

        arrValidateCell5Horizontal.add(4)
        arrValidateCell5Horizontal.add(6)

        arrValidateCell5Diagonal1.add(1)
        arrValidateCell5Diagonal1.add(9)

        arrValidateCell5Diagonal2.add(3)
        arrValidateCell5Diagonal2.add(7)

        // cell 6
        arrValidateCell6Horizontal.add(4)
        arrValidateCell6Horizontal.add(5)

        arrValidateCell6Vertical.add(3)
        arrValidateCell6Vertical.add(9)

        // cell 7
        arrValidateCell7Vertical.add(1)
        arrValidateCell7Vertical.add(4)

        arrValidateCell7Horizontal.add(8)
        arrValidateCell7Horizontal.add(9)

        arrValidateCell7Diagonal2.add(3)
        arrValidateCell7Diagonal2.add(5)

        // cell 8
        arrValidateCell8Vertical.add(2)
        arrValidateCell8Vertical.add(5)

        arrValidateCell8Horizontal.add(7)
        arrValidateCell8Horizontal.add(9)

        // cell 9
        arrValidateCell9Vertical.add(3)
        arrValidateCell9Vertical.add(6)

        arrValidateCell9Horizontal.add(7)
        arrValidateCell9Horizontal.add(8)

        arrValidateCell9Diagonal1.add(1)
        arrValidateCell9Diagonal1.add(5)

        /*                              --#--                             */

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
        if (activePlayer == 1) {
            player.add(cellID)
            playerMirror.add(cellID)
            arrCont.remove(cellID)
            activePlayer = 2
            btnSelected.setBackgroundColor(Color.rgb(89,2, 236))
            btnSelected.setTextColor(Color.WHITE)
            btnSelected.text = "X"

            // executa o bot
            mediumBotExe()
        } else {
            bot.add(cellID)
            arrCont.remove(cellID)
            activePlayer = 1
            btnSelected.setBackgroundColor(Color.rgb(224, 77, 176))
            btnSelected.setTextColor(Color.WHITE)
            btnSelected.text = "O"
        }

        // player de empate recebe um id em cada click
        draw.add(cellID)
        btnSelected.isEnabled = false

        findWinner()
    }

    fun randomNumber(from: Int, to: Int) : Int {
        var random = Random()
        return (abs(random.nextInt(to - from)) + from)
    }


    // função bot no modo medium
    fun mediumBotExe() {

        Timer().schedule(800) {
            var ID: Int = 0
            if (bot.size < 4 && winner == 0) {

                /*
                * "inteligência" do bot de nível médio
                * */

                // célula ID 1
                if (
                    playerMirror.containsAll(arrValidateCell1Vertical) ||
                    playerMirror.containsAll(arrValidateCell1Horizontal) ||
                    playerMirror.containsAll(arrValidateCell1Diagonal1)
                ) {
                    if (!bot.contains(1)) ID = 1
                }

                // célula ID 2
                if (
                    playerMirror.containsAll(arrValidateCell2Vertical) ||
                    playerMirror.containsAll(arrValidateCell2Horizontal)
                ) {
                    if (!bot.contains(2)) ID = 2
                }

                // célula ID 3
                if (
                    playerMirror.containsAll(arrValidateCell3Vertical) ||
                    playerMirror.containsAll(arrValidateCell3Horizontal) ||
                    playerMirror.containsAll(arrValidateCell3Diagonal2)
                ) {
                    if (!bot.contains(3)) ID = 3
                }

                // célula ID 4
                if (
                    playerMirror.containsAll(arrValidateCell4Horizontal) ||
                    playerMirror.containsAll(arrValidateCell4Vertical)
                ) {
                    if (!bot.contains(4)) ID = 4
                }

                // célula ID 5
                if (
                    playerMirror.containsAll(arrValidateCell5Horizontal) ||
                    playerMirror.containsAll(arrValidateCell5Vertical) ||
                    playerMirror.containsAll(arrValidateCell5Diagonal1) ||
                    playerMirror.containsAll(arrValidateCell5Diagonal2)
                ) {
                    if (!bot.contains(5)) ID = 5
                }

                // célula ID 6
                if (
                    playerMirror.containsAll(arrValidateCell6Horizontal) ||
                    playerMirror.containsAll(arrValidateCell6Vertical)
                ) {
                    if (!bot.contains(6)) ID = 6
                }

                // célula ID 7
                if (
                    playerMirror.containsAll(arrValidateCell7Vertical) ||
                    playerMirror.containsAll(arrValidateCell7Horizontal) ||
                    playerMirror.containsAll(arrValidateCell7Diagonal2)
                ) {
                    if (!bot.contains(7)) ID = 7
                }

                // célula ID 8
                if (
                    playerMirror.containsAll(arrValidateCell8Vertical) ||
                    playerMirror.containsAll(arrValidateCell8Horizontal)
                ) {
                    if (!bot.contains(8)) ID = 8
                }

                // célula ID 9
                if (
                    playerMirror.containsAll(arrValidateCell9Vertical) ||
                    playerMirror.containsAll(arrValidateCell9Horizontal) ||
                    playerMirror.containsAll(arrValidateCell9Diagonal1)
                ) {
                    if (!bot.contains(9)) ID = 9
                }

                // id random
                if (ID == 0) {
                    ID = arrCont.get(randomNumber(1, arrCont.size))
                }


                println(playerMirror)
                println(ID)

                // captura o botão de acordo com o ID aleatório
                when (ID) {
                    1 -> btnSelected = findViewById(R.id.btnTicTac1)
                    2 -> btnSelected = findViewById(R.id.btnTicTac2)
                    3 -> btnSelected = findViewById(R.id.btnTicTac3)
                    4 -> btnSelected = findViewById(R.id.btnTicTac4)
                    5 -> btnSelected = findViewById(R.id.btnTicTac5)
                    6 -> btnSelected = findViewById(R.id.btnTicTac6)
                    7 -> btnSelected = findViewById(R.id.btnTicTac7)
                    8 -> btnSelected = findViewById(R.id.btnTicTac8)
                    9 -> btnSelected = findViewById(R.id.btnTicTac9)
                }

                // verifica se o buttom está livre
                if (!player.contains(ID) && !bot.contains(ID)) {
                    btnApplyID(btnSelected)
                } else {
                    mediumBotExe()
                }
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

            // necessário para rodar em um Thread loop, como requisito do método
            runOnUiThread {
                // anuncia vitória do jogador X (player)
                if (winner == 1) {
                    AlertDialog.Builder(this).setTitle("Winner")
                        .setMessage("Parabéns! você é o vencedor!\n\nVocê quer jogar novamente?")
                        .setPositiveButton("Sim") { _,_ ->
                            startActivity(Intent(this, PvsMMediumModeActivity::class.java))
                            this.finish()
                        }.setNegativeButton("Não") { _,_ ->
                            startActivity(Intent(this, ModeActivity::class.java))
                            this.finish()
                        }.create().show()
                }

                // anuncia vitória do jogador O (bot)
                if (winner == 2) {
                    AlertDialog.Builder(this).setTitle("Winner")
                        .setMessage("O BOT é o vencedor!\n\nVocê quer jogar novamente?")
                        .setPositiveButton("Sim") { _,_ ->
                            startActivity(Intent(this, PvsMMediumModeActivity::class.java))
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
                            startActivity(Intent(this, PvsMMediumModeActivity::class.java))
                            this.finish()
                        }.setNegativeButton("Não") { _,_ ->
                            startActivity(Intent(this, ModeActivity::class.java))
                            this.finish()
                        }.create().show()
                }
            }
        }
    }
}
