package es.usj.mastertsa.onunez.visitrd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_place.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.view.View
import androidx.cardview.widget.CardView

class PlaceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)

        val place = intent.getSerializableExtra("place") as Place
        val adapterComment = CommentsPlacesAdapter(this, place.comments)

        val ll = findViewById<View>(R.id.llImages) as LinearLayout

        for (i in place.images) {
            val containerIv = CardView(this)
            val iv = ImageView(this)
            iv.setImageResource(i)
            iv.layoutParams = LinearLayout.LayoutParams( LinearLayout.LayoutParams(550,550))
            containerIv.layoutParams = LinearLayout.LayoutParams( LinearLayout.LayoutParams(600,600))
            containerIv.addView(iv)
            ll.addView(containerIv)
        }

        tvNameP.text = place.name
        tvLocationP.text = place.location
        tvDescription.text = place.description
        lvComments.adapter = adapterComment
    }
}