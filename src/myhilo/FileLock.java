/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhilo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Manusporn Fukkham
 */
public class FileLock {
    
     
    private String newFile = "FileLoader/newfile.log";
    private String usernamepassword = "FileLoader/usernamepassword.log";
    private  List<String> username = new ArrayList<>();
    private  List<String> password = new ArrayList<>();
    private  List<Integer> userMoney = new ArrayList<>();
    private  List<String> userLog = new ArrayList<>();
    private  List<String> userLogin = new ArrayList<>();
    private  List<Integer> userMoneyShow = new ArrayList<>();
    private  List<String> userLoginShow = new ArrayList<>();   
   
    public void setAllListClear(){
        this.userLogin.clear();
        this.userLoginShow.clear();
        this.userMoney.clear();
        this.userMoneyShow.clear();
        this.username.clear();
        this.userLog.clear();
        this.password.clear();
        
    }
     public void setUPMAF(){
          try {
         File theFile1 = new File(usernamepassword);
         Scanner fileScanner = new Scanner(theFile1);
          while(fileScanner.hasNextLine()){
                String[] menu = fileScanner.nextLine().replaceAll(" : ","  ").split("  ");
                if(!menu[0].equals("##")) {
                    userLogin.add(menu[0]);
                     password.add(menu[1]);
                    userMoney.add(Integer.parseInt(menu[2]));
                }
                if(menu[0].equals(userLog.get(0))){
                    userMoneyShow.add(Integer.parseInt(menu[2]));
                    userLoginShow.add(menu[0]);
                }
          }
         } catch(FileNotFoundException e) {
            System.out.print(e);
         }
         
     }
    public void setUPM(){
         try {
            File theFile = new File(usernamepassword);
            Scanner fileScanner = new Scanner(theFile);
            while(fileScanner.hasNextLine()){
                String[] menu = fileScanner.nextLine().replaceAll(" : ","  ").split("  ");
                if(!menu[0].equals("##")) {
             username.add(menu[0]);
             password.add(menu[1]);
             userMoney.add(Integer.parseInt(menu[2]));
           }
            }
               

        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
         
    }
     public void setUPMlog(){
         try {
            File theFile = new File(newFile);
            Scanner fileScanner = new Scanner(theFile);
            while(fileScanner.hasNextLine()){
                String[] menu = fileScanner.nextLine().replaceAll(" : ","  ").split("  ");
                if(!menu[0].equals("##")) {
             userLog.add(menu[0]);
              }
            }
               

        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
     }
    public OutputStream getOutputStreamNewFile(){
        String logFilePath = newFile;
        OutputStream os = null;
        try {
            os = new FileOutputStream(logFilePath);
            return os;
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't open output file " + logFilePath);
            return null;
        }
    }
    public OutputStream getOutputStreamUPM(){
        String logFilePath = usernamepassword;
        OutputStream os = null;
        try {
            os = new FileOutputStream(logFilePath);
            return os;
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't open output file " + logFilePath);
            return null;
        }
    }

    public  List<String> getPassword() {
        return password;
    }

    public  List<Integer> getUserMoney() {
        return userMoney;
    }

    public  List<String> getUsername() {
        return username;
    }

    public  List<String> getUserLog() {
        return userLog;
    }

    public  List<String> getUserLoginShow() {
        return userLoginShow;
    }

    public  List<Integer> getUserMoneyShow() {
        return userMoneyShow;
    }

    public List<String> getUserLogin() {
        return userLogin;
    }
    
    
}
