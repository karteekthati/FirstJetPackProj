package kk.compose.firstjetpackproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kk.compose.firstjetpackproj.ui.utils.FunctionJetpackNavigationGraph
import kk.compose.firstjetpackproj.ui.theme.FirstJetPackProjTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FirstJetPackProjTheme {
                TestJatpackApp()
            }
        }
    }

    @Composable
    fun TestJatpackApp() {
        FunctionJetpackNavigationGraph()
    }
}