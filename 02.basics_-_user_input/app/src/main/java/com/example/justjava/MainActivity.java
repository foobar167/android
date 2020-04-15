package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.EditText;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    static final double COFFEE_PRICE = 5.0;  // COFFEE_PRICE of 1 cup of coffee
    static final double CREAM_PRICE = 1.0;  // CREAM_PRICE of the whipped cream
    static final double CHOCOLATE_PRICE = 2.0;  // CHOCOLATE_PRICE of the chocolate
    static int cupsQuantity = 0;  // coffee cups cupsQuantity
    static String orderMessage = "";  // order message
    static String totalPrice = "";  // total price for coffee
    static boolean hasWhippedCream = false;  // add whipped cream or not
    static boolean hasChocolate = false;  // add chocolate or not

    /**
     * This method is called when the widget is created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Disable default focus for EditText widget
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        display();  // display cups quantity again
    }

    /**
     * Add whipped cream to the cups of coffee or not
     *
     * @param view - view of the main screen
     */
    public void addWhippedCream(View view) {
        hasWhippedCream = !hasWhippedCream;
        display();
    }

    /**
     * Add chocolate to the cups of coffee or not
     *
     * @param view - view of the main screen
     */
    public void addChocolate(View view) {
        hasChocolate = !hasChocolate;
        display();
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
        orderMessage = getOrderMessage();
        setZero();
        display();
    }

    private void setZero() {
        cupsQuantity = 0;
        hasWhippedCream = false;
        hasChocolate = false;
    }

    /**
     * Creates the message output for the order.
     *
     * @return the message
     */
    private String getOrderMessage() {
        EditText name_text = findViewById(R.id.name_text);
        String name = name_text.getText().toString();

        String cups = " cup ";
        if (cupsQuantity > 1) {
            cups = " cups ";
        }
        return "Name: " + name +
               "\nQuantity: " + cupsQuantity + cups + "of coffee" +
               "\nTotal price: " + totalPrice +
               "\nWhipped cream: " + hasWhippedCream +
               "\nChocolate: " + hasChocolate +
               "\nThank you!";  // set order message
    }

    /**
     * This method is called when the cancel button is clicked.
     *
     * @param view - view of the main screen
     */
    public void cancelOrder(View view) {
        orderMessage = "";
        setZero();
        display();
    }

    /**
     * This method displays the given cups quantity value on the screen.
     */
    private void display() {
        Button order = findViewById(R.id.button_order);  // order button
        Button increase = findViewById(R.id.button_increase);  // increase button
        Button decrease = findViewById(R.id.button_decrease);  // decrease button
        Button cancel = findViewById(R.id.button_cancel);  // cancel button
        if (cupsQuantity <= 0) {  // order only positive cups of coffee
            cupsQuantity = 0;  // cups quantity can be >= 0
            order.setEnabled(false);  // disable button
            decrease.setEnabled(false);  // disable button
            cancel.setEnabled(false);  // disable button
            order.setTextColor(getApplication().getResources().getColor(
                    android.R.color.darker_gray));  // change button color
            decrease.setTextColor(getApplication().getResources().getColor(
                    android.R.color.darker_gray));  // change button color
            cancel.setTextColor(getApplication().getResources().getColor(
                    android.R.color.darker_gray));  // change button color
        } else {  // cupsQuantity > 0
            order.setEnabled(true);  // enable button
            decrease.setEnabled(true);  // enable button
            cancel.setEnabled(true);  // enable button
            // Return old button themes
            order.setTextAppearance(getApplicationContext(), R.style.ButtonTheme);
            decrease.setTextAppearance(getApplicationContext(), R.style.ButtonSquare);
            cancel.setTextAppearance(getApplicationContext(), R.style.ButtonTheme);
        }
        if (cupsQuantity >= 10) {
            increase.setEnabled(false);  // disable button
            increase.setTextColor(getApplication().getResources().getColor(
                    android.R.color.darker_gray));  // change button color
        } else {  // cupsQuantity < 10
            increase.setEnabled(true);  // enable button
            increase.setTextAppearance(getApplicationContext(), R.style.ButtonSquare);
        }
        // Update quantity number text view
        TextView quantityTextView = findViewById(R.id.text_quantity_number);
        quantityTextView.setText(String.format(Locale.getDefault(), "%d", cupsQuantity));
        // Display price automatically after quantity of cups is changed
        TextView priceTextView = findViewById(R.id.text_price_number);
        totalPrice = calculatePrice(cupsQuantity);
        priceTextView.setText(totalPrice);
        // Set order message
        TextView orderTextView = findViewById(R.id.text_order_message);
        orderTextView.setText(orderMessage);
        // Set whipped cream or not
        CheckBox whippedCream = findViewById(R.id.whipped_cream_checkbox);
        whippedCream.setChecked(hasWhippedCream);
        // Set chocolate or not
        CheckBox chocolate = findViewById(R.id.chocolate_checkbox);
        chocolate.setChecked(hasChocolate);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private String calculatePrice(int quantity) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);  // set dollars currency
        double oneCupPrice = COFFEE_PRICE;
        if (hasWhippedCream) {
            oneCupPrice += CREAM_PRICE;
        }
        if (hasChocolate) {
            oneCupPrice += CHOCOLATE_PRICE;
        }
        return nf.format(cupsQuantity * oneCupPrice);
    }
}
