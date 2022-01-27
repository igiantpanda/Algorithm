package com.xjn.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xjn.algorithm.sort.SortActivity;
import com.xjn.algorithm.utils.ALog;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        findViewById(R.id.btn_sort).setOnClickListener(v -> {
            ALog.d(TAG, "init start SortActivity");
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SortActivity.class);
            startActivity(intent);
        });
    }
}