package com.example.administrator.androidanimation.activity;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidanimation.R;

/**
 * Android5.0推出的新的动画框架，可以给View做一个揭露效果
 *
 * @author ZD
 *         created at 2017/7/14 10:17
 *         description：
 */

public class CircularReveralActivity extends AppCompatActivity {
    private ImageView imageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_circularepeveral);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        //设置标题
        textView.setText("CircularReveral-View揭露效果");
        imageView = (ImageView) findViewById(R.id.iv_CircularReveral);
    }

    /**
     * 五个参数分别是View，中心点坐标，开始半径，结束半径。通过这五个参数的配合，我们可以做出很多不同的效果。
     * @param v
     */
    public void CircularReveral(View v) {
//        Animator anim = ViewAnimationUtils.createCircularReveal(imageView, 0, 0, 0, (float) Math.hypot(imageView.getWidth(), imageView.getHeight()));
//        anim.setDuration(2000);
//        anim.start();

        Animator anim = ViewAnimationUtils.createCircularReveal(imageView, imageView.getWidth() / 2, imageView.getHeight() / 2, imageView.getWidth(), 0);
        anim.setDuration(5000);
        anim.start();





    }
}
