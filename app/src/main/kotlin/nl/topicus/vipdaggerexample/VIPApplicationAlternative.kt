package nl.topicus.vipdaggerexample

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import nl.topicus.vipdaggerexample.injection.DaggerVIPApplicationComponent
import javax.inject.Inject

/**
 * Dagger Android geeft de developer de mogelijkheid om
 */

class VIPApplicationAlternative: Application(), HasActivityInjector, HasSupportFragmentInjector
{
    @Inject internal lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
    @Inject internal lateinit var dispatchingSupportFragmentInjector: DispatchingAndroidInjector<Fragment>

    private val applicationInjector by lazy()
    {
        DaggerVIPApplicationComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate()
    {
        super.onCreate()

        //initDagger()

        // Do other stuff
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingSupportFragmentInjector

    //private fun initDagger() = applicationInjector.inject(this)
}