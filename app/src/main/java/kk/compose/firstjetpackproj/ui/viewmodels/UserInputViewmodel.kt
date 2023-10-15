package kk.compose.firstjetpackproj.ui.viewmodels
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kk.compose.firstjetpackproj.ui.data.UserDataUiEvents
import kk.compose.firstjetpackproj.ui.data.UserInputScreenState

class UserInputViewModel: ViewModel(){
    var uiState = mutableStateOf(UserInputScreenState())

    companion object{
        const val TAG = "UserInputViewModel"
    }
    fun onEvent(event: UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )

                Log.d(TAG,"onEvent: UserNameEntered->> ${uiState.value}")
            }
            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
                Log.d(TAG,"onEvent: Animal Selected->> ${uiState.value}")
            }
        }
    }
    fun isValidState() : Boolean{
       return !uiState.value.nameEntered.isNullOrEmpty() &&
                !uiState.value.animalSelected.isNullOrEmpty()
    }

}


