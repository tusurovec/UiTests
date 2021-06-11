package sharaev.slava.ra.data

import kotlinx.coroutines.flow.Flow
import sharaev.slava.ra.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor():
    LoginRepository {
    override fun login(): Flow<String> {
        TODO("Not yet implemented")
    }
}