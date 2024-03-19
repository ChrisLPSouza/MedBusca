package br.com.fiap.medbusca.screen

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.AlertDialog
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
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.coordinatorlayout.widget.CoordinatorLayout.DispatchChangeEvent
import androidx.navigation.NavController
import br.com.fiap.medbusca.components.CampoDeTextoEditavel
import br.com.fiap.medbusca.database.repository.ReceitaRepository
import br.com.fiap.medbusca.model.Receita
import br.com.fiap.medbusca.model.ReceitaX
import br.com.fiap.medbusca.model.Usuario
import br.com.fiap.medbusca.service.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun RegisterScreen(navController: NavController? = null) {

    var context = LocalContext.current
    var receitaRepository = ReceitaRepository(context)
    var nomeReceita by remember { mutableStateOf("") }
    var medicamento by remember { mutableStateOf("") }
    var dataEmissao by remember { mutableStateOf("") }
    var posologia by remember { mutableStateOf("") }
    var usoContinuo by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController?.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
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

        //val scope = remember { ShowDialog(receita = null, navController = null) }

        FlowColumn(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth()
        ) {
            CampoDeTextoEditavel(
                label = "Nome da Receita",
                value = nomeReceita,
                placeHolder = "Nome da Receita",
                atualizarTexto = {
                    nomeReceita = it
                }
            )
            CampoDeTextoEditavel(
                label = "Medicamento",
                value = medicamento,
                placeHolder = "Medicamento",
                atualizarTexto = {
                    medicamento = it
                }
            )
            CampoDeTextoEditavel(
                label = "Data de Emissão",
                value = dataEmissao,
                placeHolder = "Data de Emissão",
                atualizarTexto = {
                    dataEmissao = it
                }
            )
            CampoDeTextoEditavel(
                label = "Posologia",
                value = posologia,
                placeHolder = "Posologia",
                atualizarTexto = {
                    posologia = it
                }
            )

            Text(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                text = "Uso Contínuo?"

            )
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 16.dp, end = 16.dp)
                    .align(Alignment.Start),
                verticalArrangement = Arrangement.Center
            ) {

                Checkbox(
                    checked = usoContinuo,
                    onCheckedChange = { usoContinuo = it },
                    modifier = Modifier
                )
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically),
                    text = "Selecionar esta caixa se o tratamento for contínuo.",
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
                    .padding(start = 50.dp, bottom = 16.dp)
                    .width(290.dp),
                onClick = {
//                    val receita = Receita(
//                        id = 0,
//                        receita = nomeReceita,
//                        medicamento = medicamento,
//                        data = dataEmissao,
//                        posologia = posologia,
//                        usoContinuo = usoContinuo
//                    )
                    //receitaRepository.salvar(receita)

                    CoroutineScope(Dispatchers.Main).launch {

                        val receita = Receita(
                            0,
                            nomeReceita,
                            medicamento,
                            dataEmissao,
                            posologia,
                            usoContinuo)


                        withContext(Dispatchers.IO){
                            val call = RetrofitFactory().getService().cadastraReceita(receita)

                            call.enqueue(object : Callback<Receita> {
                                override fun onResponse(
                                    call: Call<Receita>,
                                    response: Response<Receita>
                                ) {
                                    val result = response.body()!!
                                    navController?.navigate("receitas")
                                }

                                override fun onFailure(call: Call<Receita>, t: Throwable) {

                                    Log.i("CHRIS", t.stackTrace.toString())
                                }
                            })
                        }
                    }

                }) {
                Text("Cadastrar")
            }

        }
    }
}

@Composable
private fun ShowDialog(receita: Receita, navController: NavController?) {
    AlertDialog(
        title = {
            Text(text = "Sucesso")
        },
        text = {
            Text(text = "Receita: ${receita.receita}, cadastrado")
        },
        onDismissRequest = {

        },
        confirmButton = {
            TextButton(
                onClick = {
                    navController?.navigate("receitas")
                }
            ) {
                Text("Ir para receitas")
            }
        },

    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}

