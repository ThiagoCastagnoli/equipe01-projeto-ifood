package com.example.equipe01_projeto_ifood

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController

class FragmentLogin: Fragment(R.layout.login_fragment){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val buttonEntrar = view. findViewById<Button>(R.id.button_entrar)

        buttonEntrar.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentHomePage)

        }


    }




}


