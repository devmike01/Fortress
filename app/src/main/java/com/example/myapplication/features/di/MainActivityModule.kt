package com.example.myapplication.features.di

import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.features.main.MainActivity
import com.example.myapplication.features.main.MainActivityViewModel
import com.example.myapplication.features.repository.FortressRepository
import com.example.myapplication.features.utils.EncryptionUtils
import com.example.myapplication.features.utils.FingerprintUtils
import com.example.myapplication.features.utils.ActivityViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule {


    @Provides
    fun bindMainActivityViewModel(@ActivityContext activity: MainActivity,
                                  repository: FortressRepository): MainActivityViewModel{
        return ViewModelProvider(activity, ActivityViewModelFactory(repository = repository))
            .get(MainActivityViewModel::class.java)
    }

//    @Provides
//    fun provideFingerprintUtils(encryptionUtils: EncryptionUtils, activity: MainActivity)
//    = FingerprintUtils(encryptionUtils, activity)
}