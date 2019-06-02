package nl.topicus.vipdaggerexample.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import nl.topicus.vipdaggerexample.VIPApplication
import nl.topicus.vipdaggerexample.injection.modules.AndroidModule
import nl.topicus.vipdaggerexample.injection.modules.ServiceModule

/**
 * - Modules zijn herbruikbare (abstracte) klassen die de te injecteren objecten "providen" aan de
 * hand van functies geannoteerd met @Provides.
 *
 * - Dependencies zijn eventuele verwijzingen naar andere modules. Bij het opzetten van een modulair
 * VIP gaan we dit waarschijnlijk tegenkomen. Daarnaast is het mogelijk om componenten te gebruiken
 * die je niet de hele lifetime van je app wil gebruiken (alleen voor bepaalde activities)
 *
 * - De Component.Builder wordt gebruikt om een builder te maken voor dit component. Deze builder
 * wordt vervolgens in de VIPApplication gebruikt om Dagger te gebruiken.
 *
 * - BindsInstance is een annotatie die ervoor zorgt dat het geen wat wordt meegegeven (Application)
 * beschikbaar is in dit component. Hierdoor is het dus mogelijk om een ApplicationModule te maken
 * die bijvoorbeeld objecten als Resources of SharedPreferences injecteert (zonder dat hier dus
 * een Singleton klasse voor nodig is!)
 *
 * - AndroidSupportInjectionModule is de Dagger module die ervoor zorg draagt dat alle core android
 * klassen een AndroidInjector kunnen hebben, die er op zijn beurt weer voor zorgt dat de klasse
 * geinjecteerd wordt met de juiste instanties.
 */

@Component(modules = [AndroidSupportInjectionModule::class, AndroidModule::class, ServiceModule::class],
           dependencies = [])
interface VIPApplicationComponent: AndroidInjector<VIPApplication>
{
    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): VIPApplicationComponent
    }
}