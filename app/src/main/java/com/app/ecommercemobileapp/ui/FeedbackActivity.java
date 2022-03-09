package com.app.ecommercemobileapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.ecommercemobileapp.Common;
import com.app.ecommercemobileapp.R;
import com.app.ecommercemobileapp.databinding.ActivityFeedbackBinding;
import com.app.ecommercemobileapp.model.FeedbackModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {

    private static final String TAG = "feedback_db";
    private ActivityFeedbackBinding binding;
    String name,email,feedback;
    private DatabaseReference rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedbackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initValue();
        clickEvent();
    }

    private void clickEvent() {



        binding.submitButton.setOnClickListener(view -> {
            Log.d(TAG, "clickEvent: clicked");
            name = binding.edtName.getText().toString();
            email = binding.edtEmail.getText().toString();
            feedback = binding.edtFeedback.getText().toString();

            if (isValidate()) {
                binding.progressbar.setVisibility(View.VISIBLE);
                FeedbackModel model = new FeedbackModel(name,email,feedback);
                String pushKey = rootRef.child("feedback").push().getKey();
                rootRef.child("feedback").child(pushKey).setValue(model)
                        .addOnCompleteListener(task -> {
                            binding.progressbar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                Common.toast(FeedbackActivity.this,"Feedback added");
                                finish();
                            }
                        });

            }
        });
    }

    private boolean isValidate() {

        Log.d(TAG, "isValidate: inside isValidate");

        if (name.isEmpty()) {
            Common.toast(this,"Enter your name");
            return false;
        }

        if (email.isEmpty()) {
            Common.toast(this,"Enter your email");
            return false;
        }

        if (feedback.isEmpty()) {
            Common.toast(this,"Enter your feedback");
            return false;
        }

        return true;
    }

    private void initValue() {
        rootRef = FirebaseDatabase.getInstance().getReference();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Feedback");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}