package demosoft.com.medievallife.module;

import android.app.Activity;
import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demosoft.com.medievallife.FullscreenActivity;
import demosoft.com.medievallife.controller.MainMenuController;

/**
 * Created by demos_000 on 19.03.2016.
 */
@Module
public class MainModule {

    @Singleton @Provides
    MainMenuController getMainMenuController(FullscreenActivity activity){
        Log.i("->>>>>>>","getMainMenuController(Activity activity)"+activity + " " + new MainMenuController(activity));
        return new MainMenuController(activity);
    }

    @Singleton @Provides
    FullscreenActivity getActivity(){
        Log.i("->>>>>>>","getActivity()"+FullscreenActivity.instance);
        return FullscreenActivity.instance;
    }
}
