package br.com.fiap.medbusca.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.R)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(navController: NavController) {
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
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Home")
                }
            )
        }

    ) { innerPadding ->
        var nomeMedicamento by remember { mutableStateOf("") }

        FlowColumn(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth()
        ) {
            FlowRow() {
                FlowColumn() {
                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp),
                        text = "Minhas receitas",
                        fontSize = 16.sp
                    )
                }
                FlowColumn() {
                    OutlinedButton(
                        modifier = Modifier
                            .padding(start = 30.dp)
                            .width(150.dp),
                        onClick = { navController.navigate("register") }) {
                        Text("Cadastrar")
                    }
                }
            }
            FlowRow() {
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    text = "Farmácias perto de mim",
                    fontSize = 16.sp
                )
            }
            FlowRow() {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = nomeMedicamento,
                    onValueChange = { nomeMedicamento = it },
                    label = { Text("Onde tem?") },
                    placeholder = { Text("Digite aqui qual medicamento está procurando") }
                )
            }
            FlowRow() {
                OutlinedButton(
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .width(150.dp),
                    onClick = { navController.navigate("results") }) {
                    Text("Buscar")
                }
            }
            FlowRow() {
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    text = "Próximas ações e alertas",
                    fontSize = 16.sp
                )
            }
            FlowRow() {
                FlowColumn() {
                    Card(
                        modifier = Modifier
                            .height(110.dp)
                            .width(200.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 10.dp),
                            text = "Sua receita vai vencer em 3 dias",
                            fontSize = 16.sp
                        )
                    }
                }
                FlowColumn() {
                    Card(
                        modifier = Modifier
                            .height(110.dp)
                            .width(200.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Blue)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(start = 10.dp),
                            text = "Tomar medicamento cefalexina às 18h",
                            fontSize = 16.sp
                        )
                    }
                }
            }


        }
    }
}

//@RequiresApi(Build.VERSION_CODES.R)
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
// HomeScreenPreview() {
//    HomeScreen()
//}