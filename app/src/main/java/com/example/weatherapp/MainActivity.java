package com.example.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView_f;
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
        //si aan iskuguxiro xml and java

        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);
        textView_f=findViewById(R.id.formula);

        // si  buutonka lagujiyoh waxaan isticmaaleenaa setOnclickListner

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String fernahite=editText.getText().toString();
                float formula=(Float.parseFloat(fernahite)-32)*5/9;
                String result=String.format("%.1f",formula);
                Toast.makeText(MainActivity.this , result, Toast.LENGTH_LONG).show();
                textView_f.setText(fernahite+"°F="+result+"°C");

            }
        });



    }
}