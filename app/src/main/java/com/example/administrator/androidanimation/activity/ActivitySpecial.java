package com.example.administrator.androidanimation.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.view.Window;

import com.example.administrator.androidanimation.R;

/**
 * @author ZD
 *         created at 2017/7/14 10:26
 *         description：
 *         5.0新的转场动画分为4种，Explode、Slide、Fade、Share，传统的转场动画只能作用于整个页面，不能对页面中的单个元素做控制，
 *         而5.0新转场动画可以控制页面中的每个元素
 */

public class ActivitySpecial extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_special);
    }

    public void oldSpecial(View v) {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
    }

    public void Explode(View v) {//Explode的效果是下一个页面的元素从四面八方进入，最终形成完整的页面
        Intent intent = new Intent(this, CAActivity.class);
        intent.putExtra("flag", 0);
        /*
        在跳转时就要注意一点，intent后面还要再传一个参数bundle，
        固定写法ActivityOptions.makeSceneTransitionAnimation(this).toBundle()，
        下一个Activity根据这个就能识别出使用5.0新转场动画
         */
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

    }

    public void Slide(View v) {//Slide就是下一个页面元素从底部依次向上运动，最终形成完整的页面
        Intent intent = new Intent(this, CAActivity.class);
        intent.putExtra("flag", 1);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void Fade(View v) {//Fade就是下一个页面元素渐变出现，最终形成完整的页面
        Intent intent = new Intent(this, CAActivity.class);
        intent.putExtra("flag", 2);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void Share(View v) {
        // 跳转时，要为每一个共享的view设置对应的transitionName
        View fab = findViewById(R.id.fab_button);
        View txName = findViewById(R.id.tx_user_name);
        Intent intent = new Intent(this, CAActivity.class);
        intent.putExtra("flag", 3);
        //创建单个共享元素
//        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, view, "share").toBundle());
        //创建多个共享单元
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create(v, "share"),
                Pair.create(fab, "fab"),
                Pair.create(txName, "user_name"))
                .toBundle());


    }

    public void typical(View v) {
        startActivity(new Intent(this, ShareListActivity.class));
    }

}
