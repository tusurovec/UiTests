package sharaev.slava.ra.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sharaev.slava.ra.data.BalanceDataSource
import sharaev.slava.ra.data.BalanceDataSourceImpl
import sharaev.slava.ra.data.BalanceRepositoryImpl
import sharaev.slava.ra.data.TransactionRepositoryImpl
import sharaev.slava.ra.espresso.data.*
import sharaev.slava.ra.domain.repository.BalanceRepository
import sharaev.slava.ra.domain.repository.TransactionRepository
import sharaev.slava.ra.presentation.MainViewModel

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindLoginViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    fun bindBalanceDataSource(impl: BalanceDataSourceImpl): BalanceDataSource

    @Binds
    fun bindBalanceRepository(impl: BalanceRepositoryImpl): BalanceRepository

    @Binds
    fun bindTransactionDataSource(impl: TransactionDataSourceImpl): TransactionDataSource

    @Binds
    fun bindTransactionRepository(impl: TransactionRepositoryImpl): TransactionRepository
}