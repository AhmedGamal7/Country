package com.learning.country.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.learning.country.R
import com.learning.country.data.Country

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
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = country.name!!,
            fontSize = 25.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 5.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = country.nativeName!!,
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(5.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Alpha3Code : ${country.alpha3Code!!}",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Alpha2Code : ${country.alpha2Code!!}",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Capital : ${country.capital!!}",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Region : ${country.region!!}",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "SubRegion : ${country.subregion!!}",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Population : ${country.population!!}",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Demonym : ${country.demonym!!}",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Calling Codes : ${country.callingCodes!!}",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Time Zones : ${country.timezones!!}",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Currencies :",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        for (i in country.currencies!!) {
            Text(
                text = "-(code :${i.code}. Name :${i.name}. symbol :${i.symbol})",
                fontSize = 15.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.W100,
                modifier = Modifier
                    .padding(start = 50.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Languages :",
            fontSize = 18.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        for (i in country.languages!!) {
            Text(
                text = "-${i.name}(${i.nativeName})",
                fontSize = 18.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.W100,
                modifier = Modifier
                    .padding(start = 50.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

    }
}