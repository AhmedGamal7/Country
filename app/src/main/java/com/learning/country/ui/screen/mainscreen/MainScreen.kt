package com.learning.country.ui.screen.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.learning.country.R
import com.learning.country.data.models.Country
import com.learning.country.ui.screen.composeview.SearchView
import com.learning.country.utils.NavHostItem
import org.koin.androidx.compose.viewModel


@Composable
fun MainScreen(navController: NavHostController) {

    val viewModel by viewModel<CountryViewModel>()
    val countryState = viewModel.countryList

    val searchViewState = remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_color)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.main_color))
        ) {
            SearchView(state = searchViewState)
            CountryList(navController, countryState.value, searchViewState)
        }
    }
}

@Composable
fun CountryList(
    navController: NavHostController,
    countries: List<Country>,
    searchViewState: MutableState<TextFieldValue>
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.main_color))
    )
    {
        val searchedText = searchViewState.value.text
        val myCountries = if (searchedText.isEmpty()) {
            countries
        } else {
            val resultList = mutableListOf<Country>()
            for (country in countries) {
                if (country.name!!.lowercase()
                        .contains(searchedText.lowercase())
                ) {
                    resultList.add(country)
                }
            }
            resultList
        }

        items(myCountries) { item ->
            CountryRow(navController, item = item)
        }
    }
}

@Composable
fun CountryRow(navController: NavHostController, item: Country) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("country", item)
                navController.navigate(NavHostItem.Detail.route)
            },
        backgroundColor = colorResource(id = R.color.card_color),
        elevation = 4.dp

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = item.name!!,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(5.dp)
            )
            Image(
                painter = rememberImagePainter(
                    data = item.flag,
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = "Loading",
                modifier = Modifier
                    .size(70.dp)
                    .padding(5.dp)
                    .align(Alignment.CenterVertically)
            )
        }

    }
}