package com.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button submit;
    SharedPreferences preferences;
    TextView show_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.name);
        submit = (Button)findViewById(R.id.submit);
        show_name = (TextView)findViewById(R.id.show_name);

        preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        final SharedPreferences.Editor setName = preferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setName.putString("name", name.getText().toString());
                setName.commit();

                show_name.setText(preferences.getString("name", ""));
            }
        });

    }
}
