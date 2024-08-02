package com.example.mcdopos

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.mcdopos.R.*

class MainActivity : AppCompatActivity() {


    private lateinit var incrementbtn1: Button
    private lateinit var decrementbtn1: Button
    private lateinit var tv_quantity1: TextView
    private lateinit var sub_total1: TextView

    private lateinit var incrementbtn2: Button
    private lateinit var decrementbtn2: Button
    private lateinit var tv_quantity2: TextView
    private lateinit var sub_total2: TextView

    private lateinit var incrementbtn3: Button
    private lateinit var decrementbtn3: Button
    private lateinit var tv_quantity3: TextView
    private lateinit var sub_total3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        var quantity1 = 0
        var price1 = 49
        var subtotal1 = 0
        tv_quantity1 = findViewById(R.id.quantity1)
        incrementbtn1 = findViewById(R.id.incrementbtn1)
        decrementbtn1 = findViewById(R.id.decrementbtn1)
        sub_total1 = findViewById(R.id.subtotal1)

        var quantity2 = 0
        var price2 = 150
        var subtotal2 = 0
        tv_quantity2 = findViewById(R.id.quantity2)
        incrementbtn2 = findViewById(R.id.incrementbtn2)
        decrementbtn2 = findViewById(R.id.decrementbtn2)
        sub_total2 = findViewById(R.id.subtotal2)

        var quantity3 = 0
        var price3 = 129
        var subtotal3 = 0
        tv_quantity3 = findViewById(R.id.quantity3)
        incrementbtn3 = findViewById(R.id.incrementbtn3)
        decrementbtn3 = findViewById(R.id.decrementbtn3)
        sub_total3 = findViewById(R.id.subtotal3)

        var orderbtn = findViewById<Button>(R.id.orderbtn)



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

        orderbtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("QUANTITY1", quantity1)
                putExtra("SUBTOTAL1", subtotal1)
                putExtra("QUANTITY2", quantity2)
                putExtra("SUBTOTAL2", subtotal2)
                putExtra("QUANTITY3", quantity3)
                putExtra("SUBTOTAL3", subtotal3)
            }
            startActivity(intent)
        }


        fun calculateSubtotal(args: Array<Int>): Int = args.sumOf { it }

    }
}
