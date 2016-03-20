package demosoft.com.medievallife.component;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;
import demosoft.com.medievallife.FullscreenActivity;
import demosoft.com.medievallife.controller.MainMenuController;
import demosoft.com.medievallife.module.MainModule;

/**
 * Created by demos_000 on 19.03.2016.
 */
@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(FullscreenActivity activity);
    void inject(MainMenuController mainMenuController);

}
