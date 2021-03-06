package com.learning.country.ui.screen.detailscreen

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
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.learning.country.R
import com.learning.country.data.models.Country
import com.learning.country.ui.screen.composeview.MyText

@Composable
fun CountryDetailScreen(country: Country) {
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
            title = "${country.name} ", description = "", fontSize = 25.sp, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 5.dp)
        )
        MyText(
            title = "${country.nativeName} ", description = "", modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(5.dp)
        )

        country.alpha3Code?.let { MyText(title = "Alpha3Code :", description = it) }
        country.alpha2Code?.let { MyText(title = "Alpha2Code :", description = it) }
        country.capital?.let { MyText(title = "Capital :", description = it) }
        country.region?.let { MyText(title = "Region :", description = it) }
        country.subregion?.let { MyText(title = "SubRegion :", description = it) }
        MyText(title = "Population :", description = country.population.toString())
        country.demonym?.let { MyText(title = "Demonym :", description = it) }
        MyText(title = "Calling Codes :", description = country.callingCodes.toString())
        MyText(title = "Time Zones : ", description = country.timezones.toString())


        MyText(title = "Currencies:", description = "")
        for (i in country.currencies!!) {
            MyText(
                title = "",
                description = "-(code :${i.code}. Name :${i.name}. symbol :${i.symbol})",
                modifier = Modifier
                    .padding(start = 50.dp)
            )
        }


        MyText(title = "Languages:", description = "")
        for (i in country.languages!!) {
            MyText(
                title = "",
                description = "-${i.name}(${i.nativeName})",
                modifier = Modifier
                    .padding(start = 50.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

    }
}