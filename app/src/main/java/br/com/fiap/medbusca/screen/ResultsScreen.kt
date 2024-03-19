package br.com.fiap.medbusca.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.medbusca.database.repository.getAllFarmacias
import br.com.fiap.medbusca.database.repository.getFarmaciasPorMedicamento

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable

fun ResultsScreen(navController: NavController? = null, nomeMedicamento: String = "") {

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController?.popBackStack() }) {
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
                    Text("MedBusca")
                }
            )
        }

    ) { innerPadding ->
        FlowColumn(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                text = "${nomeMedicamento} encontrado(a) nas seguintes farmácias perto de você:"

            )

            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(){
                items(getFarmaciasPorMedicamento(nomeMedicamento)){
                    Card( modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)){
                        FlowRow {
                            Text(text = "${it.nomeFarmacia}")
                        }
                        FlowRow {
                            Text(text = "Endereço - ${it.endereco}")
                        }
                        FlowRow {
                            Text(text = "Horário de funcionamento - ${it.horarioFuncionamento}")
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }


            FlowRow(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally)
            ) {

                OutlinedButton(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .width(150.dp),
                    onClick = { navController?.navigate("home") }) {
                    Text("Nova Busca")
                }

            }
        }
    }
}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SearchScreenPreview() {
//    ResultsScreen()
//}