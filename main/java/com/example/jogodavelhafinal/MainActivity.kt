package com.example.jogodavelhafinal

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jogodavelhafinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

 private lateinit var binding: ActivityMainBinding
//MENU PARA SELEÇÃO DE MOGO DE JOGO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val humano = binding.buttonhumano
       val maquina = binding.buttonmaquina


    humano.setOnClickListener{
        val intent = Intent(this, humano::class.java)
        startActivity(intent)
        finish()
    }

    maquina.setOnClickListener {
        val intent = Intent(this, humano::class.java)
        startActivity(intent)
        finish()
    }

    }
}