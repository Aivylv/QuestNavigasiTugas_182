package com.example.questnavigasitugas_182.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questnavigasitugas_182.R


@OptIn (ExperimentalMaterial3Api::class)
@Composable

fun Formulir(
    OnBackClick: () -> Unit,
    OnSubmitClick: () -> Unit
) {
    var textNama by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }

    val genderList = listOf("Laki-laki","Perempuan")
    val statusList = listOf("Janda","Lajang","Duda")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.judul_form),
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Text(text = stringResource(id = R.string.nama_lengkap))
                OutlinedTextField(
                    value = textNama,
                    onValueChange = { textNama = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Masukkan nama lengkap") }
                )

                Text(text = stringResource(id = R.string.jenis_kelamin))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    genderList.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.selectable(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                        ) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                            Text(text = item)
                        }
                    }
                }

                Text(text = stringResource(id = R.string.status_perkawinan))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    statusList.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.selectable(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            )
                        ) {
                            RadioButton(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            )
                            Text(text = item)
                        }
                    }
                }

                Text(text = stringResource(id = R.string.alamat))
                OutlinedTextField(
                    value = textAlamat,
                    onValueChange = { textAlamat = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Masukkan alamat lengkap") }
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedButton(onClick = OnBackClick) {
                        Text(text = stringResource(id = R.string.back))
                    }

                    Button(
                        onClick = {
                            if (textNama.isNotEmpty() && textJK.isNotEmpty() && textStatus.isNotEmpty() && textAlamat.isNotEmpty()) {
                                showDialog = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7B1FA2))
                    ) {
                        Text(text = stringResource(id = R.string.submit))
                    }
                }

                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        confirmButton = {
                            TextButton(onClick = {
                                showDialog = false
                                OnSubmitClick()
                            }) {
                                Text("OK", color = Color(0xFF7B1FA2))
                            }
                        },
                        title = { Text(text = "Data Berhasil Disimpan!") },
                        text = {
                            Column {
                                Text("Terima kasih telah mengisi data dengan benar.\n")
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("Nama: $textNama")
                                Text("Jenis Kelamin: $textJK")
                                Text("Status: $textStatus")
                                Text("Alamat: $textAlamat")
                            }
                        },
                        shape = RoundedCornerShape(16.dp)
                    )
                }

            }
        }
    }
}