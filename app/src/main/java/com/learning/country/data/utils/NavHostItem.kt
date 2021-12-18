package com.learning.country.data.utils

sealed class NavHostItem(val name: String, val route: String) {
    object Main : NavHostItem("Main", "MainScreen")
    object Detail : NavHostItem("Detail", "CountryDetailScreen")
}