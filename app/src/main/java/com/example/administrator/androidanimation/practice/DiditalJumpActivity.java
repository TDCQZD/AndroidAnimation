package com.example.administrator.androidanimation.practice;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.administrator.androidanimation.R;
/**
*属性动画实例——数字跳转
*@author ZD
*created at 2017/7/28 9:45
*description：
*/ 
public class DiditalJumpActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_didital_jump);
        //设置标题
        TextView textView = (TextView) findViewById(R.id.tv_title);
        textView.setText("属性动画实例—数字跳转");
        tv = (TextView) findViewById(R.id.tv);

    }
    /**
     * 数字跳转
     *
     * @param view
     */
    public void digital(View view) {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 2000);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                tv.setText(String.valueOf(value));
                //打印
                Log.i("TAG", "onAnimationUpdate: value = "
                        + value);
            }
        });
        animator.start();

    }
}
