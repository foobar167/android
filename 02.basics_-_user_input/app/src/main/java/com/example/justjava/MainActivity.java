package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    static int cupsQuantity = 0;  // coffee cups cupsQuantity
    static final double COFFEE_PRICE = 5.0;  // COFFEE_PRICE of 1 cup of coffee
    static String orderMessage = "";  // order message

    /**
     * This method is called when the widget is created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display();  // display cups quantity again
    }

    /**
     * Decrement number of cups by 1.
     */
    public void decrement(View view) {
        cupsQuantity--;  // decrease by 1
        orderMessage = "";  // set empty order message
        display();
    }

    /**
     * Increment number of cups by 1.
     */
    public void increment(View view) {
        cupsQuantity++;  // increase by 1
        orderMessage = "";  // set empty order message
        display();
    }

    /**
     * This method is called when the order button is clicked.
     *
     * @param view - view of the main screen
     */
    public void submitOrder(View view) {
        orderMessage = "Thank you!";  // set order message to "Thank you!"
        // Display price when "Order" button is pressed
        displayPrice(cupsQuantity * COFFEE_PRICE);
    }

    /**
     * This method displays the given cups quantity value on the screen.
     */
    private void display() {
        Button order = findViewById(R.id.button_order);  // order button
        Button decrease = findViewById(R.id.button_decrease);  // decrease button
        if(cupsQuantity <= 0) {  // order only positive cups of coffee
            cupsQuantity = 0;  // cups quantity can be >= 0
            order.setEnabled(false);  // disable button
            decrease.setEnabled(false);  // disable button
            order.setTextColor(getApplication().getResources().getColor(
                    android.R.color.darker_gray));  // change button color
            decrease.setTextColor(getApplication().getResources().getColor(
                    android.R.color.darker_gray));  // change button color
        } else {  // cupsQuantity > 0
            order.setEnabled(true);  // enable button
            decrease.setEnabled(true);  // enable button
            // Return old button themes
            order.setTextAppearance(getApplicationContext(), R.style.ButtonTheme);
            decrease.setTextAppearance(getApplicationContext(), R.style.ButtonSquare);
        }
        // Update quantity number text view
        TextView quantityTextView = findViewById(R.id.text_quantity_number);
        quantityTextView.setText(String.format(Locale.getDefault(), "%d", cupsQuantity));
        // Display price automatically after quantity of cups is changed
        displayPrice(cupsQuantity * COFFEE_PRICE);
    }

    /**
     * This method displays the total price on the screen.
     *
     * @param number - price to display
     */
    private void displayPrice(double number) {
        TextView priceTextView = findViewById(R.id.text_price_number);
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);  // set dollars currency
        priceTextView.setText(nf.format(number));
        // Set order message
        TextView orderTextView = findViewById(R.id.text_order_message);
        orderTextView.setText(orderMessage);
    }
}
