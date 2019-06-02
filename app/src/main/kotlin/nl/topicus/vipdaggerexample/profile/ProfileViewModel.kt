package nl.topicus.vipdaggerexample.profile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import nl.topicus.vipdaggerexample.profile.ProfileService.Person
import javax.inject.Inject

/**
 * De @Inject constructor() is hier nodig. Deze annotatie zorgt ervoor dat deze klasse geinjecteerd
 * kan worden met objecten. Als er niets te injecten valt in deze klasse (lijkt me raar) dan alsnog
 * is de @Inject constructor() nodig.
 */

class ProfileViewModel @Inject constructor(private val profileService: ProfileService): ViewModel()
{
    private val profileSource: MutableLiveData<Person> = MutableLiveData()
    val profile: LiveData<Person> = profileSource

    fun init(id: String)
    {
        profileSource.value = profileService.getPersonById(id)
    }
}