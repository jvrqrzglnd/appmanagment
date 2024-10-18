package com.kripto.appmanager.di

import com.kripto.appmanager.respository.AppwareRepository
import com.kripto.appmanager.respository.AppwareTerminalRepository
import com.kripto.appmanager.respository.ClientRepository
import com.kripto.appmanager.respository.StoreRepository
import com.kripto.appmanager.respository.TerminalRepository
import com.kripto.appmanager.respository.TerminalStoreRepository
import com.kripto.appmanager.usecase.FlowAllClientListUseCase
import com.kripto.appmanager.usecase.GetAppwareListUseCase
import com.kripto.appmanager.usecase.GetAppwareTerminalListUseCase
import com.kripto.appmanager.usecase.GetClientListUseCase
import com.kripto.appmanager.usecase.GetStoreListUseCase
import com.kripto.appmanager.usecase.GetTerminalListUseCase
import com.kripto.appmanager.usecase.GetTerminalStoreListUseCase
import com.kripto.appmanager.usecase.RegisterClientUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideRegisterClientUseCase(repository: ClientRepository): RegisterClientUseCase {
        return RegisterClientUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetClientListUseCase(repository: ClientRepository): GetClientListUseCase {
        return GetClientListUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideFlowAllClientListUseCase(repository: ClientRepository): FlowAllClientListUseCase {
        return FlowAllClientListUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetStoreListUseCase(repository: StoreRepository): GetStoreListUseCase {
        return GetStoreListUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetTerminalListUseCase(repository: TerminalRepository): GetTerminalListUseCase {
        return GetTerminalListUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetAppwareListUseCase(repository: AppwareRepository): GetAppwareListUseCase {
        return GetAppwareListUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetAppwareTerminalListUseCase(
        repository: AppwareTerminalRepository
    ): GetAppwareTerminalListUseCase {
        return GetAppwareTerminalListUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetTerminalStoreListUseCase(
        repository: TerminalStoreRepository
    ): GetTerminalStoreListUseCase {
        return GetTerminalStoreListUseCase(repository)
    }


}