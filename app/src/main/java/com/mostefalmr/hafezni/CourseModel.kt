package com.mostefalmr.hafezni

class CourseModel {
    var name:String? = null
    var startingHour:String? = null
    var endingHour:String? = null
    var room:String? = null
    constructor(name:String, startingHour:String, endingHour:String, room:String){
        this.name = name
        this.endingHour = endingHour
        this.startingHour = startingHour
        this.room = room
    }
}