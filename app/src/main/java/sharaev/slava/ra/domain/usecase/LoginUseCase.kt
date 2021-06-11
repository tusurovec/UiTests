package sharaev.slava.ra.domain.usecase

import sharaev.slava.ra.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
}