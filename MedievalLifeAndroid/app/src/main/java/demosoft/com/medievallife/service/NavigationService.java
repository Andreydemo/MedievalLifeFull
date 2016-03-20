package demosoft.com.medievallife.service;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;

import java.util.Stack;

import demosoft.com.medievallife.FullscreenActivity;

/**
 * Created by demos_000 on 20.03.2016.
 */
public class NavigationService {

    private Stack<Integer> pageCallStack = new Stack<>();

    public NavigationService() {
        Log.i("NavigationService", "created");
    }

    public void openPage(int pageId, FullscreenActivity activity) {
        pageCallStack.push(activity.getCurrentContentViewId());
        activity.setContentView(pageId);
    }

    public void backToPreviousPage(FullscreenActivity activity) {
        if (!pageCallStack.isEmpty()) {
            activity.setContentView(pageCallStack.pop());
        }
    }
}
