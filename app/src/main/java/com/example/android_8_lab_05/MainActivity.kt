package com.example.android_8_lab_05

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onPlaceOrderButtonClicked(view: View) {
        var pizzaSizePrice = 0.0
        var toppingsTotal = 0.0
        try {

            when {
                radioGroup.smallPizza.isChecked -> pizzaSizePrice = 5.0
                radioGroup.mediumPizza.isChecked -> pizzaSizePrice = 7.0
                radioGroup.largePizza.isChecked -> pizzaSizePrice = 9.0
                else -> throw Exception("No size chosen")
            }

            if (OnionsCheckBox.isChecked) { toppingsTotal += 1.0}
            if (OlivesCheckBox.isChecked) { toppingsTotal += 2.0}
            if (TomatoesCheckBox.isChecked) { toppingsTotal += 3.0}

            totalPrice.text="Order total: $"+(pizzaSizePrice + toppingsTotal)

        } catch(e:Exception) {
            totalPrice.text="No size chosen. Please select a size"
        }

    }
}