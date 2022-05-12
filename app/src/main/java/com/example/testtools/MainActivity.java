package com.example.testtools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private int num = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewe();
    }

    private void initViewe() {
        mTv = findViewById(R.id.mTv);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv.setText("啦啦啦啊" + (++num));
                Log.e("Mainactivity", num + "");
                Log.e("第二次提交","测试");
            }
        });

    }
}