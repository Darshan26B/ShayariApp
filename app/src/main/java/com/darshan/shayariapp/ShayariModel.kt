package com.darshan.shayariapp

class ShayariModel {

    var txt_id = 0
    lateinit var text:String
    lateinit var text_cate:String
    lateinit var text_lang:String


    constructor(txt_id: Int, text: String, text_cate: String) {
        this.txt_id = txt_id
        this.text = text
        this.text_cate = text_cate
        this.text_lang = text_lang
    }
}