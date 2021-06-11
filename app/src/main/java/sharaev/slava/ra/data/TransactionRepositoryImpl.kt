package sharaev.slava.ra.data

import kotlinx.coroutines.flow.Flow
import sharaev.slava.ra.espresso.data.TransactionDataSource
import sharaev.slava.ra.domain.entity.Transaction
import sharaev.slava.ra.domain.repository.TransactionRepository
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionDataSource: TransactionDataSource
) : TransactionRepository {
    override fun getTransactions(): Flow<List<Transaction>> =
        transactionDataSource.getTransactions()
}