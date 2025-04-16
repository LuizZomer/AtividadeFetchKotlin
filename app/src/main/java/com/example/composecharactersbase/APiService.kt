import com.example.composecharactersbase.CharacterResponse
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}