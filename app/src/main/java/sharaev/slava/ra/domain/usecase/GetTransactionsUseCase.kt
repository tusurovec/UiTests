package sharaev.slava.ra.domain.usecase

import kotlinx.coroutines.flow.Flow
import sharaev.slava.ra.domain.entity.Transaction
import sharaev.slava.ra.domain.repository.TransactionRepository
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    operator fun invoke(): Flow<List<Transaction>> =
        transactionRepository.getTransactions()
}