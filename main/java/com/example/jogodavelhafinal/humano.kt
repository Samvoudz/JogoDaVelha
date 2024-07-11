package com.example.jogodavelhafinal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jogodavelhafinal.databinding.ActivityHumanoBinding

class humano : AppCompatActivity() {
    private lateinit var binding: ActivityHumanoBinding

    //Vetor "3D" que representará o tabuleiro de jogo
    val tabuleiro = arrayOf(
        arrayOf("A", "B", "C"),
        arrayOf("D", "E", "F"),
        arrayOf("G", "H", "I")
    )

    //variável que indica qual Jogador está jogando
    var jogadorAtual = "X"

    val menu = binding.volta


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHumanoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    menu.setOnClickListener{
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
    }
        //Função associada com todos os botões @param view é o botão clicado
        fun buttonClick(view: View) {
            //O botão clicado é associado com uma constante
            val buttonSelecionado = view as Button
            //O texto do botão recebe o jogador atual
            buttonSelecionado.text = jogadorAtual

            //De acordo com o botão clicado, a posição da matriz receberá o Jogador
            when (buttonSelecionado.id) {
                binding.buttonZero.id -> tabuleiro[0][0] = jogadorAtual
                binding.buttonUm.id -> tabuleiro[0][1] = jogadorAtual
                binding.buttonDois.id -> tabuleiro[0][2] = jogadorAtual
                binding.buttonTres.id -> tabuleiro[1][0] = jogadorAtual
                binding.buttonQuatro.id -> tabuleiro[1][1] = jogadorAtual
                binding.buttonCinco.id -> tabuleiro[1][2] = jogadorAtual
                binding.buttonSeis.id -> tabuleiro[2][0] = jogadorAtual
                binding.buttonSete.id -> tabuleiro[2][1] = jogadorAtual
                binding.buttonOito.id -> tabuleiro[2][2] = jogadorAtual
            }
            //Recebe o jogador vencedor através da função verificaTabuleiro. @param tabuleito
            var vencedor = verificaVencedor(tabuleiro)

            if (!vencedor.isNullOrBlank()) {
                Toast.makeText(this, "Vencedor: " + vencedor, Toast.LENGTH_LONG).show()
                val intent = Intent(this, humano::class.java)
                startActivity(intent)
                finish()
            }

            if (jogadorAtual.equals("X")) {
                buttonSelecionado.setBackgroundResource(R.drawable.omigr)
                jogadorAtual = "O"
            } else {
                buttonSelecionado.setBackgroundResource(R.drawable.omnird)
                jogadorAtual = "X"
            }
            buttonSelecionado.isEnabled = false
        }

        fun verificaVencedor(tabuleiro: Array<Array<String>>): String? {

            // Verifica linhas e colunas
            for (i in 0 until 3) {
                //Verifica se há três itens iguais na linha
                if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                    return tabuleiro[i][0]
                }
                //Verifica se há três itens iguais na coluna
                if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                    return tabuleiro[0][i]
                }
            }
            // Verifica diagonais
            if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
                return tabuleiro[0][0]
            }
            if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
                return tabuleiro[0][2]
            }
            //Verifica a quantidade de jogadores
            var empate = 0
            for (linha in tabuleiro) {
                for (valor in linha) {
                    if (valor.equals("X") || valor.equals("O")) {
                        empate++
                    }
                }
            }
            //Se existem 9 jogadas e não há três letras iguais, houve um empate
            if (empate == 9) {
                return "Empate"
            }
            // Nenhum vencedor
            return null
        }
    }
