package es.usj.mastertsa.onunez.visitrd

import java.io.Serializable

class Place (val name: String, val location: String, val description: String, val images: List<Int>, val comments: List<Comment>,
            val latitude: String, val longitude: String) : Serializable