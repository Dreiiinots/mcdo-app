package com.example.mcdopos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    ////////////////
    private lateinit var incrementbtn1: Button
    private lateinit var decrementbtn1: Button
    private lateinit var tv_quantity1: TextView
    private lateinit var sub_total1: TextView
    ////////////////

    private lateinit var incrementbtn2: Button
    private lateinit var decrementbtn2: Button
    private lateinit var tv_quantity2: TextView
    private lateinit var sub_total2: TextView

    private lateinit var incrementbtn3: Button
    private lateinit var decrementbtn3: Button
    private lateinit var tv_quantity3: TextView
    private lateinit var sub_total3: TextView


//    private lateinit var incrementbtn4: Button
//    private lateinit var decrementbtn4: Button
//    private lateinit var tv_quantity4: TextView
//    private lateinit var sub_total4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var quantity1 = 0
        val price1 = 49
        var subtotal1 = 0
        tv_quantity1 = findViewById(R.id.quantity1)
        incrementbtn1 = findViewById(R.id.incrementbtn1)
        decrementbtn1 = findViewById(R.id.decrementbtn1)
        sub_total1 = findViewById(R.id.subtotal1)

        var quantity2 = 0
        val price2 = 150
        var subtotal2 = 0
        tv_quantity2 = findViewById(R.id.quantity2)
        incrementbtn2 = findViewById(R.id.incrementbtn2)
        decrementbtn2 = findViewById(R.id.decrementbtn2)
        sub_total2 = findViewById(R.id.subtotal2)

        var quantity3 = 0
        val price3 = 129
        var subtotal3 = 0
        tv_quantity3 = findViewById(R.id.quantity3)
        incrementbtn3 = findViewById(R.id.incrementbtn3)
        decrementbtn3 = findViewById(R.id.decrementbtn3)
        sub_total3 = findViewById(R.id.subtotal3)

//        var quantity4 = 0
//        val price4 = 129
//        var subtotal4 = 0
//        tv_quantity4 = findViewById(R.id.quantity4)
//        incrementbtn4 = findViewById(R.id.incrementbtn4)
//        decrementbtn4 = findViewById(R.id.decrementbtn4)
//        sub_total4 = findViewById(R.id.subtotal4)




        val orderbtn = findViewById<Button>(R.id.orderbtn)

        incrementbtn1.setOnClickListener {
            quantity1++
            subtotal1 = quantity1 * price1
            tv_quantity1.text = quantity1.toString()
            sub_total1.text = subtotal1.toString()
        }

        decrementbtn1.setOnClickListener {
            if (quantity1 > 0) quantity1--
            subtotal1 = quantity1 * price1
            tv_quantity1.text = quantity1.toString()
            sub_total1.text = subtotal1.toString()
        }

        incrementbtn2.setOnClickListener {
            quantity2++
            subtotal2 = quantity2 * price2
            tv_quantity2.text = quantity2.toString()
            sub_total2.text = subtotal2.toString()
        }

        decrementbtn2.setOnClickListener {
            if (quantity2 > 0) quantity2--
            subtotal2 = quantity2 * price2
            tv_quantity2.text = quantity2.toString()
            sub_total2.text = subtotal2.toString()
        }

        incrementbtn3.setOnClickListener {
            quantity3++
            subtotal3 = quantity3 * price3
            tv_quantity3.text = quantity3.toString()
            sub_total3.text = subtotal3.toString()
        }

        decrementbtn3.setOnClickListener {
            if (quantity3 > 0) quantity3--
            subtotal3 = quantity3 * price3
            tv_quantity3.text = quantity3.toString()
            sub_total3.text = subtotal3.toString()
        }

//        incrementbtn4.setOnClickListener {
//            quantity4++
//            subtotal4 = quantity4 * price4
//            tv_quantity4.text = quantity4.toString()
//            sub_total4.text = subtotal4.toString()
//        }
//
//        decrementbtn4.setOnClickListener {
//            if (quantity4 > 0) quantity3--
//            subtotal4 = quantity4 * price4
//            tv_quantity4.text = quantity4.toString()
//            sub_total4.text = subtotal4.toString()
//        }

        orderbtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)

            // Create a Bundle to hold item details
            val bundle = Bundle()

            // Add items to the Bundle only if their quantity is greater than 0
            if (quantity1 > 0) {
                bundle.putInt("ITEM1_QUANTITY", quantity1)
                bundle.putInt("ITEM1_SUBTOTAL", subtotal1)
            }
            if (quantity2 > 0) {
                bundle.putInt("ITEM2_QUANTITY", quantity2)
                bundle.putInt("ITEM2_SUBTOTAL", subtotal2)
            }
            if (quantity3 > 0) {
                bundle.putInt("ITEM3_QUANTITY", quantity3)
                bundle.putInt("ITEM3_SUBTOTAL", subtotal3)
            }
//            if (quantity4 > 0) {
//                bundle.putInt("ITEM4_QUANTITY", quantity4)
//                bundle.putInt("ITEM4_SUBTOTAL", subtotal4)
//            }

            // Put the Bundle into the Intent
            intent.putExtra("ITEM_DETAILS", bundle)
            startActivity(intent)
        }
    }
}
