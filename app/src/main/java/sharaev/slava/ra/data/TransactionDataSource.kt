package sharaev.slava.ra.espresso.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import sharaev.slava.ra.domain.entity.Currency
import sharaev.slava.ra.domain.entity.Transaction
import java.math.BigDecimal
import javax.inject.Inject

interface TransactionDataSource {

    fun getTransactions(): Flow<List<Transaction>>
}

class TransactionDataSourceImpl @Inject constructor() : TransactionDataSource {
    private companion object {
        const val NETWORK_DELAY_MILLIS = 2000L
    }

    override fun getTransactions(): Flow<List<Transaction>> =
        flow {
            delay(NETWORK_DELAY_MILLIS)
            emit(getLocalTransactions())
        }.flowOn(Dispatchers.IO)

    private fun getLocalTransactions(): List<Transaction> =
        listOf(
            Transaction(BigDecimal(-431), Currency("RUB"), "Mc Donalds"),
            Transaction(BigDecimal(-800), Currency("USD"), "Yandex Go"),
            Transaction(BigDecimal(1200), Currency("RUB"), "Salary"),
        )
}