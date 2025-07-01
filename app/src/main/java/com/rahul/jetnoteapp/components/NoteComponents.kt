package com.rahul.jetnoteapp.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun NoteInputText(modifier: Modifier = Modifier, text: String = "Sample Note", label: String = "Enter note", maxLine: Int = 1, onTextChange: (String) -> Unit = {}, onImeAction: () -> Unit = {}) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text, onValueChange = onTextChange,
        label = { Text(text = label) },
        maxLines = maxLine,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions {
            onImeAction()
            keyboardController?.hide()
        },
        singleLine = maxLine == 1,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun NoteButton(modifier: Modifier = Modifier, text: String = "Save", onClicked: () -> Unit = {}, enabled: Boolean = true) {

    Button(onClick = onClicked, shape = CircleShape, enabled = enabled, modifier = modifier) {
        Text(text = text)
    }

}