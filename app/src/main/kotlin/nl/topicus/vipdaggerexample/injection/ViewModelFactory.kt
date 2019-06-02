package nl.topicus.vipdaggerexample.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory<T: ViewModel> @Inject constructor(private val viewModelProvider: Provider<T>)
    : ViewModelProvider.Factory
{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
        = viewModelProvider.get() as T
}