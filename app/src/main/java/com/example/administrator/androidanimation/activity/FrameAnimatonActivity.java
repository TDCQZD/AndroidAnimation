package com.example.administrator.androidanimation.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidanimation.R;

/**
 * 帧动画
 *
 * @author ZD
 *         created at 2017/7/13 14:42
 *         description：
 */

public class FrameAnimatonActivity extends AppCompatActivity {

    private ImageView iv;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_frame);
        iv = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.tv_title);
        //设置标题
        textView.setText("帧动画使用");
    }

    public void start(View view) {//Xml开始动画
        iv.setImageResource(R.drawable.weather_animationlist);
        AnimationDrawable animationDrawable = (AnimationDrawable) iv.getDrawable();
        animationDrawable.start();
    }

    public void end(View view) {//Xml结束动画
        iv.setImageResource(R.drawable.weather_animationlist);
        AnimationDrawable animationDrawable = (AnimationDrawable) iv.getDrawable();
        animationDrawable.stop();
    }

    /*
    AnimationDrawable.start实现不能在onCreate中，因为在onCreate中AnimationDrawable尚未绘制到View上。
  如果需要进入界面就自动开始动画，需要在onWindowFocusChanged()回调中执行，此时界面已经创建完成。
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        iv.setImageResource(R.drawable.weather_animationlist);
        AnimationDrawable animationDrawable = (AnimationDrawable) iv.getDrawable();
        animationDrawable.start();
    }

    public void java(View view) {//java实现

        AnimationDrawable anim = new AnimationDrawable();
        anim.addFrame(getResources().getDrawable(R.drawable.clear), 200);
        anim.addFrame(getResources().getDrawable(R.drawable.cloudy), 200);
        anim.addFrame(getResources().getDrawable(R.drawable.haze), 200);
        anim.addFrame(getResources().getDrawable(R.drawable.wind), 200);
        anim.addFrame(getResources().getDrawable(R.drawable.rain), 200);
        anim.addFrame(getResources().getDrawable(R.drawable.storm), 200);
        anim.addFrame(getResources().getDrawable(R.drawable.snow), 200);
        anim.setOneShot(false);
        iv.setImageDrawable(anim);
        anim.start();

    }

}
