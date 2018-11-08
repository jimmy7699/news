package pkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class FirebaseInitialize implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {

        ServletContext sc = event.getServletContext();
        String filePath = sc.getInitParameter("filePath");//從web.xml取得檔案粗略位置
        filePath = sc.getRealPath(filePath);//取得完整路徑

        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream(filePath);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://myfirebaseproject-aeb02.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(FirebaseInitialize.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(FirebaseInitialize.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}//FirebaseInitialize結尾