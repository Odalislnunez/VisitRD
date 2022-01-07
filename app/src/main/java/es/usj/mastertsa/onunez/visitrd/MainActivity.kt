package es.usj.mastertsa.onunez.visitrd

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_place.*
import java.io.IOException
import org.json.JSONArray
import java.io.InputStream
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val placeList = ArrayList<Place>()
    private var adapter: PlacesAdapter? = null

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val search = menu?.findItem(R.string.search)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = R.string.search.toString()

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter?.filter?.filter(newText)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val json: String?

        try {
            val inputStream: InputStream = assets.open("Places.json")
            inputStream.buffered(5)
            json = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                placeList.add(
                    Place(
                        jsonObject.optString("name") + "\n",
                        jsonObject.optString("location") + "\n",
                        jsonObject.optString("description") + "\n",
                        listOf<String>(jsonObject.optString("images")) + "\n",
                        jsonObject.optString("comments"),
                        jsonObject.optString("latitude") + "\n",
                        jsonObject.optString("longitude") + "\n",
                        jsonObject.optDouble("rating")
                    )
                )
            }
        }
        catch (e: IOException){
            e.printStackTrace()
        }

        adapter = PlacesAdapter(this, placeList)

        lvMain.adapter = adapter

        lvMain.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, PlaceActivity::class.java)
            intent.putExtra("place", placeList[position])
            startActivity(intent)
        }
    }
}