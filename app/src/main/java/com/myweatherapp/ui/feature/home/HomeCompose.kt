package com.myweatherapp.ui.feature.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.myweatherapp.data.request.CurrentWeatherRequest
import com.myweatherapp.resource.Constants
import com.myweatherapp.resource.StringConstants
import com.myweatherapp.resource.extension.convertTemperatureToCelsius
import com.myweatherapp.resource.extension.convertTimeMillisToFormattedString
import com.myweatherapp.resource.extension.myAppPreferences
import com.myweatherapp.resource.extension.set
import com.myweatherapp.ui.widgets.CommonTextWithSpan

@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavHostController){
    Column (Modifier.fillMaxSize()){
        TabScreen(homeViewModel, navController)
    }
}

@Composable
fun TabScreen(homeViewModel: HomeViewModel, navController: NavHostController) {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Current", "History")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(modifier = Modifier.background(color = Color.Gray), selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(modifier = Modifier.background(color = Color.Gray), text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> CurrentWeather(homeViewModel, navController)
            1 -> HistoryWeather(homeViewModel)
        }
    }
}

@Composable
fun CurrentWeather(homeViewModel: HomeViewModel, navController: NavHostController) {
    val locationData = homeViewModel.getLocationData().observeAsState()

    val context = LocalContext.current

    if (locationData.value != null){
        Log.e("mylog-->", "called")
        SideEffect {
            if (locationData.value != null) {
                val currentWeatherRequest = CurrentWeatherRequest(
                    locationData.value?.latitude!!,
                    locationData.value?.longitude!!
                )
                homeViewModel.getCurrentWeatherData(currentWeatherRequest)
            }
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {


        Spacer(modifier = Modifier.size(50.dp))

        AsyncImage(
            model = Constants.getImageUrl() + "${homeViewModel.weatherResponseState.value.weather?.get(0)?.icon}@2x.png",
            contentDescription = "", modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.size(30.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            CommonTextWithSpan(text = homeViewModel.weatherResponseState.value.name, boldText = StringConstants.cityConst,
                Color.Black)
            Spacer(modifier = Modifier.size(30.dp))
            CommonTextWithSpan(text = homeViewModel.weatherResponseState.value.name, boldText = StringConstants.countryConst,
                Color.Black)
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            CommonTextWithSpan(text = homeViewModel.weatherResponseState.value.sys?.sunrise?.convertTimeMillisToFormattedString(), boldText = StringConstants.sunriseConst,
                Color.Black)

            Spacer(modifier = Modifier.size(30.dp))

            CommonTextWithSpan(text = homeViewModel.weatherResponseState.value.sys?.sunset?.convertTimeMillisToFormattedString(),
                boldText = StringConstants.sunsetConst,
                Color.Black)
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            CommonTextWithSpan(text = homeViewModel.weatherResponseState.value.main?.temp?.convertTemperatureToCelsius(),
                boldText = StringConstants.tempConst,
                Color.Black)
        }

        Spacer(modifier = Modifier.weight(1f))
        Text(
            "Logout",
            modifier = Modifier.clickable {
                                      context.myAppPreferences[StringConstants.sessionConst] = false
                navController.navigate(StringConstants.loginRoute){
                    popUpTo(StringConstants.homeRoute) {
                        inclusive = true
                    }
                }
            },
            color = Color.Blue
        )
    }

}