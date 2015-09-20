package com.gh.app.militaryforce.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.gh.app.militaryforce.MainActivity;
import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.base.BaseActivity;
import com.gh.app.militaryforce.util.SharedPreUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StartActivity extends BaseActivity {
    private Boolean isFirstIn=false;
    private static String FIRST_TAG="ghapp";
    private static final int TIME = 2000;
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;
@Bind(R.id.iv_start)
    ImageView iv_start;

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    ButterKnife.bind(this);

        initView();
    }

    public  void initData(){
        //new SharedPre().invoke();
        isFirstIn=SharedPreUtil.getBooleanShared(this,FIRST_TAG,"isFirstIn",true);
        if(!isFirstIn){
            mHandler.sendEmptyMessageDelayed(GO_HOME, TIME);
        }else{
            mHandler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
            SharedPreferences.Editor editor = getSharedPreferences(FIRST_TAG, Activity.MODE_PRIVATE).edit();
            editor.putBoolean("isFirstIn", false);
            editor.commit();
        }
    }

    public void goHome(){
        Intent itent= new Intent();
        itent.setClass(getApplicationContext(), MainActivity.class);
        startActivity(itent);
        this.finish();
    }


    public void goGuide(){
        Intent itent= new Intent();
        itent.setClass(getApplicationContext(), GuideActivity.class);
        startActivity(itent);
        this.finish();
    }


    @Override
    public void initView() {
        AlphaAnimation aa=new AlphaAnimation(0f, 1.0f);
        aa.setDuration(500);
        iv_start.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //T.d(getApplicationContext(),"动画完成");
                initData();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
