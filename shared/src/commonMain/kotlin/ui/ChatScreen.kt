package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentSetOf
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.model.Message
import viewmodel.ChatViewModel

@Composable
internal fun ChatScreen(chatViewModel: ChatViewModel) {
    ChatScreen(
        messages = chatViewModel.messagesFlow.collectAsState(persistentListOf()).value,
        username = chatViewModel.username.value,
        typingUsers = chatViewModel.typingUsers.collectAsState(persistentSetOf()).value,
        onMessageSent = chatViewModel::sendMessage,
        onUserIsTyping = chatViewModel::startTyping,
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun ChatScreen(
    messages: ImmutableList<Message>,
    username: String?,
    typingUsers: Set<String>,
    onMessageSent: (String) -> Unit,
    onUserIsTyping: () -> Unit,
) {
    ChatSurface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.background(color = Color.Gray).fillMaxWidth().height(60.dp).padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {

                    }
                ){
                    Icon(Icons.Filled.ArrowBack,contentDescription = null, tint = Color.White)
                }
                Image(
                    painter = painterResource("kotlin_logo.png"),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(40.dp)
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text("Best Of KMP", fontWeight = FontWeight.Bold, color = Color.White)
                    Text("IOS Tel,Android Tel,Siz", color = Color.White, fontSize = 12.sp)
                }
                IconButton(
                    onClick = {

                    }
                ){
                    Icon(painterResource("video_cam.png"),contentDescription = null, tint = Color.White, modifier = Modifier.size(32.dp))
                }
                IconButton(
                    onClick = {

                    }
                ){
                    Icon(Icons.Filled.Phone,contentDescription = null, tint = Color.White)
                }
                IconButton(
                    onClick = {

                    }
                ){
                    Icon(Icons.Filled.MoreVert,contentDescription = null, tint = Color.White)
                }
            }
            Box(Modifier.weight(1f)) {
                MessageList(
                    messages = messages,
                    username = username,
                )
            }
            Column{
                /*TypingUsers(
                    typingUsers = typingUsers,
                )*/
                CreateMessage(
                    onMessageSent = onMessageSent,
                    onTyping = onUserIsTyping,
                )
            }
        }
    }
}
