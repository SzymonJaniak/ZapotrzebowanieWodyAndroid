package com.example.zapotrzebowaniedziennewody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Wynik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wynik);

        // Obsługa systemowych pasków za pomocą Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        double zapotrzebowanie = getIntent().getDoubleExtra("zapotrzebowanie", 0);
        int aktywnosc =  getIntent().getIntExtra("aktywnosc", 0);
        int waga =  getIntent().getIntExtra("waga", 0);


        TextView wagapole = findViewById(R.id.waga);
        TextView aktywnoscpole = findViewById(R.id.aktywnosc);
        TextView zapotrzebowaniepole = findViewById(R.id.zapotrzebowanie);

        wagapole.setText("Waga: " + waga);
        aktywnoscpole.setText("Aktywność fizyczna: " + waga);
        zapotrzebowaniepole.setText("Zapotrzebowanie na wode: " + zapotrzebowanie);



    }

    public void wroc(View view) {
        Intent intent = new Intent(Wynik.this, MainActivity.class);
        startActivity(intent);

    }
}
