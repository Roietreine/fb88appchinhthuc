package project.rr.fb88appchnhthc.privacy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import project.rr.fb88appchnhthc.common.AppModel
import project.rr.fb88appchnhthc.privacy.Utils.Companion.privacyDesc
import project.rr.fb88appchnhthc.privacy.Utils.Companion.privacyTitle

class PrivacyViewModel : ViewModel() {

    private var privacyList = ArrayList<AppModel>()
    private var privacyInfo = MutableLiveData<List<AppModel>>()
    val prvcyNf : LiveData<List<AppModel>> get() = privacyInfo

    private var privacyError = CoroutineExceptionHandler { _, _ ->
        privacyInfo.postValue(null)
    }

    fun pvcFun() : MutableLiveData<List<AppModel>> {
        viewModelScope.launch(privacyError + Dispatchers.IO){
            for (n in privacyTitle.indices){
                privacyList.add(AppModel(privacyTitle[n], privacyDesc[n]))
            }
            privacyInfo.postValue(privacyList)
        }
        return privacyInfo
    }

}