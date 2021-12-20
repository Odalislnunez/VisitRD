package es.usj.mastertsa.onunez.visitrd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstPlace = Place("Bahía de las Aguilas", "Parque Nacional de Jaragua, Prov. Pedernales", R.drawable.bahia)
        val secondPlace = Place("Monumento a los Héroes de la Restauración", "Centro de la Ciudad, Prov. Santiago", R.drawable.monumento)

        val placeList = listOf<Place>(firstPlace, secondPlace)

        val adapter = PlacesAdapter(this, placeList)

        lvMain.adapter = adapter

        lvMain.setOnItemClickListener { parent, view, position, id ->

        }
    }
}