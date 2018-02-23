package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        CheckBox wc = (CheckBox) findViewById(R.id.wh_cream);
        CheckBox ch = (CheckBox) findViewById(R.id.ch_cream);
        boolean haswc = wc.isChecked();
        boolean hasch = ch.isChecked();
        String namet = name.getText().toString();
        int price = calculatePrice(haswc, hasch);
        displayMessage(createOrderSummary(namet, price, haswc, hasch));
    }
    public void increment(View view) {
        if(quantity < 100)
            quantity = quantity + 1;
        else {
            Toast.makeText(this, "Not more than 100 cups!", Toast.LENGTH_SHORT).show();
            return;
        }

        displayQuantity(quantity);
    }
    public void decrement(View view) {
        if(quantity > 1)
            quantity = quantity - 1;
        else {
            Toast.makeText(this, "Not less than 1 cup!", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private int calculatePrice(boolean haswc, boolean hasch) {
        int base = 5;
        int total = base;
        if(haswc)
            total = total + 1;
        if(hasch)
            total = total + 2;
        return (quantity * total);
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }
    private String createOrderSummary(String name, int pr, boolean haswc, boolean hasch) {
        return("Name: " + name + "\nAdd whipped cream? " + haswc + "\nAdd Chocolate? " + hasch + "\nQuantity: " + quantity + "\nTotal: $" + pr + "\nThankyou!");
    }
}