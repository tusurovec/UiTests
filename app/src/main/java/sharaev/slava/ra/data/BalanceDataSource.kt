package sharaev.slava.ra.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import sharaev.slava.ra.domain.entity.Balance
import sharaev.slava.ra.domain.entity.Currency
import java.math.BigDecimal
import javax.inject.Inject

interface BalanceDataSource {

    fun get(): Flow<Balance>
}

class BalanceDataSourceImpl @Inject constructor() : BalanceDataSource {
    private companion object {
        const val NETWORK_DELAY_MILLIS = 2000L
    }

    override fun get(): Flow<Balance> =
        flow {
            delay(NETWORK_DELAY_MILLIS)
            emit(Balance(BigDecimal(100L), Currency("USD")))
        }.flowOn(Dispatchers.IO)
}