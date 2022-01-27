package com.xjn.algorithm.sort;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.xjn.algorithm.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSortActivity extends AppCompatActivity {
    private static final int[] DATA = new int[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5};
    private BarChart mBarChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sort);

        init();
    }

    private void init() {
        mBarChart = findViewById(R.id.bar_chart);

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < DATA.length; i++) {
            values.add(DATA[i]);
        }
        onDataChanged(mBarChart, values, null, values.size() - 1);

        findViewById(R.id.btn_start).setOnClickListener(v -> {

        });
    }

    private void onDataChanged(BarChart chart, List<Integer> values, int[] targets, int end) {
        List<BarEntry> barEntries = new ArrayList<>();
        List<Integer> colors = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            barEntries.add(new BarEntry(i, values.get(i)));
            if (i > end) {
                colors.add(Color.BLUE);
            } else {
                colors.add(Color.CYAN);
            }
        }

        if (null != targets) {
            for (int i = 0; i < targets.length; i++) {
                colors.set(targets[i], Color.GREEN);
            }
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "labelName");
        barDataSet.setColors(colors);
        BarData barData = new BarData(barDataSet);
        mBarChart.setData(barData);
    }
}