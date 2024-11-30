package com.bootcamp.sprintcincokotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bootcamp.sprintcincokotlin.navegation.AppNavigation
import com.bootcamp.sprintcincokotlin.ui.theme.SprintCincoKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SprintCincoKotlinTheme {
                AppNavigation()
            }
        }
    }
}