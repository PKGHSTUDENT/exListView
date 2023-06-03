package com.example.exlistview

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.exlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var nameList = ArrayList<String>()
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")
//        nameList.add("name1")

//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)
//        binding.recipeListView.adapter = adapter
        val recipeList = Recipe.getRecipesFromFile("recipes.json", this)
        val adapter = RecipeAdapter(this, recipeList)
        binding.recipeListView.adapter = adapter
    }
}