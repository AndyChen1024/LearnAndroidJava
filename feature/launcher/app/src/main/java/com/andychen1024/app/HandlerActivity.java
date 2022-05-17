package com.andychen1024.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

public class HandlerActivity extends AppCompatActivity {
    AppCompatButton btnHandler;
    AppCompatButton btnHandler2;
    Thread thread1;
    Thread thread2;
    Handler handler_1 = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            ToastUtils.showShort(msg.obj.toString());
            return false;
        }
    });
    Handler handler_2 = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            ToastUtils.showShort(msg.obj.toString());
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.obj = "测试1111";
                handler_1.sendMessage(message);
            }
        });

        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.obj = "测试2222";
                handler_2.sendMessage(message);
            }
        });

        btnHandler = findViewById(R.id.btn_handler);
        btnHandler2 = findViewById(R.id.btn_handler2);
        btnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread1.start();
            }
        });
        btnHandler2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread2.start();
            }
        });
    }

}