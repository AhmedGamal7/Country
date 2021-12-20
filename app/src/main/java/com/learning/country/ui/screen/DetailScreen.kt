package com.learning.country.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.learning.country.R
import com.learning.country.data.models.Country
import com.learning.country.ui.screen.composeview.MyText

@Composable
fun CountryDetailScreen(navController: NavHostController, country: Country) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_color))
            .verticalScroll(ScrollState(0))
    ) {
        Image(
            painter = rememberImagePainter(
                data = country.flag!!,
                builder = {
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = "Loading",
            modifier = Modifier
                .size(300.dp)
                .padding(5.dp)
                .align(Alignment.CenterHorizontally)
        )

        MyText(
            title = "${country.name!!} ", description = "", fontSize = 25, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 5.dp)
        )
        MyText(
            title = "${country.nativeName} ", description = "", modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(5.dp)
        )
        MyText(title = "Alpha3Code :", description = country.alpha3Code!!)
        MyText(title = "Alpha2Code :", description = country.alpha2Code!!)
        MyText(title = "Capital :", description = country.capital!!)
        MyText(title = "Region :", description = country.region!!)
        MyText(title = "SubRegion :", description = country.subregion!!)
        MyText(title = "Population :", description = country.population!!.toString())
        MyText(title = "Demonym :", description = country.demonym!!)
        MyText(title = "Calling Codes :", description = country.callingCodes!!.toString())
        MyText(title = "Time Zones : ", description = country.timezones!!.toString())

        MyText(title = "Currencies:", description = "")

        for (i in country.currencies!!) {
            MyText(
                title = "",
                description = "-(code :${i.code}. Name :${i.name}. symbol :${i.symbol})",
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 50.dp)
            )
        }

        MyText(title = "Languages:", description = "")

        for (i in country.languages!!) {
            MyText(
                title = "",
                description = "-${i.name}(${i.nativeName})",
                fontSize = 15,
                modifier = Modifier
                    .padding(start = 50.dp)
            )
        }


        Spacer(modifier = Modifier.height(50.dp))

    }
}