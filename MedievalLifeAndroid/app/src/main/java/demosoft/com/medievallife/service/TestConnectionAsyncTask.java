package demosoft.com.medievallife.service;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by demos_000 on 20.03.2016.
 */
public class TestConnectionAsyncTask extends AsyncTask<String, Void, NetworkResult> {
    public TestConnectionAsyncTask(String serverHost, String serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    private String serverHost;
    private String serverPort;

    @Override
    protected NetworkResult doInBackground(String... params) {
        BufferedReader reader = null;
        try {
            URL uri = new URL("http://" + serverHost + ":" + serverPort);

            HttpURLConnection c = (HttpURLConnection) uri.openConnection();
            c.setRequestMethod("GET");
            c.setReadTimeout(10000);
            c.connect();
            reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
            StringBuilder buf = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                buf.append(line + "\n");
            }
            Log.i("HTTPCLIENT", buf.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
