package com.example.administrator.androidanimation.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.androidanimation.R;

import static com.example.administrator.androidanimation.R.anim.rotate;

public class AnimatorAnimatonActivity extends AppCompatActivity {
    private ImageView iv;

    private View view;
    private ValueAnimator animator;
    private ObjectAnimator objectAnimator;
    private AnimatorSet animSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_animator_animaton);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        //设置标题
        textView.setText("属性动画高级用法");
        iv = (ImageView) findViewById(R.id.iv);
        view = findViewById(R.id.iv);
    }

    public void PathAnimation(View view) {
        startActivity(new Intent(AnimatorAnimatonActivity.this, PathAnimActivity.class));
    }

    public void TypeEvaluator(View view) {
        startActivity(new Intent(AnimatorAnimatonActivity.this, TypeEvaluatorActivity.class));
//        anim1();
    }

    public void TimeInterpolator(View view) {
        startActivity(new Intent(AnimatorAnimatonActivity.this, TimeInterpolatorActivity.class));
    }


    /*
    ViewPropertyAnimator使用
     */
    public void ViewPropertyAnimator(View view) {//控件移动到（0,0）
        iv.animate().x(0).y(0).setDuration(5000)
                .setInterpolator(new BounceInterpolator());


    }

    /*
    PropertyValuesHolders使用
     */
    public void PropertyValuesHolder(View view) {
          /*
        一个ObjectAnimator
         */
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("x", 50f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", 100f);
        ObjectAnimator.ofPropertyValuesHolder(iv, pvhX, pvhY).start();

    }

    public void Keyframe(View view) {
        //keyframe
        Keyframe keyframe1 = Keyframe.ofFloat(0.0f, 0);
        Keyframe keyframe2 = Keyframe.ofFloat(0.25f, -30);
        Keyframe keyframe3 = Keyframe.ofFloat(0.5f, 0);
        Keyframe keyframe4 = Keyframe.ofFloat(0.75f, 30);
        Keyframe keyframe5 = Keyframe.ofFloat(1.0f, 0);
        PropertyValuesHolder rotation = PropertyValuesHolder.ofKeyframe("rotation", keyframe1, keyframe2, keyframe3, keyframe4, keyframe5);

        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.2f, 1.0f);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.2f, 1.0f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.2f, 1.0f);
        PropertyValuesHolder color = PropertyValuesHolder.ofInt("BackgroundColor", 0XFFFFFF00, 0XFF0000FF);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv, alpha, scaleX, scaleY, color, rotation);
        animator.setInterpolator(new OvershootInterpolator());
        animator.setDuration(5000).start();
    }

    /**
     * ValueAnimator使用
     *
     * @param view
     */
    public void valueAnimator(View view) {

        animator = ValueAnimator.ofFloat(1f, 0.5f, 1f); //值从0平滑过渡到1
//        animator = ValueAnimator.ofInt(0, 100);//将一个整数值从0平滑地过渡到100
//        animator = ValueAnimator.ofArgb();
//        animator = ValueAnimator.ofObject();
//        animator = ValueAnimator.ofPropertyValuesHolder();
//        animator = ValueAnimator.ofFloat(0f, 5f, 3f, 10f,1f);//传入任意多个参数
//        animator = ValueAnimator.ofFloat(0, 360);//动画绘制 定义动画的值范围
        animator.setDuration(5000);//动画持续时间
        animator.setInterpolator(new LinearInterpolator());////使用插值器
//        animator.setInterpolator(new MyDecelerateAccelerateInterpolator());//使用自定义插值器
//        animator.setRepeatCount(2);//设置重复动画，重复1次，则实际播放2次
        //设置重复模式：逆向重复
//        animator.setRepeatMode(ValueAnimator.REVERSE);
        //设置重复模式：重新开始
//        animator.setRepeatMode(ValueAnimator.RESTART);
        //监听动画每一帧的值,添加对值的监听，获取值
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //动画开始
                Toast.makeText(AnimatorAnimatonActivity.this, "动画开始了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //动画结束
                Toast.makeText(AnimatorAnimatonActivity.this, "动画结束了", Toast.LENGTH_SHORT).show();
                animation.cancel();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                //动画取消，不论动画如何结束，取消还是正常结束，都会回调onAnimationEnd
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                //动画重复
            }
        });
        animator.addPauseListener(new Animator.AnimatorPauseListener() {
            @Override
            public void onAnimationPause(Animator animation) {//通知动画暂停。

            }

            @Override
            public void onAnimationResume(Animator animation) {//通知动画得到恢复，之前被暂停后。

            }
        });
        //监听动画每一帧的值,添加对值的监听，获取值
        /*
        该监听器负责更新对象的值
        可以通过getAnimatedValue（）方法来获取当前帧的值，并将计算出来的值应用到指定对象上。
         */
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                iv.setRotationY(rotate);
                //打印
                Log.i("TAG", "onAnimationUpdate: value = "
                        + value);
            }
        });
        animator.start();

    }


    /**
     * ObjectAnimator使用
     *
     * @param view
     */
    public void ObjectAnimator(View view) {
//        ObjectAnimator ofFloat(Object target, String propertyName, float... values)
        /*
         * 第一个参数：动画的控件
         * 第二个参数：动画的属性名 任意的值 alpha、rotation、translationX、scaleY
         * 第三个参数：可变参数，表示动画值的范围
         *  其中属性名是一个字符串，ObjectAnimator会根据这个属性名拼一个set[属性名]（setRotationY）方法，然后用反射调用，从而实现动画
         */
//        objectAnimator = ObjectAnimator.ofFloat(iv, "rotationY", 0, 359);

//        objectAnimator = ObjectAnimator.ofObject(iv, "rotationY", 0, 359);
//        objectAnimator = ObjectAnimator.ofArgb(iv, "rotationY", 0, 359);
//        objectAnimator = ObjectAnimator.ofInt(iv, "rotationY", 0, 359);
//        objectAnimator = ObjectAnimator.ofMultiFloat(iv, "rotationY", 0, 359);
//        objectAnimator = ObjectAnimator.ofMultiInt(iv, "rotationY", 0, 359);
//        objectAnimator = ObjectAnimator.ofPropertyValuesHolder(iv, "rotationY", 0, 359);

        float curTranslationX = iv.getTranslationX();//获取到当前控件的translationX的位置
        /*
         * 第一个参数：动画的控件
         * 第二个参数：
         * 第三个参数：系统控件移动方向
         * 第四个参数：
         * 第五个参数：
        */
        objectAnimator = ObjectAnimator.ofFloat(iv, "translationX", curTranslationX, -500f, curTranslationX);

        objectAnimator.setDuration(5000);
        objectAnimator.setRepeatCount(1);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.addPauseListener(new Animator.AnimatorPauseListener() {
            @Override
            public void onAnimationPause(Animator animation) {//通知动画暂停。

            }

            @Override
            public void onAnimationResume(Animator animation) {//通知动画得到恢复，之前被暂停后。

            }
        });

        objectAnimator.start();
    }


    public void anim1() {
        //定义动画的值范围
        PointF startPoint = new PointF(0f, 0f);
        PointF endPoint = new PointF(5f, 5f);
        ValueAnimator valueAnimator =
                ValueAnimator.ofObject(new MyPointFEvaluator(), startPoint, endPoint);
        //设置动画时长
        valueAnimator.setDuration(100);
        //添加对值的监听，获取值
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF) animation.getAnimatedValue();

                Log.d("ruicbAndroid", "onAnimationUpdate：" + pointF.toString());
            }
        });
        //启动动画
        valueAnimator.start();
    }

    /**
     * 自定义插值器
     */
    public class MyDecelerateAccelerateInterpolator implements TimeInterpolator {
        @Override
        public float getInterpolation(float input) {
            if (input <= 0.5) {
                return (float) (Math.sin(Math.PI * input)) / 2;
            } else {
                return (float) (2 - Math.sin(Math.PI * input)) / 2;
            }
        }
    }

    /**
     * 自定义属性值
     */
    public class MyPointFEvaluator implements TypeEvaluator<PointF> {
        PointF pointF;

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            float x = startValue.x + (endValue.x - startValue.x) * fraction;
            float y = startValue.y + (endValue.y - startValue.y) * fraction;

            // 该方法在动画过程中的每一帧都会调用，
            // 使用此举以避免重复创建PointF对象
            if (null == pointF) {
                pointF = new PointF();
            }
            pointF.set(x, y);
            return pointF;
        }
    }
}
