package nl.topicus.vipdaggerexample.injection.modules

import dagger.Module
import dagger.Provides
import nl.topicus.vipdaggerexample.profile.ProfileService
import nl.topicus.vipdaggerexample.profile.ProfileService.ExpensiveObject

@Module
class ServiceModule
{
    @Provides
    fun provideProfileService(expensiveObject: ExpensiveObject): ProfileService
        = ProfileService(expensiveObject)

    @Provides
    fun provideExpensiveObject(): ExpensiveObject
        = ExpensiveObject()
}