package demosoft.com.medievallife;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import javax.inject.Inject;

import demosoft.com.medievallife.component.DaggerMainComponent;
import demosoft.com.medievallife.component.MainComponent;
import demosoft.com.medievallife.controller.MainMenuController;
import demosoft.com.medievallife.service.NavigationService;

public class FullscreenActivity extends Activity {

    public MainComponent mainComponent;
    public static FullscreenActivity instance;
    private int currentContentViewId;


    @Inject
    public MainMenuController mainMenuController;

    @Inject
    public NavigationService navigationService;



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

    @Override
    public void onBackPressed() {
      //  moveTaskToBack(true);
        navigationService.backToPreviousPage(this);
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
