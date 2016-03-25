package demosoft.com.medievallife;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import javax.inject.Inject;

import demosoft.com.medievallife.component.DaggerMainComponent;
import demosoft.com.medievallife.component.MainComponent;
import demosoft.com.medievallife.controller.MainMenuController;
import demosoft.com.medievallife.controller.SettingsController;
import demosoft.com.medievallife.service.ConnectionService;
import demosoft.com.medievallife.service.NavigationService;

public class SettingsActivity extends AppCompatActivity {

    public static SettingsActivity instance;
    private int currentContentViewId;


    @Inject
    public SettingsController settingsController;

    @Inject
    public NavigationService navigationService;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.i("SETTING", "CREATE");
        super.onCreate(savedInstanceState);
        initFullscreenActivity();

        EditText serverHost = (EditText) findViewById(R.id.server_host);
        serverHost.setText(ConnectionService.serverHost);
        EditText serverPort = (EditText) findViewById(R.id.server_port);
        serverPort.setText(ConnectionService.serverPort);
    }

    private void initFullscreenActivity() {
        fullScreen();
        instance = this;
        MainMenuActivity.mainComponent.inject(this);
        Log.i("SETTINGs", settingsController.toString());
    }

    @Override
    public void onBackPressed() {
        Log.i("SETTING", "BACK");
        //  moveTaskToBack(true);
        navigationService.backToPreviousPage(this);
    }

    private void fullScreen() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.settings);
    }


    @Override
    public void setContentView(int layoutResID) {
        currentContentViewId = layoutResID;
        super.setContentView(layoutResID);
    }

    public int getCurrentContentViewId() {
        return currentContentViewId;
    }

    public void setCurrentContentViewId(int currentContentViewId) {
        this.currentContentViewId = currentContentViewId;
    }
}
