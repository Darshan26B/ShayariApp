package com.darshan.shayariapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.darshan.shayariapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var adapter: shayariAdapter
    lateinit var db: ExternalDB
    var shayariList = ArrayList<ShayariModel>()


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = shayariAdapter()

        db = ExternalDB(this)
        shayariList = db.shayari as ArrayList<ShayariModel>

        adapter.setShayari(shayariList)

        binding.rcvshayari.layoutManager= LinearLayoutManager(this)
        binding.rcvshayari.adapter=adapter

    }
}