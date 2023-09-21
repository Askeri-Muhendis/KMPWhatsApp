package ui.model

import androidx.compose.runtime.Immutable
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlinx.serialization.Serializable
import model.MessageEvent

@Immutable
@Serializable
data class Message(
    val username: String,
    val text: String,
    val timestamp: Instant,
)

val MessageEvent.message
    get() = Message(
        username = username,
        text = messageText,
        timestamp = timestamp,
    )

fun Message.timeText(): String {
    val localDateTime = timestamp.toLocalDateTime(TimeZone.currentSystemDefault())
    val time = localDateTime.run { LocalTime(hour, minute) }

    val date = localDateTime.date
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    if (date == today) return "$time"

    val month = localDateTime.month.name.lowercase()
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
        .substring(0..2)
    return "$month ${localDateTime.dayOfMonth}, $time"

}