package demosoft.com.medievallife.service;


/**
 * Created by demos_000 on 20.03.2016.
 */
public class ConnectionService {
    public static String serverHost = "192.168.0.2";
    public static String serverPort = "8080";


    public boolean testConnection() {
        new TestConnectionAsyncTask(serverHost, serverPort).execute();

        return false;
    }

}
