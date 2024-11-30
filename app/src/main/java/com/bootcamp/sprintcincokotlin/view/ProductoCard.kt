package com.bootcamp.sprintcincokotlin.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bootcamp.sprintcincokotlin.state.Producto

@Composable
fun ProductoCard(
    producto: Producto,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .width(200.dp)
            .height(280.dp)
            .clickable {onClick()}
    ) {
        Column(
            modifier = Modifier.padding(6.dp)
        ) {
            Image(
                painter = painterResource(id = producto.imagen),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)

            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = producto.nombre, fontSize = 20.sp)
            Text(text = "$ ${producto.precio}", fontSize = 32.sp)
        }
    }
}