import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecharactersbase.CharacterModel
import com.example.composecharactersbase.RetrofitClient
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    var characters by mutableStateOf<List<CharacterModel>>(emptyList())
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getCharacters() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.getCharacters()
                characters = response.results
            } catch (e: Exception) {
                errorMessage = "Erro: ${e.message}"

        }
    }
}
}
