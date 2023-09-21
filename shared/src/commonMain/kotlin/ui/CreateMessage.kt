package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun CreateMessage(
    onMessageSent: (String) -> Unit,
    onTyping: () -> Unit
) {
    var message by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.padding(end = 8.dp).weight(14f),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        modifier = Modifier.size(28.dp),
                        painter = painterResource("smile.png"),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
                BasicTextField(
                    value = message,
                    onValueChange = {
                        message = it
                        onTyping()
                    },
                ){innerTextField ->
                    if (message.isBlank()){
                        Text("Mesaj")
                    }
                    innerTextField()
                }
                Spacer(Modifier.weight(1f))
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        modifier = Modifier.size(28.dp),
                        painter = painterResource("attach.png"),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
                if (message.isBlank()){
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource("camera.png"),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            }
        }
        IconButton(
            onClick = {
                if (message.isNotBlank()){
                    onMessageSent(message)
                    message = ""
                }
            },
            modifier = Modifier.clip(RoundedCornerShape(24.dp)).background(Color(0xFF0BD97F)).weight(2f),
        ){
            if (message.isBlank()){
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource("microphone.png"),
                    contentDescription = "",
                    tint = Color.White
                )
            }else{
                Icon(
                    modifier = Modifier.padding(8.dp),
                    imageVector = Icons.Filled.Send,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    }
}

/**
OutlinedTextField(
modifier = Modifier.fillMaxWidth()
.padding(horizontal = 12.dp)
.padding(bottom = 16.dp),
value = message,
onValueChange = {
message = it
onTyping()
},
label = { Text("Message") },
trailingIcon = {
if (message.isNotBlank()) {
IconButton(
onClick = {
onMessageSent(message)
message = ""
},
) {
Icon(
imageVector = Icons.Filled.Send,
contentDescription = "Send",
tint = MaterialTheme.colors.primary,
)
}
}
}
)
 */
