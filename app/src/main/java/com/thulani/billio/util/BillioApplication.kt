package com.thulani.billio.util

import android.app.Application
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.repository.UserRepository
import com.thulani.billio.fragments.auth.UserViewModel
import com.thulani.billio.fragments.auth.UserViewModelFactory
import org.kodein.di.*
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class BillioApplication: Application(),KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@BillioApplication))
        bind() from singleton { BillioDB(instance())}
        bind() from singleton { UserRepository(instance())}
        bind() from singleton { UserViewModel(instance())}
        bind() from provider{UserViewModelFactory(instance())}
    }
}