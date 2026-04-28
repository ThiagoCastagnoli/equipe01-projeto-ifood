package com.example.equipe01_projeto_ifood.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.equipe01_projeto_ifood.Adapters.AdapterListRestaurants
import com.example.equipe01_projeto_ifood.Adapters.AdapterRestaurants
import com.example.equipe01_projeto_ifood.Adapters.BannerAdapter
import com.example.equipe01_projeto_ifood.model.Categorias
import com.example.equipe01_projeto_ifood.R
import com.example.equipe01_projeto_ifood.databinding.HomepageFragmentBinding
import com.example.equipe01_projeto_ifood.model.Lojas

class FragmentHomePage: Fragment(R.layout.homepage_fragment){


    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0

    private val bannerRunnable = object : Runnable {
        override fun run() {
            if (_binding == null) return

            val adapter = binding.viewPagerBanner.adapter ?: return
            val total = adapter.itemCount

            if (total == 0) return

            binding.viewPagerBanner.setCurrentItem(currentPage, true)
            currentPage = (currentPage + 1) % total

            handler.postDelayed(this, 3000)
        }
    }

    private var _binding: HomepageFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomepageFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        val recyclerRest = binding.recyclerviewRestaurants
        val listaCategorias = listOf(
            Categorias("Restaurantes", R.drawable.ic_restaurante),
            Categorias("Mercado", R.drawable.ic_mercado),
            Categorias("Farmácia", R.drawable.ic_farmacia),
            Categorias("Pet", R.drawable.ic_pet),
            Categorias("Express", R.drawable.ic_express),
            Categorias("Bebidas", R.drawable.ic_bebidas),
            Categorias("Shopping", R.drawable.ic_shopping),
            Categorias("Gourmet", R.drawable.ic_gourmet)
        )

        recyclerRest.layoutManager = GridLayoutManager(requireContext(), 4)
        recyclerRest.adapter = AdapterRestaurants(listaCategorias)
        binding.recyclerviewRestaurants.isNestedScrollingEnabled = false



        val listaBanners = listOf(
            R.drawable.ic_banner1,
            R.drawable.ic_banner2,
            R.drawable.ic_banner3,
            R.drawable.ic_banner4,
            R.drawable.ic_banner5,
            R.drawable.ic_banner6,
            R.drawable.ic_banner7
        )
        binding.viewPagerBanner.adapter = BannerAdapter(listaBanners)
        handler.postDelayed(bannerRunnable, 3000)


        val recyclerLojas = binding.recyclerviewLojas
        val listaLojas = listOf(
            Lojas("Mc Donalds", "restaurante 1 km", "40-50 min R$ 9,90", R.drawable.ic_logomc),
            Lojas("BurguerKing", "restaurante 3 km", "40-50 min R$ 12,90", R.drawable.ic_logobk),
            Lojas("OutBack", "restaurante 1 km", "40-50 min R$ 9,90", R.drawable.ic_logooubk),
            Lojas("Familia Madalosso", "restaurante 2 km", "40-50 min R$ 15,90", R.drawable.ic_logomadalosso),
            Lojas("StarBucks Coffee", "restaurante 1 km", "40-50 min R$ 9,90", R.drawable.ic_logostar),
            Lojas("Jeronimo", "restaurante 1 km", "40-50 min R$ 9,90", R.drawable.ic_logojeronimo)
        )
        recyclerLojas.layoutManager = LinearLayoutManager(view.context)
        recyclerLojas.adapter = AdapterListRestaurants(listaLojas)
        binding.recyclerviewLojas.isNestedScrollingEnabled = false


    }



    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(bannerRunnable)
        _binding = null
    }






}