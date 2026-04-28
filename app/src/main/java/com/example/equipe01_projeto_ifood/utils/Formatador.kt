package com.example.equipe01_projeto_ifood.utils

import java.text.NumberFormat
import java.util.Locale

fun formatarMoeda(valor: Double): String {
    val locale = Locale.Builder()
        .setLanguage("pt")
        .setRegion("BR")
        .build()

    return NumberFormat.getCurrencyInstance(locale).format(valor)
}