package com.example.fahid.demosplash;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Image_slider extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);
        viewPager= (ViewPager) findViewById(R.id.pager);
        Pager_adapter pagerAdapter=new Pager_adapter(this);
        viewPager.setAdapter(pagerAdapter);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new Task(),3000,4000);
    }

    public class Task extends TimerTask{

        @Override
        public void run() {
            Image_slider.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }else if (viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }else {viewPager.setCurrentItem(0);}

                }
            });
        }
    }
}
