package com.example.equipe01_projeto_ifood.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.equipe01_projeto_ifood.R

class FragmentLogin: Fragment(R.layout.login_fragment){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val buttonEntrar = view. findViewById<Button>(R.id.button_entrar)

        buttonEntrar.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentHomePage)

        }


    }




}