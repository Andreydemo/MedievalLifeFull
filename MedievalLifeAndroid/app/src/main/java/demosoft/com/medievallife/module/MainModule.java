package demosoft.com.medievallife.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demosoft.com.medievallife.MainMenuActivity;
import demosoft.com.medievallife.SettingsActivity;
import demosoft.com.medievallife.component.DaggerMainComponent;
import demosoft.com.medievallife.controller.MainMenuController;
import demosoft.com.medievallife.controller.SettingsController;
import demosoft.com.medievallife.service.NavigationService;

/**
 * Created by demos_000 on 19.03.2016.
 */
@Module
public class MainModule {

    @Singleton
    @Provides
    MainMenuController getMainMenuController(MainMenuActivity activity) {
        MainMenuController mainMenuController = new MainMenuController(activity);
        activity.mainComponent.inject(mainMenuController);
        return mainMenuController;
    }

    @Singleton
    @Provides
    SettingsController getSettingsController(SettingsActivity settingsActivity) {
        SettingsController settingsController = new SettingsController(settingsActivity);
        MainMenuActivity.mainComponent.inject(settingsController);
        return settingsController;
    }

    @Singleton
    @Provides
    MainMenuActivity getActivity() {
        return MainMenuActivity.instance;
    }

    @Singleton
    @Provides
    SettingsActivity getSettingsActivity() {
        return SettingsActivity.instance;
    }

    @Singleton
    @Provides
    NavigationService getNavigationService() {
        return new NavigationService();
    }
}
