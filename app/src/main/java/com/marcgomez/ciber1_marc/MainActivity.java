package com.marcgomez.ciber1_marc;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

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

        final Button button = findViewById(R.id.toast_button);
        final TextView text = findViewById(R.id.textView);
        ArrayList<String> list = new ArrayList<String>();
        list.add("BUTTON MAKES ME APPEAR");
        list.add("BUTTON CLICKED");
        list.add("DID YOU CLICK THE BUTTON?");
        Toast toast = Toast.makeText(this, "Hello world!", Toast.LENGTH_SHORT);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int random_number = (int) (Math.random()*list.size()+0);
                toast.show();

                text.setText(list.get(random_number));
            }
        });
    }
}