package com.example.akowe.models.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.akowe.models.NoteModel

object DBconfig {
    fun getInstance(context: Context): AppDatabase{

        var db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "note_db"
        ).build()
        return  db
    }

}
@Database(entities = [NoteModel::class], version = 1)
abstract class  AppDatabase: RoomDatabase(){
    abstract  fun noteDao(): NoteDao

}