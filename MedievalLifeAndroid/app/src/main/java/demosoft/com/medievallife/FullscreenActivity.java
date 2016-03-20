package demosoft.com.medievallife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import javax.inject.Inject;

import demosoft.com.medievallife.component.DaggerMainComponent;
import demosoft.com.medievallife.component.MainComponent;
import demosoft.com.medievallife.controller.MainMenuController;

public class FullscreenActivity extends Activity {

    MainComponent mainComponent;
    public static FullscreenActivity instance;


    @Inject
    public MainMenuController mainMenuController;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFullscreenActivity();
    }

    private void initFullscreenActivity() {
        fullScreen();
        instance = this;
        mainComponent = DaggerMainComponent.create();
        mainComponent.inject(this);
    }

    private void fullScreen() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fullscreen);
    }


    public MainMenuController getMainMenuController() {
        return mainMenuController;
    }

    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
}
