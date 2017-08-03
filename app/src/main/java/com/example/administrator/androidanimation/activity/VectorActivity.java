package com.example.administrator.androidanimation.activity;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.androidanimation.R;
/**
*矢量动画
*@author ZD
*created at 2017/7/14 16:19
*description：
*/
public class VectorActivity extends AppCompatActivity {
    private ImageView imgBtn;

    private ImageView iv1;

    private ImageView iv2;

    private ImageView iv3;

    private boolean isSearchBoxChecked = false;

    private boolean isTwitterChecked = false;

    private boolean isFavoriteClick = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_vector);
        imgBtn = (ImageView)findViewById(R.id.imgBtn);
        iv1 = (ImageView)findViewById(R.id.iv_1);
        iv2 = (ImageView)findViewById(R.id.iv_2);
        iv3 = (ImageView)findViewById(R.id.iv_3);
    }
    public void startAnim(View view) {
        Drawable drawable = imgBtn.getDrawable();
        ((Animatable) drawable).start();
    }

    public void onSearchBoxClick(View view) {
        isSearchBoxChecked = !isSearchBoxChecked;
        final int[] stateSet = {android.R.attr.state_checked * (isSearchBoxChecked ? 1 : -1)};
        iv1.setImageState(stateSet, true);
    }

    public void onTwitterClick(View view) {
        isTwitterChecked = !isTwitterChecked;
        final int[] stateSet = {android.R.attr.state_checked * (isTwitterChecked ? 1 : -1)};
        iv2.setImageState(stateSet, true);
    }

    public void onFavoriteClick(View view) {
        isFavoriteClick = !isFavoriteClick;
        final int[] stateSet = {android.R.attr.state_checked * (isFavoriteClick ? 1 : -1)};
        iv3.setImageState(stateSet, true);
    }
}
