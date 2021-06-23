package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        int itemId = getIntent().getIntExtra("currentItemId",-1);
        ArrayList<String> title  = getIntent().getStringArrayListExtra("titleArray");
        ArrayList<String> desc  = getIntent().getStringArrayListExtra("descArray");
        ArrayList<String> image  = getIntent().getStringArrayListExtra("imageArray");

        EditText edText = findViewById(R.id.editText_title);
        edText.setText(title.get(itemId));

        EditText edText2 = findViewById(R.id.editText_image);
        edText2.setText(image.get(itemId));

        EditText edText3 = findViewById(R.id.editText_description);
        edText3.setText(desc.get(itemId));

        Button b1 = findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edText.equals("")){
                    Toast.makeText(Details.this,"Title is empty!", Toast.LENGTH_SHORT).show();
                }else if(edText2.equals("")){
                    Toast.makeText(Details.this,"Image is empty!", Toast.LENGTH_SHORT).show();
                }else if(edText3.equals("")){
                    Toast.makeText(Details.this,"Description is empty!", Toast.LENGTH_SHORT).show();
                }else{
                    //none of the fields is empty
                    Intent intent = new Intent(Details.this,Edit.class);
                    intent.putExtra("currentItemId",itemId);
                    intent.putExtra("titleArray",title);
                    intent.putExtra("descArray",desc);
                    intent.putExtra("imageArray",image);
                    startActivity(intent);
                }

            }
        });

        Button buttonDelete = findViewById(R.id.buttonDeleta);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(itemId!=-1){
                        //delete from array
                    //none of the fields is empty
                    title.remove(itemId);
                    desc.remove(itemId);
                    image.remove(itemId);

                    Intent intent = new Intent(Details.this,MainActivity.class);
                    intent.putExtra("titleArray",title);
                    intent.putExtra("descArray",desc);
                    intent.putExtra("imageArray",image);
                    startActivity(intent);
                }

            }
        });

    }
}