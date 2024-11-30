package com.bootcamp.sprintcincokotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bootcamp.sprintcincokotlin.R
import com.bootcamp.sprintcincokotlin.state.Producto


class ProductosViewModel : ViewModel() {

    private val _productos = MutableLiveData<List<Producto>>()
    val productos: LiveData<List<Producto>> = _productos

    private var currentId = 0

    init {
        _productos.value = listOf(
            Producto(currentId++, "Zapatilla XAP LITE", 50274.0, R.drawable.imagen1),
            Producto(currentId++, "Zapatilla AP CASIM", 80900.0, R.drawable.imagen2),
            Producto(currentId++, "Zapatilla ZAP NIGHT", 43100.0, R.drawable.imagen3),
            Producto(currentId++, "Zapatilla ZAP LITE 3.0", 31740.0, R.drawable.imagene),
            Producto(currentId++, "Zapatilla ZAP HOVWR", 64500.0, R.drawable.imagen5),
            Producto(currentId++, "Zapatilla CLUB 85", 85000.0, R.drawable.imagen6),
            Producto(currentId++, "Zapatilla CAP PRO MIR", 25090.0, R.drawable.imagen7),
            Producto(currentId++, "Zapatilla FEEL", 35999.0, R.drawable.imagen8)
        )
    }

    fun obtenerProductoPorId(id: Int): Producto? {
        return _productos.value?.find { it.id == id }
    }


    fun agregarProducto(nombre: String, precio: Double, imagen: Int) {
        val nuevoProducto = Producto(
            id = currentId++,
            nombre = nombre,
            precio = precio,
            imagen = imagen
        )
        _productos.value = _productos.value?.plus(nuevoProducto)
    }
}