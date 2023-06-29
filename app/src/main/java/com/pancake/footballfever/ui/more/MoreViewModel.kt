package com.pancake.footballfever.ui.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pancake.footballfever.utilities.Event

class MoreViewModel : ViewModel(),MoreFragmentListener {

    val moreBackEvent = MutableLiveData<Event<Unit>>()

    val moreInjuriesEvent = MutableLiveData<Event<Unit>>()

    val moreAboutEvent = MutableLiveData<Event<Unit>>()
    override fun onBackClick() {
        moreBackEvent.postValue(Event(Unit))
    }

    override fun onInjuriesClick() {
        moreInjuriesEvent.postValue(Event(Unit))
    }

    override fun onAboutClick() {
        moreAboutEvent.postValue(Event(Unit))
    }

}
