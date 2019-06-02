package nl.topicus.vipdaggerexample.injection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.topicus.vipdaggerexample.profile.ProfileActivity

/**
 * Deze Module heb ik speciaal gemaakt voor alle Activites, Fragments, Services etc. Elke Activity,
 * Fragment of Service dient hierin opgenomen te worden zodat er een AndroidInjector gemaakt
 * kan worden. De annotatie @ContributesAndroidInjector zorgt hiervoor. Onder water maakt deze
 * annotatie een Subcomponent aan en koppelt deze aan de AndroidModule. Dit SubComponent zorgt dan
 * voor de injectie van deze klasse. Indien je objecten enkel in deze Activity, Fragment of Service
 * wil injecteren kan je lijst met modules opgeven (de in de modules geinjecteerde objecten zijn
 * dan enkel beschikbaar binnen de geannoteerde functies die deze module implementeren).
 */

@Module
abstract class AndroidModule
{
    @ContributesAndroidInjector(modules = [])
    abstract fun contributeProfileActivity(): ProfileActivity
}