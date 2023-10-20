package com.elitecodecamp.mausam.presentation.sign_in

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.elitecodecamp.mausam.R
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import java.util.concurrent.CancellationException

class GoogleAuthUiClient (
    val context: Context,
    val oneTapClient : SignInClient
        ) {
    val auth = Firebase.auth

    suspend fun signIn():IntentSender?{
        val result = try {
            oneTapClient.beginSignIn(
                buildSignInRequest()
            ).await()
        }
        catch(e:Exception) {
            e.printStackTrace()
            if(e is CancellationException) throw e
            null
        }

        return result?.pendingIntent?.intentSender
    }

    suspend fun signInWithIntent(intent: Intent) : SignInResult{
        val credentials = oneTapClient.getSignInCredentialFromIntent(intent)

        val googleIdToken = credentials.googleIdToken

        val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken,null)

        return try {
              val user =  auth.signInWithCredential(googleCredentials).await().user
            SignInResult(
                user = user?.run {
                    UserData(
                        userId = user.uid,
                        userName = user.displayName,
                        profilePictureUrl = user.photoUrl?.toString()
                    )
                },
                errorMessage = null
            )
        }
        catch(e:Exception) {
            e.printStackTrace()
            if(e is CancellationException) throw e
            SignInResult(
                null,
                e.message
            )
        }


    }

    private fun buildSignInRequest() : BeginSignInRequest{
        return BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(context.getString(R.string.web_client_id))
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()
    }

    suspend fun signOut(){
        try {
            oneTapClient.signOut().await()
            auth.signOut()
        } catch(e:Exception) {
            e.printStackTrace()
            if(e is CancellationException) throw e

        }
    }

    fun signedInUser(): UserData? = auth.currentUser?.run {
        UserData(
            uid,
            displayName,
            photoUrl?.toString()
        )
    }
}

