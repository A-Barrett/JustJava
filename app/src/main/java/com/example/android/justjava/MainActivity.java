package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById( R.id.whipped_cream_checkbox );
        boolean hasWhippecCream = whippedCreamCheckBox.isChecked();
        int price = calculatePrice();
        displayMessage( createOrderSummary( price, hasWhippecCream ) );
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;

    }

    /**
     * Create summary of order.
     *
     * @param price           of order.
     * @param addWhippedCream is whether the user wants whipped cream topping.
     * @return text summary.
     */
    private String createOrderSummary(int price, boolean addWhippedCream) {
        String priceMessage = "Name: Barrett";
        priceMessage += "\nAdd Whipped cream?" + addWhippedCream;
        priceMessage += "\nQuantity:" + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayquantity(int number) {
        TextView quantityTextView = findViewById( R.id.quantity_text_view );
        quantityTextView.setText( "" + number );
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayquantity( quantity );
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayquantity( quantity );
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById( R.id.order_summary_text_view );
        orderSummaryTextView.setText( message );
    }
}
