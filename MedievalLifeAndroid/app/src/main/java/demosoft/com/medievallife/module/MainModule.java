package demosoft.com.medievallife.module;

import android.app.Activity;
import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demosoft.com.medievallife.FullscreenActivity;
import demosoft.com.medievallife.component.DaggerMainComponent;
import demosoft.com.medievallife.controller.MainMenuController;
import demosoft.com.medievallife.service.NavigationService;

/**
 * Created by demos_000 on 19.03.2016.
 */
@Module
public class MainModule {

    @Singleton
    @Provides
    MainMenuController getMainMenuController(FullscreenActivity activity) {
        MainMenuController mainMenuController = new MainMenuController(activity);
        activity.mainComponent.inject(mainMenuController);
        return mainMenuController;
    }

    @Singleton
    @Provides
    FullscreenActivity getActivity() {
        return FullscreenActivity.instance;
    }

    @Singleton
    @Provides
    NavigationService getNavigationService() {
        return new NavigationService();
    }
}
