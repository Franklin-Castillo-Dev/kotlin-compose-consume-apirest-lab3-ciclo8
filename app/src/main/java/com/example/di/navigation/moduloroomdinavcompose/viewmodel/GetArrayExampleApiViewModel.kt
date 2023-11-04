package com.example.di.navigation.moduloroomdinavcompose.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetarray.ShibeApi
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetarray.ShibeRetrofitHelper
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetarray.dto.ShibeList
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetsimple.JokeApi
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetsimple.JokeRetrofitHelper
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetsimple.dto.JokeList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


class GetArrayExampleApiViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
)  : ViewModel() {
    //Referencia:  https://www.geeksforgeeks.org/retrofit-with-kotlin-coroutine-in-android/


    private val _apiResult= MutableStateFlow<ShibeList>(ShibeList())
    val apiResult = _apiResult.asStateFlow()

    //Aca va la implementacion del RetrofitHelper personalizado
    val shibeApi = ShibeRetrofitHelper.getInstance().create(ShibeApi::class.java)


    fun loadData(){
        viewModelScope.launch(Dispatchers.IO) {

            val result = shibeApi.getShibe()


            val body = result.string()

            val shibeList: List<String> = Gson().fromJson(body, object : TypeToken<List<String>>() {}.type)


            _apiResult.value = ShibeList(shibeList)



        }
    }

    companion object{
        const val TAG="GetArrayExampleApiViewModel"
    }
}