package sharaev.slava.ra.domain.repository

import kotlinx.coroutines.flow.Flow
import sharaev.slava.ra.domain.entity.Balance

interface BalanceRepository {

    fun get(): Flow<Balance>
}