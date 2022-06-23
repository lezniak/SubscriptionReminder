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

    fun arePasswordsEqual(pass1: String,pass2: String) : ReturnInfo<String> {
        val returnInfo = ReturnInfo<String>(pass1)

        if(pass1.equals(pass2)){
            returnInfo.setStatus(1)
        }else{
            returnInfo.setStatus(0)
            returnInfo.setMessage("Hasła nie są identyczne!")
        }

        return returnInfo
    }
}