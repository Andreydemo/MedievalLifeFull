package demosoft.com.medievallife.component;

import javax.inject.Singleton;

import dagger.Component;
import demosoft.com.medievallife.MainMenuActivity;
import demosoft.com.medievallife.SettingsActivity;
import demosoft.com.medievallife.controller.MainMenuController;
import demosoft.com.medievallife.controller.SettingsController;
import demosoft.com.medievallife.module.MainModule;

/**
 * Created by demos_000 on 19.03.2016.
 */
@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainMenuActivity activity);
    void inject(MainMenuController mainMenuController);
    void inject(SettingsActivity mainMenuController);
    void inject(SettingsController mainMenuController);

}
