package com.example.equipe01_projeto_ifood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.equipe01_projeto_ifood.databinding.ActivityDetalhesProdutoBinding

class DetalhesProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetalhesProdutoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}