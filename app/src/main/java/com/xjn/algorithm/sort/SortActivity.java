package com.xjn.algorithm.sort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.xjn.algorithm.MainActivity;
import com.xjn.algorithm.R;
import com.xjn.algorithm.utils.ALog;

public class SortActivity extends AppCompatActivity {
    private static final String TAG = SortActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        init();
    }

    private void init() {
        findViewById(R.id.btn_bubble_sort).setOnClickListener(v -> {
            ALog.d(TAG, "init start BubbleSortActivity");
            Intent intent = new Intent();
            intent.setClass(SortActivity.this, BubbleSortActivity.class);
            startActivity(intent);
        });
    }
}