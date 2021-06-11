package sharaev.slava.ra.domain.repository

import kotlinx.coroutines.flow.Flow
import sharaev.slava.ra.domain.entity.Transaction

interface TransactionRepository {

    fun getTransactions(): Flow<List<Transaction>>
}