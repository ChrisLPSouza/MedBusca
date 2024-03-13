package br.com.fiap.medbusca.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun LoginScreen() {
    var text by remember { mutableStateOf("Digite seu email") }
    var password by remember { mutableStateOf("") }

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
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                text = "Bem-vindo ao Med!"

            )
            OutlinedTextField(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                label = { Text("Email") }

            )
            OutlinedTextField(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Text(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                text = "Esqueceu a senha?"

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
                    onClick = { }) {
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