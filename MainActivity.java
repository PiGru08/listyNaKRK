package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewWyswietl;
    ArrayList <GraPlanszowa> arrayListGraPlanszowa = new ArrayList<>();
    ArrayAdapter arrayAdapterPolaczenie;
    EditText editTextNazwaGry;
    EditText editTextminGraczy;
    EditText editTextmaxGraczy;
    EditText editTextCzas;
    Spinner spinner;
    Button buttonDodaj;



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

        listViewWyswietl = findViewById(R.id.ListView);
        editTextNazwaGry = findViewById(R.id.editTextNazwa);
        editTextminGraczy = findViewById(R.id.editTextMinLiczbaGraczy);
        editTextmaxGraczy = findViewById(R.id.editTextMaxLiczbaGraczy);
        editTextCzas = findViewById(R.id.editTextCzas);
        spinner = findViewById(R.id.spinner);
        buttonDodaj = findViewById(R.id.button);

        buttonDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nazwaGry = editTextNazwaGry.getText().toString();
                int min = Integer.parseInt(editTextminGraczy.getText().toString());
                int max = Integer.parseInt(editTextmaxGraczy.getText().toString());
                int czas = Integer.parseInt(editTextCzas.getText().toString());
                String rodzaj = spinner.getSelectedItem().toString();
                arrayListGraPlanszowa.add(new GraPlanszowa(nazwaGry,min,max,rodzaj,czas));
                arrayAdapterPolaczenie.notifyDataSetChanged();
            }
        });

        arrayListGraPlanszowa.add(new GraPlanszowa("splendor", 2, 4, "familijna", 40));
        arrayListGraPlanszowa.add(new GraPlanszowa("nucleum", 2, 4, "strategiczna", 120));
        arrayListGraPlanszowa.add(new GraPlanszowa("durak", 3, 6, "familijna", 20));
        arrayListGraPlanszowa.add(new GraPlanszowa("chinczyk", 2, 4, "strategiczna", 20));
        arrayAdapterPolaczenie = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayListGraPlanszowa);
        listViewWyswietl.setAdapter(arrayAdapterPolaczenie);
        listViewWyswietl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayListGraPlanszowa.get(i).zwiekszLicznikGier();
                arrayAdapterPolaczenie.notifyDataSetChanged();
            }
        });



    }
}