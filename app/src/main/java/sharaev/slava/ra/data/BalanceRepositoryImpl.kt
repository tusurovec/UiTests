package sharaev.slava.ra.data

import kotlinx.coroutines.flow.Flow
import sharaev.slava.ra.domain.repository.BalanceRepository
import sharaev.slava.ra.domain.entity.Balance
import javax.inject.Inject

class BalanceRepositoryImpl @Inject constructor(private val balanceDataSource: BalanceDataSource) :
    BalanceRepository {

    override fun get(): Flow<Balance> =
       balanceDataSource.get()

}