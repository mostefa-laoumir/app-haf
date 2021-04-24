package com.mostefalmr.hafezni

class Message {
    var owner:String?= null
    var time:String? = null
    var message:String? = null

    constructor(owner:String, time:String, message:String){
        this.owner  = owner
        this.time=time
        this.message= message

    }
}