package demosoft.com.medievallife.controller;

import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import demosoft.com.medievallife.FullscreenActivity;
import demosoft.com.medievallife.R;
import demosoft.com.medievallife.service.ConnectionService;
import demosoft.com.medievallife.service.NavigationService;

/**
 * Created by Andrii Korkoshko on 19.03.2016.
 */

public class MainMenuController {


    FullscreenActivity activity;

    @Inject
    public NavigationService navigationService;


    public MainMenuController(FullscreenActivity activity) {
        Log.i("MainMenuController", "Created," + activity);
        this.activity = activity;
        ButterKnife.bind(this, activity);
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
        //activity.setContentView(R.layout.registration);
        navigationService.openPage(R.layout.registration,activity);
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

    @OnTouch(R.id.sword_button_settings)
    public boolean sword_button_settingsOnTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            v.setBackground(activity.getResources().getDrawable(R.drawable.sword_clicked));


        } else if (event.getAction() == MotionEvent.ACTION_UP) {

            v.setBackground(activity.getResources().getDrawable(R.drawable.sword_default));
        }
        return false;
    }

    @OnClick(R.id.sword_button_resume)
    public void sword_button_resumeOnClick(View v) {
        new ConnectionService().testConnection();
    }

    @OnClick(R.id.sword_button_settings)
    public void sword_button_settingsOnClick(View v) {
       // activity.setContentView(R.layout.settings);
        navigationService.openPage(R.layout.settings, activity);
        EditText serverHost = (EditText) activity.findViewById(R.id.server_host);
        serverHost.setText(ConnectionService.serverHost);
        EditText serverPort = (EditText) activity.findViewById(R.id.server_port);
        serverPort.setText(ConnectionService.serverPort);
    }
}
