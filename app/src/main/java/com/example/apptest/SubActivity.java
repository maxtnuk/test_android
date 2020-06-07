package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;
import com.example.apptest.databinding.ActivitySubBinding;

import android.content.Intent;
import android.os.Bundle;

public class SubActivity extends AppCompatActivity {

    private ActivitySubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        String result= intent.getStringExtra("name");
        binding.subText.setText(result);

    }
}
