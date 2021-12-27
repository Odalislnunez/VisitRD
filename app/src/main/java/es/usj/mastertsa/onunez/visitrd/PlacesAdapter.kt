package es.usj.mastertsa.onunez.visitrd

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_place.view.*

class PlacesAdapter(private val mContext: Context, private val placeList: List<Place>) : ArrayAdapter<Place>(mContext, 0, placeList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_place, parent, false)

        val place = placeList[position]

        layout.tvNamePlace.text = place.name
        layout.tvLocationPlace.text = place.location
        layout.ivPlace.setImageResource(place.images[0])

        return layout
    }
}