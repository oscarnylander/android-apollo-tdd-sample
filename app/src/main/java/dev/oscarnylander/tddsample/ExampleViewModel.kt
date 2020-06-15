package dev.oscarnylander.tddsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ExampleViewModel(
    private val exampleRepository: ExampleRepository
): ViewModel() {
    private val _data = MutableLiveData<FilmQuery.Data>()
    val data: LiveData<FilmQuery.Data> = _data

    init {
        viewModelScope.launch {
            _data.postValue(exampleRepository.filmAsync().await().data)
        }
    }
}