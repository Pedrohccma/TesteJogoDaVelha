package com.pedrohc.testejogodavelhaletras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textUser : TextView

    private lateinit var centerBox: ImageView
    private lateinit var centerRightBox : ImageView
    private lateinit var centerLeftBox : ImageView

    private lateinit var upperCenterBox : ImageView
    private lateinit var upperRightBox : ImageView
    private lateinit var upperLeftBox : ImageView

    private lateinit var bottomCenterBox : ImageView
    private lateinit var bottomRightBox : ImageView
    private lateinit var bottomLeftBox : ImageView

    private val board = Array(3) { IntArray(3) }

    private var firstUser = true
    private var endGame = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        centerBox = findViewById(R.id.center_box)
        centerRightBox = findViewById(R.id.center_right_box)
        centerLeftBox = findViewById(R.id.center_left_box)

        upperCenterBox = findViewById(R.id.upper_center_box)
        upperRightBox = findViewById(R.id.upper_right_box)
        upperLeftBox = findViewById(R.id.upper_left_box)

        bottomCenterBox = findViewById(R.id.bottom_center_box)
        bottomRightBox = findViewById(R.id.bottom_right_box)
        bottomLeftBox = findViewById(R.id.bottom_left_box)

        textUser = findViewById(R.id.text_user)

        configureBox(centerBox)
        configureBox(centerRightBox)
        configureBox(centerLeftBox)

        configureBox(upperCenterBox)
        configureBox(upperRightBox)
        configureBox(upperLeftBox)

        configureBox(bottomCenterBox)
        configureBox(bottomRightBox)
        configureBox(bottomLeftBox)

        val newGame: Button = findViewById(R.id.bttn_new_Game)

        newGame.setOnClickListener{
            newGame(centerBox)
            newGame(centerRightBox)
            newGame(centerLeftBox)

            newGame(upperCenterBox)
            newGame(upperRightBox)
            newGame(upperLeftBox)

            newGame(bottomCenterBox)
            newGame(bottomRightBox)
            newGame(bottomLeftBox)
        }
    }

    private fun configureBox(box: ImageView) {
        box.setOnClickListener {
            if (box.tag == null && endGame != true) {
                if (firstUser) {
                    box.setImageResource(R.drawable.jogo_velha_x)
                    box.tag = 1
                    textUser.text = buildString { append("Usuário 1") }
                    firstUser = false
                    gameRecord(box, 1)
                    if (userWin(1)) {
                        endGame = true
                        textUser.text = buildString {
                            append("Usuário 1 Venceu")
                        }
                    }
                }
                else {
                    box.setImageResource(R.drawable.jogo_velha_circulo)
                    box.tag = 2
                    textUser.text = buildString { append("Usuário 2") }
                    firstUser = true
                    gameRecord(box, 2)
                    if (userWin(2)) {
                        endGame = true
                        textUser.text = buildString {
                            append("Usuário 2 Venceu")
                        }
                    }
                }
            }
        }
    }

    private fun gameRecord(box: ImageView, user: Int) {
        when (box.id) {
            R.id.center_box -> board[1][1] = user
            R.id.center_right_box -> board[1][2] = user
            R.id.center_left_box -> board[1][0] = user
            R.id.upper_center_box -> board[0][1] = user
            R.id.upper_right_box -> board[0][2] = user
            R.id.upper_left_box -> board[0][0] = user
            R.id.bottom_center_box -> board[2][1] = user
            R.id.bottom_right_box -> board[2][2] = user
            R.id.bottom_left_box -> board[2][0] = user
        }
    }

    private fun userWin(user: Int): Boolean {
        for (i in 0 until 3) {
            if (board[i][0] == user && board[i][1] == user && board[i][2] == user) {
                return true
            }
            if (board[0][i] == user && board[1][i] == user && board[2][i] == user) {
                return true
            }
        }

        if (board[0][0] == user && board[1][1] == user && board[2][2] == user) {
            return true
        }
        if (board[0][2] == user && board[1][1] == user && board[2][0] == user) {
            return true
        }

        return false
    }

    private fun newGame(box: ImageView){
        box.setImageDrawable(null)
        box.tag = null

        for (i in 0 until 3){
            for(j in 0 until 3){
                board[i][j] = 0
            }
        }

        firstUser = true
        endGame = false

        textUser.text = buildString {
            append("Usuário 1")
        }
    }

}