package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn_add;
    private Button btn_Add;
    private EditText edt_title;
    private EditText edt_image;
    private EditText edt_description;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    ArrayList<String> title= new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();
    ArrayList<String> Imageurl = new ArrayList<String>();

    ArrayList<String> titleReceived, imageReceived, descReceived;

    //,,,,"PHP",,"","","","",""};
   // String[]discrption={"git description","github description","flutter description"};
    //,,"react description","unity description",,"",,"","","",""};
    /*String [] Imageurl={"https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png",
            "https://w7.pngwing.com/pngs/914/758/png-transparent-github-social-media-computer-icons-logo-android-github-logo-computer-wallpaper-banner.png",
            "https://blog.logrocket.com/wp-content/uploads/2021/05/intro-dart-flutter-feature.png"};*/
   /* "https://blog.logrocket.com/wp-content/uploads/2021/05/intro-dart-flutter-feature.png",
    "https://reactjs.org/logo-og.png",
    "https://brandslogos.com/wp-content/uploads/images/large/unity-logo.png",
    "",
    "",
    "",
    "",
    "",
    "",
    ""}; */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();

        title.add("Git");
        title.add("GitHub");
        title.add("Flutter");
        title.add("React");
        title.add("Unity ");
        title.add("PHP");
        title.add("MYSql");
        title.add("Angular");
        title.add("C#");
        title.add("C++");
        title.add("Android");
        title.add("IOS");

        description.add("git description");
        description.add("github description");
        description.add("flutter description");
        description.add("react description");
        description.add("unity description");
        description.add("PHP descrption");
        description.add("mysql description");
        description.add("angular description");
        description.add("c# description");
        description.add("c++ description");
        description.add("android description");
        description.add("ios description");

        Imageurl.add("https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png");
        Imageurl.add("https://w7.pngwing.com/pngs/914/758/png-transparent-github-social-media-computer-icons-logo-android-github-logo-computer-wallpaper-banner.png");
        Imageurl.add("https://blog.logrocket.com/wp-content/uploads/2021/05/intro-dart-flutter-feature.png");
        Imageurl.add("https://reactjs.org/logo-og.png");
        Imageurl.add("https://brandslogos.com/wp-content/uploads/images/large/unity-logo.png");
        Imageurl.add("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/PHP-logo.svg/320px-PHP-logo.svg.png");
        Imageurl.add("https://download.logo.wine/logo/MySQL/MySQL-Logo.wine.png");
        Imageurl.add("https://cdn.iconscout.com/icon/free/png-256/angular-2752246-2285063.png");
        Imageurl.add("https://img.icons8.com/ios/452/c-sharp-logo.png");
        Imageurl.add("https://raw.githubusercontent.com/isocpp/logos/master/cpp_logo.png");
        Imageurl.add("https://cdn.worldvectorlogo.com/logos/android-4.svg");
        Imageurl.add("https://cdn3.iconfinder.com/data/icons/social-media-logos-glyph/2048/5315_-_Apple-512.png");

        btn_add=findViewById(R.id.button);
        recyclerView=findViewById(R.id.rv);
        edt_title=findViewById(R.id.editText_title);
        edt_image=findViewById(R.id.editText_image);
        edt_description=findViewById(R.id.editText_description);
        btn_Add=findViewById(R.id.button2);

//Save button can’t be clicked.1
//        edt_title.addTextChangedListener(addTextWatcher);
   //     edt_image.addTextChangedListener(addTextWatcher);
   //     edt_description.addTextChangedListener(addTextWatcher);

        if( getIntent().getStringArrayListExtra("titleArray") != null
        && getIntent().getStringArrayListExtra("descArray") != null
        && getIntent().getStringArrayListExtra("imageArray") != null
        ){

            titleReceived  = getIntent().getStringArrayListExtra("titleArray");
            descReceived  = getIntent().getStringArrayListExtra("descArray");
            imageReceived  = getIntent().getStringArrayListExtra("imageArray");

            adapter = new RecyclerAdapter(this,titleReceived,descReceived,imageReceived);
        }else{

            adapter = new RecyclerAdapter(this,title,description,Imageurl);
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

btn_add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,Add.class);
        if(titleReceived!=null && imageReceived!=null && descReceived!=null){
            intent.putExtra("titleArray",titleReceived);
            intent.putExtra("descArray",descReceived);
            intent.putExtra("imageArray",imageReceived);
        }else{
            intent.putExtra("titleArray",title);
            intent.putExtra("descArray",description);
            intent.putExtra("imageArray",Imageurl);
        }
        startActivity(intent);
    }
});

    }
    //1
    private TextWatcher addTextWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
String inputtitle = edt_title.getText().toString().trim();
String inputImage = edt_image.getText().toString().trim();
String inputDescription = edt_description.getText().toString().trim();
btn_Add.setEnabled(!inputtitle.isEmpty()&& !inputImage.isEmpty()&&!inputDescription.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    }

