package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    static int quantity = 0;  // order quantity
    static double price = 5;  // $5 for 1 cup of coffee
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);  // set dollars currency

    /**
     * This method is called when the widget is created.
     *
     * @param savedInstanceState - I don't know what is it :-)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(quantity);  // display quantity again
    }

    /**
     * This method is called when the order button is clicked.
     *
     * @param view - view of the main screen
     */
    public void submitOrder(View view) {
        quantity += 1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     *
     * @param number - number to display
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.text_quantity_number);
        quantityTextView.setText(String.format(Locale.getDefault(), "%d", number));
        displayPrice(number * price);  // display price after displaying quantity
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(double number) {
        TextView priceTextView = (TextView) findViewById(R.id.text_price_number);
        priceTextView.setText(nf.format(number));
    }
}
