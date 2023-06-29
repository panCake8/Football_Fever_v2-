package com.pancake.footballfever.ui.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pancake.footballfever.utilities.Event

class AboutViewModel:ViewModel(),AboutListener {

    val backEvent = MutableLiveData<Event<Unit>>()

    override fun onBackEvent() {
        backEvent.postValue(Event(Unit))
    }
}