package com.example.di.navigation.moduloroomdinavcompose.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader.ImdbApi
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader.ImdbRetrofitHelper
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader.dto.VersionsList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class GetHeaderExampleApiViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
)  : ViewModel() {
    //Referencia:  https://www.geeksforgeeks.org/retrofit-with-kotlin-coroutine-in-android/


    private val _apiResult= MutableStateFlow<VersionsList>(VersionsList())
    val apiResult = _apiResult.asStateFlow()

    //Aca va la implementacion del RetrofitHelper personalizado
    val imdbApi = ImdbRetrofitHelper.getInstance().create(ImdbApi::class.java)


    fun loadData(){
        viewModelScope.launch(Dispatchers.IO) {

            val apiKey = "26e76c1a54msh0e573f94b50bd3fp1932b4jsn2832de100f94"
            val apiHost = "imdb8.p.rapidapi.com"
            //val result: Response<GenresList> = imdbApi.getGenres(apiKey, apiHost)
            val result: Response<VersionsList> = imdbApi.getVersions(apiKey, apiHost)

            val url = result.raw().request.url.toString()
            Log.d(TAG, "URI utilizada: $url")



            if (result.isSuccessful) {

                Log.d(TAG, "Response: ${result.toString()}")

                if (result.body() != null) {
                    _apiResult.value = result.body()!!
                } else {
                    Log.e(TAG, "La respuesta está vacía o nula")
                }
            } else {
                Log.e(TAG, "Error en la respuesta: ${result.code()}")
            }


        }
    }

    companion object{
        const val TAG="ExampleApiViewModel"
    }
}