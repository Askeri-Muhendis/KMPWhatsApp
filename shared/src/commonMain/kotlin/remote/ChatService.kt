package remote

import kotlinx.coroutines.flow.Flow
import model.ChatEvent

interface ChatService {
    suspend fun openSession(username: String)

    fun observeEvents(): Flow<ChatEvent>

    suspend fun sendEvent(event: ChatEvent)

    suspend fun closeSession()

    companion object {
        const val CHAT_PORT = 8080
        const val CHAT_WS_PATH = "/chat"
    }
}

expect val CHAT_HOST: String