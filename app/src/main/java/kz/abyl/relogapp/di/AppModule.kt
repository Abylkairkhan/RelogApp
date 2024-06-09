package kz.abyl.relogapp.di

import kz.abyl.relogapp.data.repository.AuthRepositoryImpl
import kz.abyl.relogapp.domain.repository.AuthRepository
import kz.abyl.relogapp.presentation.sign_in.SignInViewModel
import kz.abyl.relogapp.presentation.sign_up.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<AuthRepository> { AuthRepositoryImpl() }
    viewModel {
        SignInViewModel(get())
    }
    viewModel {
        SignUpViewModel(get())
    }
}