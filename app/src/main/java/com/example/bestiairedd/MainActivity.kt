package com.example.bestiairedd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bestiairedd.ui.screen.beast.SearchBeastScreen
import com.example.bestiairedd.ui.theme.BestiaireDDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BestiaireDDTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    // On crée un NavController pour naviguer entre les composables
                    val navController = rememberNavController()

                    // On appelle notre NavHost
                    BestiaireDDNavHost(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Composable
fun BestiaireDDNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = "search", //! start navigation
        modifier = modifier
    ) {

        composable(route = "search") {  //! init name  navigation
            SearchBeastScreen(
                onNavigateToDetail = { monsterIndex ->
                    navController.navigate("detail/$monsterIndex")
                }
            )
        }


        /*composable(route = "detail/{monsterIndex}") { backStackEntry ->
            val monsterIndex = backStackEntry.arguments?.getString("monsterIndex") ?: ""
            // On appelle le composable DetailBeastScreen
            DetailBeastScreen(monsterIndex = monsterIndex)
        }*/
    }
}
