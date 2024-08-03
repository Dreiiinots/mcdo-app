package com.example.mcdopos
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Retrieve the Bundle from the Intent
        val bundle = intent.getBundleExtra("ITEM_DETAILS") ?: Bundle()

        // Extract item details from the Bundle

        ////////////////
        val quantity1 = bundle.getInt("ITEM1_QUANTITY", 0)
        val subtotal1 = bundle.getInt("ITEM1_SUBTOTAL", 0)
        ////////////////
        val quantity2 = bundle.getInt("ITEM2_QUANTITY", 0)
        val subtotal2 = bundle.getInt("ITEM2_SUBTOTAL", 0)
        val quantity3 = bundle.getInt("ITEM3_QUANTITY", 0)
        val subtotal3 = bundle.getInt("ITEM3_SUBTOTAL", 0)
        val quantity4= bundle.getInt("ITEM4_QUANTITY", 0)
        val subtotal4 = bundle.getInt("ITEM4_SUBTOTAL", 0)


        //Append another subtotal here, for example
//      val total = subtotal1 + subtotal2 + subtotal3 + subtotal4
        val total = subtotal1 + subtotal2 + subtotal3 + subtotal4

        // Find the TextViews
        val item1View = findViewById<TextView>(R.id.item1)
        val item2View = findViewById<TextView>(R.id.item2)
        val item3View = findViewById<TextView>(R.id.item3)
        val item4View = findViewById<TextView>(R.id.item4)

        val totalView = findViewById<TextView>(R.id.total)

        val backbtn = findViewById<Button>(R.id.backbtn)

        // Set visibility based on quantity
        if (quantity1 > 0) {
            item1View.visibility = View.VISIBLE
            item1View.text = "MCDO REGULAR FRIES: $quantity1     P$subtotal1"
        } else {
            item1View.visibility = View.GONE
        }

        if (quantity2 > 0) {
            item2View.visibility = View.VISIBLE
            item2View.text = "MCDO BIGMACK: $quantity2       P$subtotal2"
        } else {
            item2View.visibility = View.GONE
        }

        if (quantity3 > 0) {
            item3View.visibility = View.VISIBLE
            item3View.text = "MCDO CHICKEN: $quantity3       P$subtotal3"
        } else {
            item3View.visibility = View.GONE
        }

        if (quantity4 > 0) {
            item4View.visibility = View.VISIBLE
            item4View.text = "MCDO MCFLURRY: $quantity4      P$subtotal4"
        } else {
            item4View.visibility = View.GONE
        }

        // Set the total text
        totalView.text = "Total: $total"

        backbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
