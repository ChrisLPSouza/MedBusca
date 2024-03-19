package br.com.fiap.medbusca.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import br.com.fiap.medbusca.model.Receita
import br.com.fiap.medbusca.model.Usuario
import br.com.fiap.medbusca.service.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeReceitasScreen(navController: NavController? = null) {

    val lifecycleOwner by rememberUpdatedState(LocalLifecycleOwner.current)
    var listReceitaState by remember { mutableStateOf<MutableList<Receita>>(mutableListOf()) }

    val observer = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_RESUME) {
            val call = RetrofitFactory().getService().getReceita()

            call.enqueue(object : Callback<List<Receita>> {
                override fun onResponse(
                    call: Call<List<Receita>>,
                    response: Response<List<Receita>>
                ) {
                     listReceitaState = response.body()?.toMutableList()!!
                    Log.i("CHRIS", "")
                    //navController?.navigate("receitas")
                }

                override fun onFailure(call: Call<List<Receita>>, t: Throwable) {

                    Log.i("CHRIS", t.stackTrace.toString())
                }
            })
        }

    }

    lifecycleOwner.lifecycle.addObserver(observer)

    Scaffold(Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(

                actions = {
                          IconButton(onClick = {
                              CoroutineScope(Dispatchers.Main).launch {
                                  listReceitaState = mutableListOf()

                                  withContext(Dispatchers.IO){
                                      delay(500)
                                      val call = RetrofitFactory().getService().getReceita()

                                      call.enqueue(object : Callback<List<Receita>> {
                                          override fun onResponse(
                                              call: Call<List<Receita>>,
                                              response: Response<List<Receita>>
                                          ) {
                                              listReceitaState = response.body()?.toMutableList()!!
                                              Log.i("CHRIS", "")
                                              //navController?.navigate("receitas")
                                          }

                                          override fun onFailure(call: Call<List<Receita>>, t: Throwable) {

                                              Log.i("CHRIS", t.stackTrace.toString())
                                          }
                                      })
                                  }
                              }

                          }) {
                              Icon(
                                  imageVector = Icons.Filled.Refresh,
                                  contentDescription = "")
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
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier.padding(top = 60.dp)) {
                FlowRow(modifier = Modifier) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        onClick = {
                            navController?.navigate("register")
                        }) {
                        Text("Cadastrar Receita")
                    }
                }
            }

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
        modifier = Modifier
            .padding(top = 70.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start){

        Text(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp),
            text = receita.receita,
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