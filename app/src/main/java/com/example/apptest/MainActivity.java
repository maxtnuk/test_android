package com.example.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.apptest.databinding.ActivityMainBinding;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=binding.editText.getText().toString();
//                itemAdapter.addItem(content);
//                binding.editText.setText("");
//                itemAdapter.notifyDataSetChanged();
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                Bundle bundle= new Bundle();
                bundle.putString("name",content);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        itemAdapter=new ItemAdapter(new ArrayList<String>(),getLayoutInflater());
        binding.chatList.setAdapter(itemAdapter);

    }
}
