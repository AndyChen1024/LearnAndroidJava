package com.andychen1024.learnandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.andychen1024.common.DeviceUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvMain = findViewById(R.id.tv_main);
        tvMain.setText(DeviceUtil.getDeviceName());
    }
}