package com.example.equipe01_projeto_ifood.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.equipe01_projeto_ifood.R

class DetalhesRestaurantesActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_restaurante)

        val produto = findViewById<View>(R.id.img_detalhesRestaurantes)

        produto.setOnClickListener {
            val intent = Intent(this, DetalhesProdutoActivity::class.java)
            startActivity(intent)
        }

        btnBack = findViewById(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }

    }
}