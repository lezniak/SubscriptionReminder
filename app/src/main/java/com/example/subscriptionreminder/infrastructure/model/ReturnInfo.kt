package com.example.subscriptionreminder.infrastructure.model

data class ReturnInfo<T: Any>(var objectPar : T) {
    private var _status : Int = 0
    private var _errorMessage = ""
    private var _obj : T = objectPar

    fun setStatus(status : Int){
        _status = status
    }

    fun setMessage(errorMessage : String){
        _errorMessage = errorMessage
    }

    fun setObj(obj : T){
        _obj = obj
    }

    fun getObj() : T = _obj
    fun getErrorMessage() : String = _errorMessage
    fun getStatus(): Int = _status

}
