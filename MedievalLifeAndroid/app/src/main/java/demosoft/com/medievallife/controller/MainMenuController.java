package demosoft.com.medievallife.controller;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import dagger.Module;
import dagger.Provides;
import demosoft.com.medievallife.FullscreenActivity;
import demosoft.com.medievallife.R;

/**
 * Created by Andrii Korkoshko on 19.03.2016.
 */

public class MainMenuController {


    Activity activity;


     public MainMenuController(FullscreenActivity activity) {
        Log.i("MainMenuController", "Created,"+activity);
        this.activity = activity;
         ButterKnife.bind(this,activity);
    }


    @OnTouch(R.id.sword_button_resume)
    public boolean sword_button_resumeOnTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            v.setBackground(activity.getResources().getDrawable(R.drawable.sword_clicked));


        } else if (event.getAction() == MotionEvent.ACTION_UP) {

            v.setBackground(activity.getResources().getDrawable(R.drawable.sword_default));
        }
        return false;
    }
    @OnTouch(R.id.sword_button_reg)
    public boolean sword_button_regOnTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            v.setBackground(activity.getResources().getDrawable(R.drawable.sword_clicked));


        } else if (event.getAction() == MotionEvent.ACTION_UP) {

            v.setBackground(activity.getResources().getDrawable(R.drawable.sword_default));
        }
        return false;
    }
    @OnClick(R.id.sword_button_reg)
    public void sword_button_regOnClick(View v) {
        activity.setContentView(R.layout.registration);
    }
    @OnTouch(R.id.sword_button_exist)
    public boolean sword_button_existOnTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            v.setBackground(activity.getResources().getDrawable(R.drawable.sword_clicked));


        } else if (event.getAction() == MotionEvent.ACTION_UP) {

            v.setBackground(activity.getResources().getDrawable(R.drawable.sword_default));
        }
        return false;
    }
}
