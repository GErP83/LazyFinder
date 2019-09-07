package com.gerp83.lazyfindertest;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gerp83.lazyfinder.LazyFinder;

/**
 * Created by GErP83 on 2017. 09. 24..
 *
 */

public class MainActivity extends AppCompatActivity{

    private Button test1 = null;
    private Button test2 = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        LazyFinder.findAll(this);


        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });

        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TestFragmentActivity.class));
            }
        });

    }
}
