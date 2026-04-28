package com.example.equipe01_projeto_ifood

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import com.example.equipe01_projeto_ifood.view.DetalhesProdutoActivity


class DetalhesRestaurantes : AppCompatActivity() {

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