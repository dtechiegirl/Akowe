package com.example.akowe.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.akowe.models.NoteModel
import com.example.akowe.view_model.NoteViewModel

import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.akowe.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailsScreen(navController: NavController, noteId: String){
    val noteViewModel: NoteViewModel = viewModel()
    val note by noteViewModel.getNote(noteId).observeAsState()
    var title by rememberSaveable{ mutableStateOf("") }
    var noteContent by rememberSaveable {
        mutableStateOf("")

    }
    var isEditMode by rememberSaveable {
        mutableStateOf(false)
    }
    fun ActivateEditMode(){
        isEditMode = true
        title = note?.title ?: ""
        noteContent = note?.noteContent ?: ""
    }
    Scaffold (
        topBar = {
            TopAppBar(title = { Text("Akowe") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.Yellow,
                    actionIconContentColor = Color.Yellow
                ),
                actions = {
//
                    if(isEditMode){
                        IconButton(onClick = {
                            val updatedNote : NoteModel = note!!.copy(
                                title=title,
                                noteContent = noteContent)
                             noteViewModel.updateNote(updatedNote)
                            isEditMode = false

//                            ActivateEditMode()
                        }) {
                            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "Save Note")

                        }
                    }else{
                        IconButton(onClick = {ActivateEditMode() }) {
                            Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")

                        }
                    }
//
//                    IconButton(onClick = {
//
//                        navController.popBackStack()
//                        noteViewModel.saveNote(title, noteContent)
//
//                    }) {
//                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Button" )
//
//                    }
                    IconButton(onClick = {
                        noteViewModel.deleteNote(note!!)
                        navController.popBackStack()
                    }

                    ) {

                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                    }


                }

            )

        },
    ){paddingValues->
        Column(modifier = Modifier.padding(paddingValues)){
           if(isEditMode){
               TextField(
                   value = title ?: "",
                   onValueChange = {value->title=value},
                   modifier = Modifier.fillMaxWidth(),
                   label = { Text(text = "Title")})
               TextField(
                   value = noteContent ?: "",
                   onValueChange = {value->noteContent=value},
                   modifier = Modifier.fillMaxWidth(),
                   label = { Text(text = "Content")}
               )

           } else{
               Text(text = note?.title ?: "No title",
                   modifier = Modifier.fillMaxWidth().clickable {
                       ActivateEditMode()

                   })
               Text(text = note?.noteContent ?: "No Content",
                   modifier = Modifier.fillMaxWidth().clickable {
                       ActivateEditMode()


                   })
           }


    }

    }




}