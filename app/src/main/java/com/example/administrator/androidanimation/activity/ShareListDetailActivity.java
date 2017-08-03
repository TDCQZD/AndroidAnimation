package com.example.administrator.androidanimation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.androidanimation.R;

public class ShareListDetailActivity extends AppCompatActivity {
    ImageView ivHead;

    TextView txName;

    TextView txDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_share_list_detail);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        int resId = intent.getIntExtra("resId", 0);

        ivHead = (ImageView)findViewById(R.id.iv_head);
        txName = (TextView)findViewById(R.id.tx_name);
        txDesc = (TextView)findViewById(R.id.tx_desc);

        ivHead.setImageResource(resId);
        txName.setText(name);
        txDesc.setText(desc);
    }

}
