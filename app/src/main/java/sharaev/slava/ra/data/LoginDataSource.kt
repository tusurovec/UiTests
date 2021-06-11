package sharaev.slava.ra.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LoginDataSource {
    fun login(): Flow<String>
}

class LoginDataSourceImpl @Inject constructor() : LoginDataSource {

    override fun login(): Flow<String> {
        TODO("Not yet implemented")
    }
}