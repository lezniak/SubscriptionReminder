package com.example.subscriptionreminder.infrastructure.common

import com.example.subscriptionreminder.infrastructure.model.ReturnInfo

class Validation {
    fun validateEmail(email : String) : ReturnInfo<String> {
        val returnInfo = ReturnInfo<String>(email)

        if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.length > 6){
            returnInfo.setStatus(1)
        }else{
            returnInfo.setStatus(0)
            returnInfo.setMessage("Nie poprawny adres email!")
        }
        return returnInfo
    }
}