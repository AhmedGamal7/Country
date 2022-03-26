package com.learning.country.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learning.country.R
import com.learning.country.data.models.Country
import com.learning.country.ui.screen.detailscreen.CountryDetailScreen
import com.learning.country.ui.screen.mainscreen.MainScreen
import com.learning.country.ui.theme.CountryTheme
import com.learning.country.utils.NavHostItem


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryTheme {
                Scaffold(
                    backgroundColor = colorResource(id = R.color.main_color)
                ) {
                    val navController = rememberNavController()
                    Navigation(navController)
                }
            }
        }
    }
}


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable(NavHostItem.Main.route) {
            MainScreen(navController = navController)
        }
        composable(
            NavHostItem.Detail.route
        ) {
            val country =
                navController.previousBackStackEntry?.savedStateHandle?.get<Country>("country")
            country?.let {
                CountryDetailScreen(country = it)
            }
        }
    }
}





