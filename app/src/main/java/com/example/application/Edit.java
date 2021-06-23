package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {

    EditText edText, edText2, edText3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        int itemId = getIntent().getIntExtra("currentItemId",-1);
        ArrayList<String> title  = getIntent().getStringArrayListExtra("titleArray");
        ArrayList<String> desc  = getIntent().getStringArrayListExtra("descArray");
      ArrayList<String> image  = getIntent().getStringArrayListExtra("imageArray");

      EditText edText = findViewById(R.id.editText_title);
        edText.setText(title.get(itemId));

        edText2 = findViewById(R.id.editText_image);
        edText2.setText(image.get(itemId));

        edText3 = findViewById(R.id.editText_description);
        edText3.setText(desc.get(itemId));

        b1 = findViewById(R.id.button2);




        edText.addTextChangedListener(addTextWatcher);

        edText2.addTextChangedListener(addTextWatcher);
        edText3.addTextChangedListener(addTextWatcher);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //none of the fields is empty
                    title.set(itemId, edText.getText().toString());
                    desc.set(itemId, edText3.getText().toString());
                    image.set(itemId, edText2.getText().toString());

                    Intent intent = new Intent(Edit.this,MainActivity.class);
                    intent.putExtra("titleArray",title);
                    intent.putExtra("descArray",desc);
                    intent.putExtra("imageArray",image);
                    startActivity(intent);
            }
        });

    }

    private TextWatcher addTextWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.toString().trim().length()==0){

                b1.setEnabled(false);
            }else{
                b1.setEnabled(true);
            }

        }
    };


}