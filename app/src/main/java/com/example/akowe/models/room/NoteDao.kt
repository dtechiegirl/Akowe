package com.example.akowe.models.room

import android.adservices.adid.AdId
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.akowe.models.NoteModel

@Dao
interface NoteDao {
    @Insert
     suspend fun saveNote(note: NoteModel)

     @Query("select * from notes ")
     fun fetchNote():LiveData<List<NoteModel>>

     @Query("SELECT * FROM notes WHERE id = :noteId")
     fun fetchNote(noteId: String): LiveData<NoteModel>
     @Delete
     suspend fun deleteNote(note: NoteModel)
     @Update
     suspend fun updateNote(note: NoteModel)

}