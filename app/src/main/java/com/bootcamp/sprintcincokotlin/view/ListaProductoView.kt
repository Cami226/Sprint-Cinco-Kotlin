package com.bootcamp.sprintcincokotlin.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid

import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bootcamp.sprintcincokotlin.R
import com.bootcamp.sprintcincokotlin.components.AppBarView
import com.bootcamp.sprintcincokotlin.navegation.NavigationBarSample
import com.bootcamp.sprintcincokotlin.viewmodel.CarritoViewModel
import com.bootcamp.sprintcincokotlin.viewmodel.ProductosViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaProductoView(navController: NavController, productosViewModel: ProductosViewModel,
                       carritoViewModel: CarritoViewModel) {
    val productos = productosViewModel.productos.value ?: emptyList()
    val totalArticulosCarrito = carritoViewModel.carrito.value?.sumOf { it.cantidad } ?: 0

    Scaffold(
        topBar = {
            AppBarView(stringResource(R.string.title_my))
        },
        bottomBar = {
            NavigationBarSample(navController, totalArticulosCarrito) // Pasa el total de artículos al carrito
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(productos) { producto ->
                    ProductoCard(
                        producto = producto,
                        onClick = {
                            navController.navigate("detalleProducto/${producto.id}")
                        }
                    )
                }
            }
        }
    }
}