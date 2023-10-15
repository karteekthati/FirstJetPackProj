package kk.compose.firstjetpackproj.ui.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kk.compose.firstjetpackproj.ui.screens.UserInputScreen
import kk.compose.firstjetpackproj.ui.screens.WelcomeScreen
import kk.compose.firstjetpackproj.ui.viewmodels.UserInputViewModel

@Composable
fun FunctionJetpackNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN) {
        composable(Routes.USER_INPUT_SCREEN) {
            UserInputScreen(userInputViewModel) { userName, animalSelected ->
                navController.navigate("${Routes.WELCOME_SCREEN}/$userName/$animalSelected")
            }
        }
        composable("${Routes.WELCOME_SCREEN}/{${Routes.USER_NAME}}/{${Routes.ANIMAL_SELECTED}}",
        arguments = listOf(
            navArgument(Routes.USER_NAME){  type = NavType.StringType},
            navArgument(Routes.ANIMAL_SELECTED){  type = NavType.StringType}
        )
        ) {backStackEntry ->
            val userName = backStackEntry.arguments?.getString(Routes.USER_NAME)
            val animalSelected = backStackEntry.arguments?.getString(Routes.ANIMAL_SELECTED)
            WelcomeScreen(userName, animalSelected) }
    }
}