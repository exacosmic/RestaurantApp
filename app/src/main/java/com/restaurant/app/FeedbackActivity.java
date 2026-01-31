package com.restaurant.app;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.restaurant.app.adapters.FeedbackAdapter;
import com.restaurant.app.models.FeedbackItem;

import java.util.List;

public class FeedbackActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private FeedbackAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        RatingBar ratingBar = findViewById(R.id.rating_bar);
        EditText inputComment = findViewById(R.id.input_comment);
        MaterialButton btnSubmit = findViewById(R.id.btn_submit_feedback);

        recycler = findViewById(R.id.recycler_feedback);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        List<FeedbackItem> list = DataStore.getInstance().getFeedbackList();
        adapter = new FeedbackAdapter(list);
        recycler.setAdapter(adapter);

        btnSubmit.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            String comment = inputComment.getText().toString().trim();
            FeedbackItem f = new FeedbackItem(rating, comment);
            DataStore.getInstance().addFeedback(f);
            adapter = new FeedbackAdapter(DataStore.getInstance().getFeedbackList());
            recycler.setAdapter(adapter);
            inputComment.setText("");
            ratingBar.setRating(5);
            Toast.makeText(this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show();
        });
    }
}
