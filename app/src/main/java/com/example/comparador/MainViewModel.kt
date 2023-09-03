package com.example.comparador

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var text1: String = ""
    private var text2: String = ""

    // LiveData para el resultado y el color del texto
    val result = MutableLiveData<String>()
    val textColor = MutableLiveData<Int>()

    // Métodos para establecer el texto en text1 y text2
    fun setText1(text: String) {
        text1 = text
    }

    fun setText2(text: String) {
        text2 = text
    }

    // Método para comparar los textos
    fun compareTexts() {
        // Lógica de comparación entre text1 y text2
        val areEqual = text1 == text2

        if (areEqual) {
            result.value = "Los textos son iguales"
            textColor.value = Color.rgb(0, 130, 0) // Cambia el color a verde
        } else {
            result.value = "Los textos son diferentes"
            textColor.value = Color.rgb(130, 0, 0) // Cambia el color a rojo
        }
    }
}
