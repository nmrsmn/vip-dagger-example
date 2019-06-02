package nl.topicus.vipdaggerexample.profile

class ProfileService(private val expensiveObject: ExpensiveObject)
{
    fun getPersonById(id: String)
        = Person("Niels Marsman")

    data class Person(val name: String)

    class ExpensiveObject
}