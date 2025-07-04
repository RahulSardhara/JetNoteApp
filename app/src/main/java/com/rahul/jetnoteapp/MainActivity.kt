package com.rahul.jetnoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.coroutineScope
import com.rahul.jetnoteapp.screen.NoteScreen
import com.rahul.jetnoteapp.screen.NoteViewModel
import com.rahul.jetnoteapp.ui.theme.JetNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetNoteAppTheme {
                val viewModel: NoteViewModel by viewModels()

                Surface(modifier = Modifier.fillMaxSize()) {
                    NoteScreen(notesList = viewModel.notList.collectAsState().value, onAddNote = {
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