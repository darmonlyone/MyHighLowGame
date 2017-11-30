/*
 * AdvertiseController class for controlling fxml file.
 * Random a Videos for opening as advertise.
 * Advertise videos on advertiseVideos package
 */
package myhilo;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.Timer;
import java.util.Random;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Duration;
import myhilo.FileLock;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AdvertiseController implements Initializable {
    @FXML
    private String filepath;
    @FXML
    private MediaPlayer mediaPlayer;
    @FXML
    public MediaView mediaView;
    @FXML
    public Button skipButt;
    long startTime = System.currentTimeMillis();
    private Random rd = new Random();
    static List<Integer> userMoney;
    static List<String> password;
    static List<String> userLogin;
    static List<Integer>userMoneyShow;
    static List<String> userLoginShow;
    static List<String> userLog;
    static int money = 0;
    private FileLock fileKeeps = new FileLock();
    
     public void setArrayList(){
       
        fileKeeps.setUPMlog();
        fileKeeps.setUPMAF();
        userLog = fileKeeps.getUserLog();
        userLogin = fileKeeps.getUserLogin();
        userMoney = fileKeeps.getUserMoney();
        userLoginShow = fileKeeps.getUserLoginShow();
        userMoneyShow = fileKeeps.getUserMoneyShow();
        password = fileKeeps.getPassword();
        
        money = userMoneyShow.get(0)+5000;
    }
    public void setSaveStatus(){
        
        PrintStream logSave = new PrintStream(fileKeeps.getOutputStreamUPM());
        
        for (int i = 0 ; i < userLogin.size() ; i++){
            if(userLoginShow.get(0).equals(userLogin.get(i))){
                userMoney.set(i,money);
            }
            logSave.printf("%s : %s : %s%n",userLogin.get(i),password.get(i),userMoney.get(i));
        }
        logSave.close();
    }
    
    public void skipper(){
         Stage stage = (Stage) skipButt.getScene().getWindow();
         fileKeeps.setAllListClear();
         mediaPlayer.pause();
         stage.close();
    }
    
    public String getAdvertise(int num){
        String str;
        if(num == 1) str = "Advertise_1.mp4";
        else if (num == 2 ) str = "Advertise_2.mp4";
        else if (num == 3 ) str = "Advertise_3.mp4";
        else return null;
        
        return "FileLoader/advertiseViedeos/"+str;
    }
    public void run(){
//         FileChooser fileChooser = new FileChooser();
//        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Please in put mp4", "*.mp4");
//        fileChooser.getExtensionFilters().add(filter);
        int randAdvertise = rd.nextInt(3)+1;
        skipButt.setVisible(false);
        File file = new File(getAdvertise(randAdvertise));
        filepath = file.toURI().toString();
            System.out.println(filepath);
        try {

        if (filepath != null ){
            Media media = new Media(filepath);
            skipButt.setVisible(true);
                   setArrayList();
                   setSaveStatus();
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            mediaView = new MediaView(mediaPlayer);
            mediaPlayer.getStartTime();
            mediaPlayer.play();
        }
               } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        run();
    }    
    
}
