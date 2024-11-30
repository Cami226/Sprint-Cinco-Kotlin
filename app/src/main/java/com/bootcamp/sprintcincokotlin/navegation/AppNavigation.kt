package com.bootcamp.sprintcincokotlin.navegation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bootcamp.sprintcincokotlin.view.CarritoView
import com.bootcamp.sprintcincokotlin.view.DetalleProductoView
import com.bootcamp.sprintcincokotlin.view.ListaProductoView
import com.bootcamp.sprintcincokotlin.viewmodel.CarritoViewModel
import com.bootcamp.sprintcincokotlin.viewmodel.ProductosViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val productosViewModel: ProductosViewModel = viewModel()
    val carritoViewModel: CarritoViewModel = viewModel()


    NavHost(navController, startDestination = "listaProductos") {
        composable("listaProductos") {
            ListaProductoView(navController, productosViewModel, carritoViewModel)
        }
        composable("detalleProducto/{productoId}") { backStackEntry ->
            val productoId = backStackEntry.arguments?.getString("productoId")?.toInt() ?: 0
            DetalleProductoView(navController, productoId, productosViewModel, carritoViewModel)
        }
        composable("carrito") {
            CarritoView(navController, carritoViewModel)
        }

    }
}