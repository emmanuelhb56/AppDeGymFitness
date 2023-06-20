package com.mx.gymfitness.ui.screen.login

import android.util.Log
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

import com.mx.gymfitness.model.User
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun signInWithGoogleCredential(credential: AuthCredential, home:() -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithCredential(credential)
                    .addOnCompleteListener{ task->
                        if(task.isSuccessful){
                            Log.d("DeGymFitness","Logeado con Google Exitoso!")
                            home()
                        }
                    }
                    .addOnFailureListener{
                        Log.d("DeGymFitness","Fallo al loguear con Google!")
                    }
            }catch (ex:Exception){
                Log.d("DeGymFitness", "Exception al loguear" +
                        ex.localizedMessage
                )
            }
        }


    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener { authResult ->
                       Log.d("DeGymFitness","Logueado: ${authResult.toString()}")
                        home()
                    }
                    .addOnFailureListener{ ex->
                        Log.d("DeGymFitness", "Fallo al iniciar sesión: ${ex.localizedMessage}")
                    }
            } catch (ex: Exception) {
                Log.d("DeGymFitness", "signInWithEmailAndPassword: ${ex.message}")
            }
        }

    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        home: () -> Unit
    ){
        if(_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                   if(task.isSuccessful){
                       val displayName = task.result.user?.email?.split("@")?.get(0)
                       createUser(displayName)
                       home()
                   }
                   else{
                       Log.d("DeGymFitness", "createUserWithEmailAndPassword:${task.result.toString()}")
                   }
                    _loading.value = false
                }
        }
    }
    private fun createUser(displayName: String?){
        val userId = auth.currentUser?.uid
        //val user = mutableMapOf<String, Any>()

        //user["user_id"] = userId.toString()
        //user["display_name"] = displayName.toString()

        val user = User(
            userId = userId.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            size = "155cms",
            weight = "75kg",
            id = null
        ).toMap()

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener { Log.d("DeGymFitness", "Creado ${it.id}")}
            .addOnFailureListener{Log.d("DeGymFitness", "Ocurrio un error ${it}")}
    }
}


