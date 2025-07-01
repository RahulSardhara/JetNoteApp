package com.rahul.jetnoteapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahul.jetnoteapp.R
import com.rahul.jetnoteapp.components.NoteButton
import com.rahul.jetnoteapp.components.NoteInputText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {
    var titleState by remember { mutableStateOf("") }

    var descriptionState by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                actions = {
                    Icon(
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "Notifications"
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFDADFE3)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(8.dp))
            NoteInputText(
                text = titleState,
                label = "Title",
                onTextChange = {
                    if(it.all { char -> char.isLetterOrDigit() || char.isWhitespace() }) {
                        titleState = it
                    }
                },
                onImeAction = {}
            )
            Spacer(modifier = Modifier.padding(8.dp))
            NoteInputText(
                text = descriptionState,
                label = "Description",
                onTextChange = {
                    if(it.all { char -> char.isLetterOrDigit() || char.isWhitespace() }) {
                        descriptionState = it
                    }
                },
                onImeAction = {}
            )
            Spacer(modifier = Modifier.padding(8.dp))
            NoteButton(text = "Save", onClicked = {

            })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}