package nl.topicus.vipdaggerexample.profile

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import nl.topicus.vipdaggerexample.R
import nl.topicus.vipdaggerexample.injection.ViewModelFactory
import javax.inject.Inject

class ProfileActivity: DaggerAppCompatActivity()
{
    @Inject lateinit var viewModelFactory: ViewModelFactory<ProfileViewModel>
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProfileViewModel::class.java)
        viewModel.init("12389123")

        observePerson()
    }

    private fun observePerson()
    {
        viewModel.profile.observe(this, Observer()
        {
            profile_title.text = it?.name ?: "Onbekend"
        })
    }
}