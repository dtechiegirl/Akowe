package com.example.akowe.view_model

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.akowe.models.NoteModel
import com.example.akowe.models.room.AppDatabase
import com.example.akowe.models.room.DBconfig
import kotlinx.coroutines.launch

class NoteViewModel(val appss: Application) : AndroidViewModel(appss) {
   private var db = DBconfig.getInstance(appss)


    fun saveNote(title: String, noteContent: String){
        if(title.isNullOrEmpty() && noteContent.isNullOrEmpty())
            return
     val note = NoteModel(title = title, noteContent = noteContent
     )

        viewModelScope.launch {
            db.noteDao().saveNote(note)
        }


    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return  db.noteDao().fetchNote()
    }

    fun getNote(noteId: String): LiveData<NoteModel>{
        return db.noteDao().fetchNote(noteId)
    }
     fun deleteNote(note: NoteModel){
         viewModelScope.launch {
             db.noteDao().deleteNote(note = note)
         }
     }
    fun updateNote(note:NoteModel){
        viewModelScope.launch {
            db.noteDao().updateNote(note)
        }
    }

}