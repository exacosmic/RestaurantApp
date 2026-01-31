package com.restaurant.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.restaurant.app.models.Address;

public class AddressActivity extends AppCompatActivity {

    private TextInputEditText inputAddress, inputCity, inputZip, inputPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        inputAddress = findViewById(R.id.input_address);
        inputCity = findViewById(R.id.input_city);
        inputZip = findViewById(R.id.input_zip);
        inputPhone = findViewById(R.id.input_phone);
        MaterialButton btnSave = findViewById(R.id.btn_save_address);

        btnSave.setOnClickListener(v -> saveAddress());
    }

    private void saveAddress() {
        String line = inputAddress.getText() != null ? inputAddress.getText().toString().trim() : "";
        String city = inputCity.getText() != null ? inputCity.getText().toString().trim() : "";
        String zip = inputZip.getText() != null ? inputZip.getText().toString().trim() : "";
        String phone = inputPhone.getText() != null ? inputPhone.getText().toString().trim() : "";

        if (line.isEmpty()) {
            Toast.makeText(this, "Please enter an address", Toast.LENGTH_SHORT).show();
            return;
        }

        Address addr = new Address(line, city, zip, phone);
        DataStore.getInstance().addAddress(addr);
        DataStore.getInstance().setSelectedAddress(addr);
        Toast.makeText(this, "Address saved", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }
}
