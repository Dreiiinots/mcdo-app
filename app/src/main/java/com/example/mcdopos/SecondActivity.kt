
package com.example.mcdopos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Retrieve the data from the Intent
        val quantity1 = intent.getIntExtra("MCDO FRIES", 0)
        val subtotal1 = intent.getIntExtra("SUBTOTAL1", 0)
        val quantity2 = intent.getIntExtra("MCDO BIGMACK", 0)
        val subtotal2 = intent.getIntExtra("SUBTOTAL2", 0)
        val quantity3 = intent.getIntExtra("MCDO CHICKEN", 0)
        val subtotal3 = intent.getIntExtra("SUBTOTAL3", 0)

        // Calculate the total
        val total = subtotal1 + subtotal2 + subtotal3

        // Find the TextViews
        val item1View = findViewById<TextView>(R.id.item1)
        val item2View = findViewById<TextView>(R.id.item2)
        val item3View = findViewById<TextView>(R.id.item3)
        val totalView = findViewById<TextView>(R.id.total)

        // Set visibility based on quantity
        if (quantity1 >= 0) {
            item1View.visibility = View.VISIBLE
            item1View.text = "Item 1: Quantity $quantity1, Subtotal $subtotal1"
        } else {
            item1View.visibility = View.GONE
        }

        if (quantity2 >= 0) {
            item2View.visibility = View.VISIBLE
            item2View.text = "Item 2: Quantity $quantity2, Subtotal $subtotal2"
        } else {
            item2View.visibility = View.GONE
        }

        if (quantity3 >= 0) {
            item3View.visibility = View.VISIBLE
            item3View.text = "Item 3: Quantity $quantity3, Subtotal $subtotal3"
        } else {
            item3View.visibility = View.GONE
        }

        // Set the total text
        totalView.text = "Total: $total"
    }
}