package demosoft.com.medievallife;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import javax.inject.Inject;

import demosoft.com.medievallife.component.DaggerMainComponent;
import demosoft.com.medievallife.component.MainComponent;
import demosoft.com.medievallife.controller.MainMenuController;
import demosoft.com.medievallife.service.NavigationService;

public class MainMenuActivity extends AppCompatActivity {

    public static MainComponent mainComponent;
    public static MainMenuActivity instance;
    private int currentContentViewId;


    @Inject
    public MainMenuController mainMenuController;

    @Inject
    public NavigationService navigationService;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.i("MAIN", "CREATE");
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
        Log.i("MAIN", "BACK");
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
