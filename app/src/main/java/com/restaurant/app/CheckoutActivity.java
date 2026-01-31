package com.restaurant.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.restaurant.app.models.Address;

public class CheckoutActivity extends AppCompatActivity {

    private static final int REQUEST_SELECT_ADDRESS = 100;

    private RadioGroup radioDeliveryOption;
    private LinearLayout addressSection;
    private TextView selectedAddressText;
    private MaterialButton btnPlaceOrder;
    private boolean isDelivery = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        radioDeliveryOption = findViewById(R.id.radio_delivery_option);
        addressSection = findViewById(R.id.address_section);
        selectedAddressText = findViewById(R.id.selected_address_text);
        MaterialButton btnSelectAddress = findViewById(R.id.btn_select_address);
        btnPlaceOrder = findViewById(R.id.btn_place_order);

        radioDeliveryOption.setOnCheckedChangeListener((group, checkedId) -> {
            isDelivery = (checkedId == R.id.radio_delivery);
            addressSection.setVisibility(isDelivery ? View.VISIBLE : View.GONE);
            updatePlaceOrderEnabled();
        });

        btnSelectAddress.setOnClickListener(v ->
            startActivityForResult(new Intent(this, AddressActivity.class), REQUEST_SELECT_ADDRESS));

        btnPlaceOrder.setOnClickListener(v -> placeOrder());

        refreshAddressDisplay();
        updatePlaceOrderEnabled();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_ADDRESS && resultCode == RESULT_OK) {
            refreshAddressDisplay();
        }
    }

    private void refreshAddressDisplay() {
        Address addr = DataStore.getInstance().getSelectedAddress();
        if (addr != null) {
            selectedAddressText.setText(addr.toString());
            selectedAddressText.setTextColor(getResources().getColor(android.R.color.black, getTheme()));
        } else {
            selectedAddressText.setText("No address selected");
            selectedAddressText.setTextColor(getResources().getColor(R.color.gray, getTheme()));
        }
        updatePlaceOrderEnabled();
    }

    private void updatePlaceOrderEnabled() {
        boolean needAddress = isDelivery;
        boolean hasAddress = DataStore.getInstance().getSelectedAddress() != null;
        btnPlaceOrder.setEnabled(!needAddress || hasAddress);
    }

    private void placeOrder() {
        String option = isDelivery ? "Delivery" : "Pickup";
        Address addr = DataStore.getInstance().getSelectedAddress();
        String msg = "Order placed! " + option;
        if (isDelivery && addr != null) {
            msg += "\nDeliver to: " + addr.getAddressLine() + ", " + addr.getCity();
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        CartManager.getInstance().clear();
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}
