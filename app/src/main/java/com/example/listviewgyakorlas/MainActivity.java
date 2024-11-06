  package com.example.listviewgyakorlas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import java.util.ArrayList;

  public class MainActivity extends AppCompatActivity {

    private ListView lv_main;
    private List<String> kajak = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        kajak.add("kaja");
        kajak.add("étel");
        Intent mainIntent = new Intent(MainActivity.this, PluszKaja.class);
        String ujKaja = mainIntent.getStringExtra("ujKaja");
        kajak.add(ujKaja);
        lv_main = findViewById(R.id.ListView_main);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, kajak);

        lv_main.setAdapter(arrayAdapter);
    }
}