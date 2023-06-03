package com.example.exlistview

import android.content.Context
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class Recipe(
    val title: String,
    val description: String,
    val imageUrl: String,
    val instructionUrl: String,
    val label: String
) {

    companion object {
        fun getRecipesFromFile(filename: String, context: Context): ArrayList<Recipe> {
            val recipeList = ArrayList<Recipe>()

            try {
                val jsonString = loadJSONFromAsset(context, filename)
                val json = JSONObject(jsonString)
                val recipes = json.getJSONArray("recipes")

                (0 until recipes.length()).mapTo(recipeList) {
                    Recipe(
                        recipes.getJSONObject(it).getString("title"),
                        recipes.getJSONObject(it).getString("description"),
                        recipes.getJSONObject(it).getString("image"),
                        recipes.getJSONObject(it).getString("url"),
                        recipes.getJSONObject(it).getString("dietLabel"),

                        )
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return recipeList
        }
        fun loadJSONFromAsset(context: Context, fileName: String): String? {
            var json: String? = null
            try {
                val inputStream = context.assets.open(fileName)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = buffer.toString(Charsets.UTF_8)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return json
        }
    }
}