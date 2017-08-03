package com.example.administrator.androidanimation.practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.androidanimation.R;
/**
*输入框没有输入的水平晃动动画
*@author ZD
*created at 2017/7/20 9:38
*description：
*/ 
public class InputETShakeActivity extends AppCompatActivity {
    private EditText et_main_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_etshake);

        et_main_name = (EditText) findViewById(R.id.et_main_name);
    }

    public void login(View v) {
        //得到输入框的文本
        String name = et_main_name.getText().toString();
        //判断是否是空串, 如果为空串, 显示抖动动画
        if(TextUtils.isEmpty(name.trim())) {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.shake);
            et_main_name.startAnimation(animation);
        } else {
            //否则, 提示操作成功
            Toast.makeText(this, "操作成功", Toast.LENGTH_SHORT).show();
        }

    }
}
