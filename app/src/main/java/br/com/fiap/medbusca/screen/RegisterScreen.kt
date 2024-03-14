package br.com.fiap.medbusca.screen

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun RegisterScreen() {
    var text by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Create,
                            contentDescription = "Localized description"
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Cadastrar Receita")
                }
            )
        }

    ) { innerPadding ->
        val checkedState = remember { mutableStateOf(true) }
        FlowColumn(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth()
        ) {
            
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                label = { Text("Nome da Receita") }

            )
//            Text(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth(),
//                text = "Medicamento"
//            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                label = { Text("Medicamento") }
            )
//            Text(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth(),
//                text = "Data de Emissão"
//
//            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                label = { Text("Data de Emissão") }
            )
//            Text(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth(),
//                text = "Posologia"
//
//            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                label = { Text("Posologia") }
            )

            Text(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                text = "Uso Contínuo?"

            )
            FlowRow(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 4.dp, start = 16.dp, end = 16.dp)
                    .align(Alignment.Start),
                verticalArrangement = Arrangement.Center) {

                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it},
                    modifier = Modifier
                )

                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically),
                    text = "Selecionar esta caixa se o tratamento for continuo.",
                    fontSize = 12.sp
                )

            }


            FlowRow(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally)
            ) {


            }
            Button(
                modifier = Modifier
                    .padding (start= 50.dp,bottom = 16.dp)
                    .width(290.dp),
                onClick = { }) {
                Text("Cadastrar")
            }
            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = "Receituário de antimicrobiano",
                fontSize = 16.sp
            )
            OutlinedButton(
                modifier = Modifier
                    .padding(start = 230.dp)
                    .width(150.dp),
                onClick = { }) {
                Text("Consultar")
            }
            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = "Receituário da Dra Ana",
                fontSize = 16.sp
            )
            OutlinedButton(
                modifier = Modifier
                    .padding(start = 230.dp)
                    .width(150.dp),
                onClick = { }) {
                Text("Consultar")
            }
            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = "Remédio para diabetes",
                fontSize = 16.sp
            )
            OutlinedButton(
                modifier = Modifier
                    .padding(start = 230.dp)
                    .width(150.dp),
                onClick = { }) {
                Text("Consultar")
            }

        }
    }

    }
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}