package com.example.tiktok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.tiktok.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   ActivityMainBinding binding;
   ArrayList<Model> models=new ArrayList<>();
   Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
         //requestWindowFeature(Window.FEATURE_NO_TITLE);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getTheme().applyStyle(R.style.FullScreen,false );
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        models.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.a,R.drawable.pic1,"John Abraham"));
        models.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.b,R.drawable.pic2,"Shah Rukh"));
        models.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.c,R.drawable.pic3,"Salman Khan"));
        models.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.d,R.drawable.pic4,"Aamir Khan"));
        models.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.e,R.drawable.pic5,"Kaise Ho"));
        models.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.f,R.drawable.pic6,"Tera Baap"));
        models.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.g,R.drawable.pic7,"Kaun Bola"));
        adapter=new Adapter(MainActivity.this,models);
        binding.vpg2.setAdapter(adapter);
    }
}