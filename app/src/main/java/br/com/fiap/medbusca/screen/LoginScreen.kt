package br.com.fiap.medbusca.screen

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.medbusca.model.Usuario
import br.com.fiap.medbusca.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun LoginScreen(navController: NavController? = null) {
    var emailState by remember { mutableStateOf("") }
    var senhaState by remember { mutableStateOf("") }
    var usuarioState by remember { mutableStateOf<Usuario>(Usuario(0, "", "")) }
    var statusLoginState by remember { mutableStateOf("") }

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
                        Text("MedBusca")
                    }
                )
            }

        ) { innerPadding ->
        FlowColumn(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                text = "Bem-vindo ao Med!"

            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = emailState,
                onValueChange = { emailState = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                value = senhaState,
                onValueChange = { senhaState = it },
                label = { Text("Enter password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Text(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp)
                    .fillMaxWidth(),
                text = statusLoginState
            )

            FlowRow(modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally)) {

                OutlinedButton(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .width(150.dp),
                    onClick = { }) {
                    Text("Criar uma conta")
                }
                Button(
                    modifier = Modifier.width(150.dp),
                    onClick = {
                        statusLoginState = ""
                        val user = Usuario(0, emailState, senhaState)
                        val call = RetrofitFactory().getService().doLogin(user)

                        call.enqueue(object : Callback<Usuario> {
                            override fun onResponse(
                                call: Call<Usuario>,
                                response: Response<Usuario>
                            ) {
                                usuarioState = response.body()!!
                                statusLoginState = "Sucesso, UserID: ${usuarioState.id}"
                                navController?.navigate("receitas")
                            }

                            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                                statusLoginState = "Falha no login"
                                Log.i("CHRIS", t.stackTrace.toString())
                            }
                        })
                    }) {
                    Text("Login")
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}