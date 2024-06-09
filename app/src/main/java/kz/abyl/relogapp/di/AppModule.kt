package kz.abyl.relogapp.di

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kz.abyl.relogapp.data.repository.AuthRepositoryImpl
import kz.abyl.relogapp.domain.repository.AuthRepository
import kz.abyl.relogapp.presentation.sign_in.SignInViewModel
import kz.abyl.relogapp.presentation.sign_up.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<FirebaseAuth> { Firebase.auth }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    viewModel {
        SignInViewModel(get())
    }
    viewModel {
        SignUpViewModel(get())
    }
}