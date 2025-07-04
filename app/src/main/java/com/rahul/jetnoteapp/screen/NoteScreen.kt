package com.rahul.jetnoteapp.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahul.jetnoteapp.R
import com.rahul.jetnoteapp.components.NoteButton
import com.rahul.jetnoteapp.components.NoteInputText
import com.rahul.jetnoteapp.model.Notes
import com.rahul.jetnoteapp.widget.NoteRow
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notesList: List<Notes> = arrayListOf<Notes>(),
    onAddNote: (Notes) -> Unit = {},
    onRemoveNote: (Notes) -> Unit = {}
) {
    var titleState by remember { mutableStateOf("") }

    var descriptionState by remember { mutableStateOf("") }
    val context = LocalContext.current

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

                if (titleState.isNotEmpty() && descriptionState.isNotEmpty()) {
                    onAddNote.invoke(Notes(title = titleState, description = descriptionState, entryDate = Date.from(Instant.now())))
                    Toast.makeText(context, "Note Added $titleState", Toast.LENGTH_SHORT).show()
                    titleState = ""
                    descriptionState = ""
                }

            })
            HorizontalDivider(modifier = Modifier.padding(8.dp), thickness = DividerDefaults.Thickness, color = Color.Black)

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(notesList) { note ->
                    NoteRow(note) {
                        onRemoveNote.invoke(note)
                        Toast.makeText(context, "Note Deleted ${note.title}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}