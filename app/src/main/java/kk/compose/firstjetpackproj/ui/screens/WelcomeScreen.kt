package kk.compose.firstjetpackproj.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kk.compose.firstjetpackproj.ui.utils.FactComposable
import kk.compose.firstjetpackproj.ui.utils.TextComponent
import kk.compose.firstjetpackproj.ui.utils.TextWithShadow
import kk.compose.firstjetpackproj.ui.utils.TopBar
import kk.compose.firstjetpackproj.ui.viewmodels.FactsViewModel

@Composable
fun WelcomeScreen(userName: String?, animalSelected: String?) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    18.dp
                )
        ) {
            TopBar("Welcome $userName \uD83D\uDE0A")
            TextComponent(textvalue = "Thank you for sharing your data", textSize = 24.sp)
            Spacer(modifier = Modifier.size(60.dp))

            val finalText =
                if (animalSelected == "Cat") "You are a cat Lover \uD83D\uDC36" else "You are a Dog Lover \uD83D\uDC36"
            TextWithShadow(value = finalText)
            Spacer(modifier = Modifier.size(60.dp))

            val factsViewModel: FactsViewModel = viewModel()
            FactComposable(value = factsViewModel.generateRandomFact(animalSelected!!))
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("", "")
}