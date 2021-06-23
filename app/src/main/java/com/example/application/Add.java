package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ArrayList<String> title  = getIntent().getStringArrayListExtra("titleArray");
        ArrayList<String> desc  = getIntent().getStringArrayListExtra("descArray");
        ArrayList<String> image  = getIntent().getStringArrayListExtra("imageArray");

        EditText edText = findViewById(R.id.editText_title);
        EditText edText2 = findViewById(R.id.editText_image);
        EditText edText3 = findViewById(R.id.editText_description);

        Button b1 = findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edText.equals("")){
                    Toast.makeText(getApplicationContext(),"Title is empty!", Toast.LENGTH_SHORT).show();
                }else if(edText2.equals("")){
                    Toast.makeText(getApplicationContext(),"Image is empty!", Toast.LENGTH_SHORT).show();
                }else if(edText3.equals("")){
                    Toast.makeText(getApplicationContext(),"Description is empty!", Toast.LENGTH_SHORT).show();
                }else{
                    //none of the fields is empty
                    title.add(edText.getText().toString());
                    desc.add(edText3.getText().toString());
                    image.add(edText2.getText().toString());

                    Intent intent = new Intent(Add.this,MainActivity.class);
                    intent.putExtra("titleArray",title);
                    intent.putExtra("descArray",desc);
                    intent.putExtra("imageArray",image);
                    startActivity(intent);


                }



            }
        });

    }
}