package com.mostefalmr.hafezni

class AnnouncementModel {
    var name:String? = null
    var text:String? = null
    var link:String? = null
    var type: Int? = null
        constructor(name:String, text:String, link:String, type:Int){
            this.name = name
            this.text = text
            this.link = link
            this.type = type
        }



}