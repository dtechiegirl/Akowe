package com.example.akowe.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.akowe.view_model.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(navController: NavHostController) {
    val noteViewModel: NoteViewModel = viewModel()
    var title by rememberSaveable{ mutableStateOf("") }
    var noteContent by rememberSaveable {
        mutableStateOf("")

    }

    Scaffold(
        topBar = {
                 TopAppBar(title = { Text(text = "Add Your Notes") },
                     colors = TopAppBarDefaults.smallTopAppBarColors(
                         containerColor = MaterialTheme.colorScheme.secondary,
                         titleContentColor = Color.Yellow,
                         actionIconContentColor = Color.Yellow,
                         navigationIconContentColor = Color.White,
                     ),
                     navigationIcon = {

                         IconButton(onClick = {

                             navController.popBackStack()
                             noteViewModel.saveNote(title, noteContent)

                         }) {
                             Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Button" )

                         }
                     }
                     )

        },
        content = {paddingValues -> Column(modifier = Modifier
            .padding(paddingValues)
            .padding(8.dp)
            .fillMaxSize()
        ) {
            OutlinedTextField (modifier = Modifier.fillMaxWidth(),
                value =title , onValueChange = {value ->title = value},
                label = {Text("Title")})
            TextField(value =noteContent, onValueChange = {value ->noteContent = value}, label =
            {Text("Note Content")},
                modifier = Modifier.fillMaxWidth()

                )

        }
        },
    )
}