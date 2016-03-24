package demosoft.com.medievallife.service;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import java.util.Stack;

import demosoft.com.medievallife.MainMenuActivity;

/**
 * Created by demos_000 on 20.03.2016.
 */
public class NavigationService {

    private Stack<Activity> pageCallStack = new Stack<>();

    public NavigationService() {
        Log.i("NavigationService", "created");
    }

    public void openPage(Class<?> targetActivity, MainMenuActivity sourceActivity) {
        pageCallStack.push(sourceActivity);
        sourceActivity.startActivity(new Intent(sourceActivity, targetActivity));
    }

    public void backToPreviousPage(Activity sourceActivity) {
        if (!pageCallStack.isEmpty()) {
            Activity activity = pageCallStack.pop();
            sourceActivity.startActivity(new Intent(sourceActivity, activity.getClass()));
        }
    }
}
