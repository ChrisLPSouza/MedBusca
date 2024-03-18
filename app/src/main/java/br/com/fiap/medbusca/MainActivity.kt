package br.com.fiap.medbusca

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.medbusca.screen.HomeReceitasScreen
import br.com.fiap.medbusca.screen.HomeScreen
import br.com.fiap.medbusca.screen.LoginScreen
import br.com.fiap.medbusca.screen.RegisterScreen
import br.com.fiap.medbusca.screen.ResultsScreen
import br.com.fiap.medbusca.ui.theme.MedBuscaTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedBuscaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            LoginScreen(navController)
                        }
                        composable(route = "home") {
                            HomeScreen(navController)
                        }
                        composable(route = "receitas") {
                            HomeReceitasScreen(navController)
                        }
                        composable(route = "register") {
                            RegisterScreen(navController)
                        }
                        composable(route = "results/{nomeMedicamento}") {
                            var nomeMedicamento = it.arguments?.getString("nomeMedicamento")
                            ResultsScreen(navController, nomeMedicamento!!)
                        }
                    }
                }
            }
        }
    }
}

