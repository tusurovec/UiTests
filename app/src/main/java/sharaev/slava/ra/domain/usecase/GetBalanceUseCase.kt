package sharaev.slava.ra.domain.usecase

import kotlinx.coroutines.flow.Flow
import sharaev.slava.ra.domain.entity.Balance
import sharaev.slava.ra.domain.repository.BalanceRepository
import javax.inject.Inject

class GetBalanceUseCase @Inject constructor(private val balanceRepository: BalanceRepository) {

    operator fun invoke(): Flow<Balance> =
        balanceRepository.get()
}