package br.com.fiap.medbusca.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.medbusca.model.Receita

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeReceitasScreen(navController: NavController? = null) {
    var listReceitaState = remember {
        mutableStateListOf<Receita>().apply {
            add(Receita(
                name = "Receituário PS",
                medicine = "Amoxicilina",
                date = "12/03/2024",
                dosage = "1 comprimido por dia",
                continuosUse = false))
            add(
                Receita(
                    name = "Receituário Dra. Ana",
                    medicine = "Profenid",
                    date = "16/03/2024",
                    dosage = "1 comprimido a cada 8 horas",
                    continuosUse = false)
            )
            add(
                Receita(
                    name = "Receituário Dra. Ana",
                    medicine = "Dipirona",
                    date = "16/10/2024",
                    dosage = "1 comprimido a cada 8 horas",
                    continuosUse = false)
            )
            add(
                Receita(
                    name = "Receituário Dra. Ana",
                    medicine = "Paracetamol",
                    date = "25/05/2024",
                    dosage = "1 comprimido a cada 8 horas",
                    continuosUse = true)
            )

            add(
                Receita(
                    name = "Receituário Dra. Ana",
                    medicine = "Paracetamol",
                    date = "25/05/2024",
                    dosage = "1 comprimido a cada 8 horas",
                    continuosUse = true)
            )
            add(
                Receita(
                    name = "Receituário Dra. Ana",
                    medicine = "Paracetamol",
                    date = "25/05/2024",
                    dosage = "1 comprimido a cada 8 horas",
                    continuosUse = true)
            )
            add(
                Receita(
                    name = "Receituário Dra. Ana",
                    medicine = "Paracetamol",
                    date = "25/05/2024",
                    dosage = "1 comprimido a cada 8 horas",
                    continuosUse = true)
            )
            add(
                Receita(
                    name = "Receituário Dra. Ana",
                    medicine = "Paracetamol",
                    date = "25/05/2024",
                    dosage = "1 comprimido a cada 8 horas",
                    continuosUse = true)
            )
            add(
                Receita(
                    name = "Receituário Dra. Ana",
                    medicine = "Paracetamol",
                    date = "25/05/2024",
                    dosage = "1 comprimido a cada 8 horas",
                    continuosUse = true)
            )
        }

    }

    Scaffold(Modifier.fillMaxWidth(),
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
                    Text("Home Receitas")
                }
            )
        }

    ) {
        //Spacer(modifier = Modifier.padding(top = 50.dp))
        //ReceitaItem()
        LazyColumn() {
            items(listReceitaState.size) { index ->
                ReceitaItem(listReceitaState[index])
            }
        }

    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeReceitasScreenPreview() {
    HomeReceitasScreen()
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ReceitaItem(receita : Receita){



    Row(
        modifier = Modifier.padding(top = 70.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start){

        Text(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp),
            text = receita.name,
            fontSize = 15.sp
        )
        OutlinedButton(
            modifier = Modifier
                .width(120.dp),
            onClick = { }) {
            Text("Consultar")
        }
    }

}