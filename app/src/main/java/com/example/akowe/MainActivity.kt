package com.example.akowe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.akowe.screens.AddNoteScreen
import com.example.akowe.screens.NoteListScreen
import com.example.akowe.ui.theme.AkoweTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AkoweTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    loginScreen()
//                    NoteListScreen()
                    AppNavigation()

                }
            }
        }
    }
}

//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//
//fun loginScreen(){
//    var username by remember {mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    Column (horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.padding(all = 8.dp)){
//
//        Text(
//            text = "Simple Login Page",
//            fontSize = 20.sp,
//            textAlign = TextAlign.Center,
////                       modifier = Modifier.align()
//        )
//        TextField(value = username, onValueChange ={usernameInput -> username = usernameInput},
//            label = {Text("Username")},
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp)
//        )
//
//        TextField(value = password, onValueChange ={userPassword -> password = userPassword},
//            label = {
//                Text("Password")},
//            visualTransformation = PasswordVisualTransformation(),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 10.dp)
//        )
//        rememeberMe()
//        Button(onClick = { /*TODO*/ }) {
//            Text(text= "login")
//        }
//        Row {
//            Image(painter = painterResource(id = R.drawable.google__1_ ), contentDescription = "google-icon",
//                modifier = Modifier.size(20.dp))
//            Image(painter = painterResource(id = R.drawable.google__2_ ), contentDescription = "google-icon",
//                modifier = Modifier.size(20.dp))
//        }
//
////
//    //                    TextField(value = "", onValueChange = {newText: String->Unit} )
//    }
//}
//
//@Composable
//fun rememeberMe(){
//    var isChecked by remember {
//        mutableStateOf(false)
//    }
//    Row(horizontalArrangement = Arrangement.SpaceAround,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.fillMaxWidth()
//    ){
//        Text(text = "Remember Me")
//        Switch(
//            checked = isChecked,
//            onCheckedChange = {isChecked= !isChecked}
//        )
//
//    }
//
//}


//@Preview
//@Composable
//fun loginScreenPreview(){
//    Surface(
//    modifier = Modifier.fillMaxWidth(),
//        color = MaterialTheme.colorScheme.background
//    ){
//        loginScreen()
//    }
//
//}