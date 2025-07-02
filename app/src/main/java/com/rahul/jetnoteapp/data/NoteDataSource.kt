package com.rahul.jetnoteapp.data

import com.rahul.jetnoteapp.model.Notes

object NoteDataSource {

    fun loadNotes(): List<Notes> {
        return listOf(
            Notes(title = "Grocery List", description = "Buy milk, eggs, bread, and vegetables."),
            Notes(title = "Workout Plan", description = "Leg day exercises: squats, lunges, and leg press."),
            Notes(title = "Meeting Notes", description = "Discussed Q3 roadmap, feature backlog, and team OKRs."),
            Notes(title = "Book Ideas", description = "Sci-fi story about AI taking over a space colony."),
            Notes(title = "App Features", description = "Add dark mode, offline support, and push notifications."),
            Notes(title = "Holiday Planning", description = "Trip to Manali, book hotel and local sightseeing."),
            Notes(title = "Study Goals", description = "Complete chapters 4 to 6 in Kotlin by next week."),
            Notes(title = "Budget Tracker", description = "Track monthly expenses and set savings target."),
            Notes(title = "Favorite Quotes", description = "“Stay hungry, stay foolish.” – Steve Jobs"),
            Notes(title = "Birthday Reminders", description = "Mom - July 3, Rahul - August 21, Hiral - September 12")
        )
    }


}