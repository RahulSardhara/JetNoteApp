package com.rahul.jetnoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rahul.jetnoteapp.data.NoteDataSource
import com.rahul.jetnoteapp.model.Notes
import com.rahul.jetnoteapp.screen.NoteScreen
import com.rahul.jetnoteapp.screen.NoteViewModel
import com.rahul.jetnoteapp.ui.theme.JetNoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetNoteAppTheme {
                val viewModel: NoteViewModel by viewModels()

                Surface(modifier = Modifier.fillMaxSize()) {
                    NoteScreen(notesList =viewModel.getAllNotes(), onAddNote = {
                       viewModel.addNOte(it)
                    }, onRemoveNote = {
                        viewModel.removeNote(it)
                    })
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetNoteAppTheme {
        NoteScreen()
    }
}