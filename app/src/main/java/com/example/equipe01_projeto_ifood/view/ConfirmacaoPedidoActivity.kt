package com.example.equipe01_projeto_ifood.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.equipe01_projeto_ifood.DetalhesRestaurantes
import com.example.equipe01_projeto_ifood.R

class ConfirmacaoPedidoActivity : AppCompatActivity() {

    private lateinit var btnVoltar: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacao_pedido)

        btnVoltar = findViewById(R.id.btn_voltar)
        btnVoltar.setOnClickListener {
            finish()
    }
        val button = findViewById<Button>(R.id.btn_confirmar_pedido_final)

        button.setOnClickListener {
            val intent = Intent(this, DetalhesRestaurantes::class.java)
            startActivity(intent)
        }
}
}
