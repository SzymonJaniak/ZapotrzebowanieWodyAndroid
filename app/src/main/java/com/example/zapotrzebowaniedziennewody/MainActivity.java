 package com.example.zapotrzebowaniedziennewody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        SeekBar kilo = findViewById(R.id.waga);
        SeekBar intensywnosc = findViewById(R.id.intensywnosc);
        Switch switch1 = findViewById(R.id.switch1);
        TextView ileKilo = findViewById(R.id.ileKilo);
        TextView ileIntensywnosc = findViewById(R.id.ileIntensywnosc);



        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    intensywnosc.setVisibility(View.VISIBLE);
                }
                else{
                    intensywnosc.setVisibility(View.INVISIBLE);
                }
            }
        });

        kilo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {



            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ileKilo.setText("Waga: " + kilo.getProgress() + "kg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        intensywnosc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ileIntensywnosc.setText("Intensywność: " + intensywnosc.getProgress() );

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }

    public void Oblicz(View view) {

        SeekBar kilo = findViewById(R.id.waga);
        SeekBar intensywnosc = findViewById(R.id.intensywnosc);
        Switch switch1 = findViewById(R.id.switch1);
        TextView ileKilo = findViewById(R.id.ileKilo);
        TextView ileIntensywnosc = findViewById(R.id.ileIntensywnosc);

        int waga = kilo.getProgress();
        int intens = intensywnosc.getProgress();
        boolean aktywny = switch1.isChecked();

        Zapotrzebowanie zapotrzebowanie = new Zapotrzebowanie(waga,intens,aktywny);

        double podajzapotrzebowanie = zapotrzebowanie.podajZapotrzebowanie(waga,intens,aktywny);



        Intent intent = new Intent(MainActivity.this, Wynik.class);
        intent.putExtra("zapotrzebowanie", podajzapotrzebowanie);
        intent.putExtra("aktywnosc", intens);
        intent.putExtra("waga", waga);


        startActivity(intent);





    }
}