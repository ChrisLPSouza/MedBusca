package br.com.fiap.medbusca.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.medbusca.components.CampoDeTextoEditavel
import br.com.fiap.medbusca.components.CardAlerta

@RequiresApi(Build.VERSION_CODES.R)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable

fun HomeScreen(navController: NavController? = null) {
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
            Spacer(modifier = Modifier.height(16.dp))
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
                        onClick = { navController?.navigate("register") }) {
                        Text("Cadastrar")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            FlowRow() {
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    text = "Farmácias perto de mim",
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            FlowRow() {
                CampoDeTextoEditavel(
                    label = "Onde tem?",
                    value = nomeMedicamento,
                    placeHolder = "Digite aqui qual medicamento está procurando",
                    atualizarTexto = {
                        nomeMedicamento = it
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            FlowRow() {
                OutlinedButton(
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .width(150.dp),
                    onClick = { navController?.navigate("results/$nomeMedicamento") }) {
                    Text("Buscar")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            FlowRow() {
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    text = "Próximas ações e alertas",
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            FlowRow() {
                FlowColumn() {
                    CardAlerta(textCard = "Sua receita vai vencer em 3 dias")
                }
                Spacer(modifier = Modifier.width(16.dp))
                FlowColumn() {
                    CardAlerta(textCard = "Tomar medicamento cefalexina às 18h")
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Preview(showBackground = true, showSystemUi = true)
@Composable

fun HomeScreenPreview() {
    HomeScreen()
}