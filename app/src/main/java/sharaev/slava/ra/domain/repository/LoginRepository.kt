package sharaev.slava.ra.domain.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {

	fun login(): Flow<String>
}