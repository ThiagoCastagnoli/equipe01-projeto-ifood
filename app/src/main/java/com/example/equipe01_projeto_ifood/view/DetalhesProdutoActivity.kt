package com.example.equipe01_projeto_ifood.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.equipe01_projeto_ifood.R
import com.example.equipe01_projeto_ifood.databinding.ActivityDetalhesProdutoBinding
import com.example.equipe01_projeto_ifood.model.Opcional
import com.example.equipe01_projeto_ifood.utils.formatarMoeda
import com.example.equipe01_projeto_ifood.adapter.OpcionalDePedidoAdapter

class DetalhesProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetalhesProdutoBinding.inflate(layoutInflater) }

    private var valorProdutoPedido = 20.0
    private var qtdProdutosPedidos = 1
    private var valorOpcionais = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configurarRecyclerView()
        configurarBotoes()
        atualizarTotal()
    }

    private fun configurarRecyclerView() {
        val listaOpcionais = listOf(
            Opcional("Picles", "teste", 10.0, R.drawable.picles, 0),
            Opcional("Queijo", "Incremente seu lanche com esse sabor", 5.0, R.drawable.queijo, 0),
            Opcional("Onion rings", "Experimente", 18.0, R.drawable.onion_rings, 0),
            Opcional("Suco de morango", "É uma delícia", 12.0, R.drawable.suco_morango, 0),
            Opcional(
                "Batata frita",
                "Incremente seu lanche com esse sabor",
                5.0,
                R.drawable.batata_frita1,
                0
            ),
            Opcional("Refri", "Refrescante", 9.0, R.drawable.refri1, 0),
            Opcional("Água", "Incremente seu lanche com esse sabor", 5.0, R.drawable.agua1, 0)
        )

        val adapter = OpcionalDePedidoAdapter(listaOpcionais) {}
        binding.recyclerViewOpcionais.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewOpcionais.adapter = adapter
    }

    private fun configurarBotoes() {

        binding.imageViewAdicionarProduto.setOnClickListener {
            qtdProdutosPedidos++
            binding.textViewQtdProdutosPedidos.text = qtdProdutosPedidos.toString()
        }

        binding.imageViewMenosProdutos.setOnClickListener {
            if (qtdProdutosPedidos > 1) {
                qtdProdutosPedidos--
                binding.textViewQtdProdutosPedidos.text = qtdProdutosPedidos.toString()
            }
        }

        binding.btnConfirmarPedido.setOnClickListener {
            val intent = Intent(this, ConfirmacaoPedidoActivity::class.java)
            startActivity(intent)
        }

        binding.btnVoltar.setOnClickListener { finish() }
    }

    private fun atualizarTotal() {
        val total = (valorProdutoPedido * qtdProdutosPedidos) + valorOpcionais
        binding.textViewValorTotalDoPedido.text = formatarMoeda(total)
    }
}