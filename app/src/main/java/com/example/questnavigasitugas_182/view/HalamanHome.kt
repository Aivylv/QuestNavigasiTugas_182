package com.example.questnavigasitugas_182.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_182.R


@OptIn (ExperimentalMaterial3Api::class)
@Composable

fun HalamanHome (
    OnMasukBtnClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding (horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.welcome),
            style = MaterialTheme.typography.titleLarge.copy (
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo Aplikasi",
            modifier = Modifier
                .size(220.dp)
                .padding(vertical = 16.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = stringResource(id = R.string.nama),
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.nim),
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
