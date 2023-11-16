package com.example.mydiscountapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.mydiscountapp.ui.theme.NeutralWhite

@Composable
fun SpaceHeight(size: Dp = 10.dp){
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun SpaceWidth(size: Dp = 10.dp){
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun MainTextField(value: String, onChangeValue: (String)-> Unit, label: String){
    OutlinedTextField(
        value = value,
        onValueChange = onChangeValue,
        label={Text(text= label)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.testTag(label)
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
        )
}
@Composable
fun MainButton(text: String, color: Color = MaterialTheme.colorScheme.primary, onClick: () -> Unit){
    OutlinedButton(onClick = onClick, colors = ButtonDefaults.outlinedButtonColors(
        contentColor = Color.Transparent,
        containerColor =color ,

    ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp,)
        ) {
        Text(text = text, color = NeutralWhite)
    }
}
@Composable
fun HeaderTitle(text: String, color: Color = MaterialTheme.colorScheme.primary, size: TextUnit = 23.sp){
  Text(text = text, color= color, fontSize = size, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp))
}


@Composable
fun CenteredAlertDialog(
    title: String,
    content: String,
    buttonText: String,
    onButtonClicked: () -> Unit
) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        val onDismiss: () -> Unit = {
            openDialog.value = false
        }

        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(dismissOnClickOutside = false),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = title, style = MaterialTheme.typography.headlineLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = content, style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { onButtonClicked() },
                            modifier = Modifier
                                .weight(0.9f) // El botón ocupa el 90% del ancho disponible en la fila
                                .fillMaxWidth(), // Llena el espacio asignado por el weight
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                        ) {
                            Text(text = buttonText, color = MaterialTheme.colorScheme.onSecondary)
                        }
                    }
                }
            }
        }
    }
}