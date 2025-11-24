package unit2.task2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Coroutine : ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun startWork(categoryName : String) {
        viewModelScope.launch {
            try{
                _result.value="Starting..."
                val data=fetchData(categoryName)
                _result.value= data
            }
            catch (e:Exception){
                _result.value="Error: ${e.message}"
            }
        }
    }

    private suspend fun fetchData(categoryName:String):String = withContext(Dispatchers.IO){
        delay(1000)
        return@withContext "Top 10 $categoryName companies"
    }

    override fun onCleared() {
        super.onCleared()
        //Automatic coroutine cancellation for viewModelScope
    }
}