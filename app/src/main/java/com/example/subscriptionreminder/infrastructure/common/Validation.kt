package com.example.subscriptionreminder.infrastructure.common

import android.util.Patterns
import androidx.core.util.PatternsCompat
import com.example.subscriptionreminder.infrastructure.model.ReturnInfo

class Validation {
    fun validateEmail(email : String) : ReturnInfo<String> {
        val returnInfo = ReturnInfo<String>(email)

        if(PatternsCompat.EMAIL_ADDRESS.matcher(email).matches() && email.length > 6 && email.length <60){
            returnInfo.setStatus(1)
        }else{
            returnInfo.setStatus(0)
            returnInfo.setMessage("Nie poprawny adres email!")
        }
        return returnInfo
    }

    fun registerValid(email: String,pass1: String,pass2: String) : ReturnInfo<String> {
        val returnInfo = ReturnInfo<String>(pass1)
        returnInfo.setStatus(0)

        if(email.isNullOrEmpty()){
            returnInfo.setMessage("Email jest pusty!")
            return returnInfo
        }

        if(pass1.equals(pass2) && pass1.isNotEmpty()){
            returnInfo.setStatus(1)
        }else if(pass1.isEmpty()){
            returnInfo.setMessage("Hasło jest puste!")
        }else{
            returnInfo.setMessage("Hasła nie są identyczne!")
        }
        return returnInfo
    }
}