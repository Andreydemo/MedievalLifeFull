package demosoft.com.medievallife.controller;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import demosoft.com.medievallife.R;
import demosoft.com.medievallife.SettingsActivity;
import demosoft.com.medievallife.service.ConnectionService;

/**
 * Created by Andrii_Korkoshko on 24.03.2016.
 */
public class SettingsController {

    private SettingsActivity settingsActivity;

    public SettingsController(SettingsActivity settingsActivity) {
        Log.i("MainMenuController", "Created," + settingsActivity);
        this.settingsActivity = settingsActivity;
        ButterKnife.bind(this, settingsActivity);
    }


    @OnClick(R.id.applySettings)
    public void applySettingsOnClick(View view) {
        EditText serverHost = (EditText) settingsActivity.findViewById(R.id.server_host);
        EditText serverPort = (EditText) settingsActivity.findViewById(R.id.server_port);
        ConnectionService.serverHost = serverHost.getText().toString();
        ConnectionService.serverPort = serverPort.getText().toString();
        Log.i("CONTROLLER", "Applied");
        InputMethodManager imm = (InputMethodManager) settingsActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        Toast.makeText(settingsActivity, "Applied", Toast.LENGTH_SHORT).show();

    }
}
