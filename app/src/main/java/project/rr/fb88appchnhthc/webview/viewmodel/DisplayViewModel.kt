package project.rr.fb88appchnhthc.webview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import project.rr.fb88appchnhthc.common.AppModel
import project.rr.fb88appchnhthc.webview.utils.Utils.Companion.contentDescriptions
import project.rr.fb88appchnhthc.webview.utils.Utils.Companion.contentTitles

class DisplayViewModel : ViewModel() {

    private var displayList = ArrayList<AppModel>()
    private var displayInfo = MutableLiveData<List<AppModel>>()
    val dsplynf: LiveData<List<AppModel>> get() = displayInfo

    private var displayErrors = CoroutineExceptionHandler { _, _ ->
        displayInfo.postValue(null)
    }

    fun dsplyFun(): MutableLiveData<List<AppModel>> {
        viewModelScope.launch(displayErrors + Dispatchers.IO) {
            for (n in contentTitles.indices)
                displayList.add(AppModel(contentTitles[n], contentDescriptions[n]))
        }
        displayInfo.postValue(displayList)
        return displayInfo
    }
}