package com.restaurant.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCardView cardMenu = findViewById(R.id.card_menu);
        MaterialCardView cardCart = findViewById(R.id.card_cart);
        MaterialCardView cardFeedback = findViewById(R.id.card_feedback);

        cardMenu.setOnClickListener(v -> startActivity(new Intent(this, MenuActivity.class)));
        cardCart.setOnClickListener(v -> startActivity(new Intent(this, CartActivity.class)));
        cardFeedback.setOnClickListener(v -> startActivity(new Intent(this, FeedbackActivity.class)));
    }
}
