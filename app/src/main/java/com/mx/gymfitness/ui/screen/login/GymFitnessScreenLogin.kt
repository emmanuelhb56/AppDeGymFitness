package com.mx.gymfitness.ui.screen.login

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.mx.gymfitness.R
import com.mx.gymfitness.ui.screen.navigation.Screens

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(
    viewModel: LoginScreenViewModel,
    navHost: NavHostController
) {
    val showLoginForm = rememberSaveable{
        mutableStateOf(true)
    }

    val token = "1026395040678-clh9a01nkrp2mltui5h8dlidoevuid4e.apps.googleusercontent.com"
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts
            .StartActivityForResult()
    ){
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try{
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            viewModel.signInWithGoogleCredential(credential){
                navHost.navigate(Screens.HomeScreen.name)
            }
        }catch (ex: Exception){
            Log.d("DeGymFitness", "GoogleSignIn Falló")
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if(showLoginForm.value){
                Image(
                    modifier = Modifier.size(250.dp),painter = painterResource(id = R.drawable.icono_sinfondo) ,
                    contentDescription = "Icono")
                Text(text = "¡Bienvenido a DeGymFitness!",
                        textAlign = TextAlign.Center,fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(Modifier.size(10.dp))
                Text(text = "Ingrese sus datos para iniciar sesión",color = Color.White, fontSize = 18.sp)
                Spacer(Modifier.size(10.dp))
                UserForm(
                    isCreateAccount = false
                ){
                        email, password ->
                    Log.d("gymbro", "Logueando con $email y $password")
                    viewModel.signInWithEmailAndPassword(email,password){
                        navHost.navigate(Screens.HomeScreen.name)
                    }
                }
            }
            else{
                Image(
                    modifier = Modifier.size(250.dp),painter = painterResource(id = R.drawable.icono_sinfondo) ,
                    contentDescription = "Icono")
                Text(text = "¡Bienvenido a DeGymFitness!", fontSize = 25.sp,fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(Modifier.size(10.dp))
                Text(
                    text = "Registre sus datos para formar parte\n de la familia GymFitness",
                    textAlign = TextAlign.Center,color = Color.White, fontSize = 18.sp
                )
                Spacer(Modifier.size(10.dp))
                UserForm(
                    isCreateAccount = true
                ){
                        email,password ->
                    Log.d("gymbro", "Creando cuenta con $email y $password")
                    viewModel.createUserWithEmailAndPassword(email,password){
                        navHost.navigate(Screens.HomeScreen.name)
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                val text1 =
                    if(showLoginForm.value) "¿No tienes cuenta?"
                    else "¿Ya tienes cuenta?"

                val text2 =
                    if(showLoginForm.value) "Registrate"
                    else "Inicia sesión"

                Text(text = text1, color = Color.White)
                Spacer(Modifier.padding(10.dp))
                Text(text = text2 ,
                    modifier = Modifier
                        .clickable { showLoginForm.value = !showLoginForm.value }
                        .padding(start = 5.dp),
                    color = Color.Yellow
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                          val opciones = GoogleSignInOptions.Builder(
                              GoogleSignInOptions.DEFAULT_SIGN_IN
                          )
                              .requestIdToken(token)
                              .requestEmail()
                              .build()
                        val googleSignInClient = GoogleSignIn.getClient(context, opciones)
                        launcher.launch(googleSignInClient.signInIntent)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
                Image(
                    painter = painterResource(id = R.drawable.icono_google), 
                    contentDescription = "Login con Google",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(55.dp)
                )

                Text("Iniciar sesión con Google",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    isCreateAccount: Boolean = false,
    onDone: (String,String) -> Unit = {email,pwd->}
){
    val email = rememberSaveable{mutableStateOf("")}
    val password = rememberSaveable{mutableStateOf("")}
    val passwordVisible = rememberSaveable{mutableStateOf(false)}
    val valido = remember(email.value, password.value){
        email.value.trim().isNotEmpty() &&
                password.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EmailInput(
            emailState = email
        )
        PasswordInput(
            passwordState= password,
            labelId = "Contraseña",
            passwordVisible = passwordVisible
        )
        SubmitButton(
            textId = if (isCreateAccount) "Crear cuenta" else "Iniciar sesión",
            inputValido = valido
        ){
            onDone(email.value.trim(), password.value.trim())
            keyboardController?.hide()
        }
    }
}

@Composable
fun SubmitButton(
    textId: String,
    inputValido: Boolean,
    onClic: ()->Unit
) {
    Button(onClick = onClic ,
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape,
        enabled = inputValido,
    ){
        Text(text = textId ,
            modifier = Modifier
                .padding(5.dp),
            color = Color.White
        )
    }
}

@Composable
fun PasswordInput(
    passwordState: MutableState<String>,
    labelId: String,
    passwordVisible: MutableState<Boolean>
) {
    val visualTransformation = if(passwordVisible.value)
        VisualTransformation.None
    else PasswordVisualTransformation()

    TextField(
        value = passwordState.value,
        onValueChange = {passwordState.value = it},
        label = { Text(text = labelId)},
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
        ,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Black,
            focusedContainerColor = Color.Black,
        ),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if(passwordState.value.isNotBlank()){
                PasswordVisualIcon(passwordVisible)
            }
            else null
        }
    )
}

@Composable
fun PasswordVisualIcon(passwordVisible: MutableState<Boolean>) {
    val image =
        if(passwordVisible.value)
            Icons.Default.VisibilityOff
        else
            Icons.Default.Visibility

    IconButton(
        onClick = {
        passwordVisible.value = !passwordVisible.value
    }) {
        Icon(
            imageVector = image,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun EmailInput(
    emailState: MutableState<String>,
    labelId : String = "Correo Electrónico"
){
    InputField(
        valueState = emailState,
        labelId = labelId,
        keyboardType =  KeyboardType.Email
    )
}


@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType,
) {

    TextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Black,
            focusedContainerColor = Color.Black,
        )
    )

}



