package com.rahul.jetnoteapp.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahul.jetnoteapp.model.Notes
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Preview(showBackground = true)
@Composable
fun NoteRow(note: Notes = Notes(), onNoteClicked: (Notes) -> Unit = {}) {
    val date = Date(note.entryDate.time)
    val format = SimpleDateFormat("EEEE, d MMM hh:mm aaa, ", Locale.getDefault())
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        shape = RoundedCornerShape(topEnd = 20.dp),
        onClick = { onNoteClicked(note) }
    ) {
        Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {

            Text(text = note.title ?: "No Title", style = MaterialTheme.typography.titleLarge, color = Color.Black)
            Text(text = note.description ?: "No Description", style = MaterialTheme.typography.bodyMedium, color = Color.Black)
            Text(text = format.format(date), style = MaterialTheme.typography.bodySmall, color = Color.Black)
        }

    }
}