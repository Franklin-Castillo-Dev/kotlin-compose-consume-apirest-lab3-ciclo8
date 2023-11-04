package com.example.di.navigation.moduloroomdinavcompose.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.di.navigation.moduloroomdinavcompose.api.practiceget.AnimeApi
import com.example.di.navigation.moduloroomdinavcompose.api.practiceget.AnimeRetrofitHelper
import com.example.di.navigation.moduloroomdinavcompose.api.practiceget.dto.AnimeList
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetsimple.JokeApi
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetsimple.JokeRetrofitHelper
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetsimple.dto.JokeList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


class GetSimpleExampleApiViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
)  : ViewModel() {
    //Referencia:  https://www.geeksforgeeks.org/retrofit-with-kotlin-coroutine-in-android/


    private val _apiResult= MutableStateFlow<JokeList>(JokeList())
    val apiResult = _apiResult.asStateFlow()

    //Aca va la implementacion del RetrofitHelper personalizado
    val jokeApi = JokeRetrofitHelper.getInstance().create(JokeApi::class.java)


    fun loadData(){
        viewModelScope.launch(Dispatchers.IO) {

            val result: Response<JokeList> = jokeApi.getJoke()

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
        const val TAG="GetSimpleExampleApiViewModel"
    }
}