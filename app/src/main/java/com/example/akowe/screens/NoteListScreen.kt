package com.example.akowe.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.akowe.AppNavigation
import com.example.akowe.components.NoteItem
import com.example.akowe.models.NoteModel
import com.example.akowe.view_model.NoteViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(navController: NavController){
    val noteViewModel: NoteViewModel = viewModel()
    val notesFromDb by noteViewModel.getAllNotes().observeAsState(listOf())
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Akowe") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.Yellow,
                    actionIconContentColor = Color.Yellow
                ),
                actions = {
//                         IconButton(onClick = { /*TODO*/ }) {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")

                    }
                    IconButton(onClick = { /*TODO*/ }) {

                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More Icon")
                    }


                }

            )

        },
        content = {paddingValues ->
            LazyColumn(
                modifier = Modifier.padding(paddingValues)
            ){
                items(notesFromDb){note ->
                key(note){
                    NoteItem(note = note, navController = navController)
                }
            }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add-note") }) {
               Row {

                   Icon(
                       imageVector = Icons.Default.Add,
                       contentDescription = "Add New Note"
                   ) 
                   Text(text = "Add-Note")
               }
                
            }
        }
    )

}
@Preview
@Composable
fun NoteListPreview(){
    Surface (
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ){
//        NoteListScreen()
        AppNavigation()
    }
}