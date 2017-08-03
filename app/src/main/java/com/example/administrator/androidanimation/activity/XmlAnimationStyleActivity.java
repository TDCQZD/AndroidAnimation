package com.example.administrator.androidanimation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidanimation.R;

/**
 * 在XMl定义动画类型
 *
 * @author ZD
 *         created at 2017/7/13 11:34
 *         description：
 */

public class XmlAnimationStyleActivity extends AppCompatActivity {
    private ImageView iv;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_xmlstyle);
        iv = (ImageView) findViewById(R.id.iv);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        //设置标题
        textView.setText("XML实现补间动画");
    }

    /**
     * 渐变透明度动画效果
     *
     * @param view
     */
    public void alph(View view) {
        /**
         * 使用XML中的动画效果 第一个参数Context为程序的上下文 第二个参数id为动画XML文件的引用
         */
        animation = AnimationUtils.loadAnimation(this, R.anim.alpha);

        animation.setDuration(5000);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始时调用
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束时调用
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复时调用
            }
        });
        iv.startAnimation(animation);
    }

    /**
     * 渐变尺寸伸缩动画效果
     *
     * @param view
     */
    public void scale(View view) {
        animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        iv.startAnimation(animation);
    }

    /**
     * 画面转换位置移动动画效果
     *
     * @param view
     */
    public void translate(View view) {
        animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        iv.startAnimation(animation);
    }

    /**
     * 画面转移旋转动画效果
     *
     * @param view
     */
    public void rotate(View view) {
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        iv.startAnimation(animation);
    }

    /**
     * 组合动画
     *
     * @param view
     */
    public void setGroupAnimation(View view) {
        animation = AnimationUtils.loadAnimation(this, R.anim.groupanimation);
        animation.setDuration(10000);
        iv.startAnimation(animation);
    }

}
