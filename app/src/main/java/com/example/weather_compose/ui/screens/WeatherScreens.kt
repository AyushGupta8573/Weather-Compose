package com.example.weather_compose.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    state: WeatherState,
    onSettingClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column {
                AnimatedVisibility(visible = state.status == Status.LOADING) {
                    CircularProgressIndicator()
                    Text(text = "Loading...")
                }
                AnimatedVisibility(visible = state.status == Status.ERROR) {
                    Column {
                        Text(
                            text = "Error", fontSize = 22.sp,
                            color = MaterialTheme.colorScheme.onError
                        )
                        Text(
                            text = state.error,
                            color = MaterialTheme.colorScheme.onError
                        )
                    }
                }
            }
        }
        AnimatedVisibility(visible = state.status == Status.SUCCESS) {
            Column {
                Text(text = "Weather", fontSize = 22.sp)
                Text(
                    text = "Temperature: ${state.result.main?.temp ?: "Not availlable"}",
                    fontSize = 22.sp
                )
            }
        }
    }
}