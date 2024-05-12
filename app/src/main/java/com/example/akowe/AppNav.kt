package com.example.akowe

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.akowe.screens.AddNoteScreen
import com.example.akowe.screens.EditNoteScreen
import com.example.akowe.screens.NoteDetailsScreen
import com.example.akowe.screens.NoteListScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController =navController, startDestination = Routes.NoteListRoute ){
        composable(Routes.NoteListRoute){
            NoteListScreen(navController)
        }
        composable( Routes.AddNoteRoute){
            AddNoteScreen(navController)
        }

        composable("note-details/{noteId}"){
//            Log.d("this is noteid", it.arguments!!.getInt("noteId").toString()  )
            NoteDetailsScreen(navController = navController,
                noteId = it.arguments!!.getString("noteId")!!)
        }
        composable("edit-note/{noteId}"){
            EditNoteScreen(navController = navController, id = it.arguments!!.getString("noteId")!!)
        }
    }
}
object  Routes{
    val NoteListRoute = "note-list"
    val AddNoteRoute = "add-note"
//    val NoteDetails = "note-details"
    fun NoteDetails(noteId: String): String{
        return "note-details/$noteId"
    }
    fun EditNoteRoute(noteId: String): String{
        return "edit-note/$noteId"
    }
}