package com.example.equipe01_projeto_ifood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.equipe01_projeto_ifood.databinding.OpcionalItemLayoutBinding
import com.example.equipe01_projeto_ifood.model.Opcional
import com.example.equipe01_projeto_ifood.utils.formatarMoeda

class OpcionalDePedidoAdapter(
    private val listaOpcionais: List<Opcional>,
    private val onQuantidadeAlterada: (Opcional, Int) -> Unit
) : RecyclerView.Adapter<OpcionalDePedidoAdapter.OpcionalViewHolder>() {

    inner class OpcionalViewHolder(
        private val binding: OpcionalItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(opcional: Opcional) {
            binding.textViewNomeOpcional.text = opcional.nome
            binding.textViewDescricaoOpcional.text = opcional.descricao
            binding.textViewValorOpcional.text = formatarMoeda(opcional.valor)
            binding.imageViewOpcional.setImageResource(opcional.fotoId)
            binding.textViewQtdOpcional.text = opcional.qtd.toString()

            binding.imageViewAddOpcional.setOnClickListener {
                opcional.qtd++
                atualizarQtd(opcional)
                onQuantidadeAlterada(opcional, +1)
            }

            binding.imageViewMenosOpcional.setOnClickListener {
                if (opcional.qtd > 0) {
                    opcional.qtd--
                    atualizarQtd(opcional)
                    onQuantidadeAlterada(opcional, -1)
                }
            }
        }

        private fun atualizarQtd(opcional: Opcional) {
            binding.textViewQtdOpcional.text = opcional.qtd.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpcionalViewHolder {
        val binding = OpcionalItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OpcionalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OpcionalViewHolder, position: Int) {
        holder.bind(listaOpcionais[position])
    }

    override fun getItemCount(): Int = listaOpcionais.size
}