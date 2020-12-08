package fr.armando.biereliste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.armando.biereliste.classes.Biere
import fr.armando.biereliste.classes.BiereAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var items = ArrayList<Biere>()
    var images = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seedImages()
        seedItems()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BiereAdapter(items)
    }

    private fun seedImages() {
        var nameArray = resources.getStringArray(R.array.bieres)
        for(name in nameArray) {
            images.add(resources.getIdentifier(name.toLowerCase(), "mipmap", packageName))
        }
    }

    private fun seedItems() {
        val nameArray = resources.getStringArray(R.array.bieres)
        for(k in nameArray.indices) {
            items.add(Biere(nameArray[k], images[k]))
        }
    }

}