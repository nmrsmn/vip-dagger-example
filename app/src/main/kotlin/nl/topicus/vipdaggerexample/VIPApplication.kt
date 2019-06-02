package nl.topicus.vipdaggerexample

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import nl.topicus.vipdaggerexample.injection.DaggerVIPApplicationComponent

/**
 * DaggerApplication (bestaat zowel in dagger.android als in dagger.android.support) zorgt ervoor
 * dat alle mogelijke injectors alvast geïmplementeerd zijn, waardoor een heleboel boilerplate is
 * voorkomen (zie het verschil tussen VIPApplication en VIPApplicationA). De werking
 * is verder exact hetzelfde!
 */

class VIPApplication: DaggerApplication()
{
    private val applicationInjector by lazy()
    {
        DaggerVIPApplicationComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate()
    {
        super.onCreate()

        // Do other stuff
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}