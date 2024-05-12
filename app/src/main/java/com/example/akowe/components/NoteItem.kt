package com.example.akowe.components

//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.akowe.Routes
import com.example.akowe.models.NoteModel
import com.example.akowe.view_model.NoteViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteItem(note: NoteModel, navController: NavController){
    val noteViewModel: NoteViewModel = viewModel()
    val dismissState = rememberSwipeToDismissBoxState()
    val colorToBeShown by animateColorAsState(
        targetValue =
        if (dismissState.targetValue ==
            SwipeToDismissBoxValue.EndToStart){
            Color.Yellow
        }else{
            Color.White
        }

    )
    var undobtn by remember {
        mutableStateOf(false)
    }
    if (dismissState.targetValue ==
        SwipeToDismissBoxValue.EndToStart){
//        Color.Yellow
        LaunchedEffect(key1 = "delete"){
            delay(5000)
            if(!undobtn ){
                noteViewModel.deleteNote(note)
            }
            noteViewModel.deleteNote((note))
        }

    }



    if (undobtn){
        LaunchedEffect(key1 = "undo"){
            dismissState.reset()
            undobtn = false
        }
    }
//    var isDismisssed by remember{ mutableStateOf(false) }
//    if (isDismisssed) {
//        LaunchedEffect(key1 = "deleteItem") {
//        dismissState.reset()
//        }
//    }
//        else{
//            LaunchedEffect(key1 = "resetItem", ){
//                dismissState.reset()
//            }
//        }

    SwipeToDismissBox(state = dismissState, backgroundContent = {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(colorToBeShown)
            .padding(horizontal = 8.dp) ){
            Button(onClick = {undobtn = true},
                modifier = Modifier.align(Alignment.CenterEnd)) {
                Text(text = "undo")
                
            }
        }
    }) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate(Routes.NoteDetails(note.id.toString())) }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Text(
                    text = note.title,
                    fontWeight = FontWeight.Black,
                    maxLines = 2
                )

                Text(text = note.noteContent, maxLines = 5)
                Text(text = "9:15 Am", modifier = Modifier.align(alignment = Alignment.End))
            }

        }
    }
}