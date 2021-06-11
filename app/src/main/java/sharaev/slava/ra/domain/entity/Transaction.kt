package sharaev.slava.ra.domain.entity

import sharaev.slava.ra.domain.entity.Currency
import java.math.BigDecimal

data class Transaction(
    val amount: BigDecimal,
    val currency: Currency,
    val description: String
)