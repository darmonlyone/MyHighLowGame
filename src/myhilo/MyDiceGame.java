/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhilo;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.List;

/**
 * This class use for playing Dice game which will record 
 * your money everytime you finished a game.
 * 
 * @author Manusporn Fukkham
 */
     

public class MyDiceGame extends JFrame {
    
    private static List<Integer> userMoney;
    private static List<String> password;
    private static List<String> userLogin;
    private static List<Integer> userMoneyShow;
    private static List<String> userLoginShow;
    private static List<String> userLog;
    private int i = 250; 
    private int j = 430;
    private Timer tm1;
    private Timer tm2;
    
    FileSet file = new FileSet();
    public void setArrayList(){
        file.setUPMlog();
        file.setUPMAF();
        userLog = file.getUserLog();
        userLogin = file.getUserLogin();
        userMoney = file.getUserMoney();
        userLoginShow = file.getUserLoginShow();
        userMoneyShow = file.getUserMoneyShow();
        password = file.getPassword();
        String mn = Integer.toString(userMoneyShow.get(0));
        moneyString.setText(mn);
        usShow.setText(userLoginShow.get(0));
        money = userMoneyShow.get(0);
    }
    
    public void setSaveStatus(){
        PrintStream logSave = new PrintStream(file.getOutputStreamUPM());
        
        for (int i = 0 ; i < userLogin.size() ; i++){
            if(userLoginShow.get(0).equals(userLogin.get(i))){
                userMoney.set(i,money);
            }
            logSave.printf("%s : %s : %d%n",userLogin.get(i),password.get(i),userMoney.get(i));
        }
        logSave.close();
    }
    
    static Random rd = new Random();
    static int rollA,rollB,rollC,roll;
    static GetDiceCorrect hilo = new GetDiceCorrect();
    
    static StartForm user = new StartForm();
    
    static int money = 1000;
    static boolean check;
    static int bet,gotBet;
    
    int betMoney = 0;
    String setBetMoney = " ";
      public void setMoney(){
          String mn = Integer.toString(money);
          moneyString.setText(mn);
          
      }
      public void setRoll(){
          String rollS = Integer.toString(roll);
          totalBox.setText(rollS);
      }
          
       public void diceRolling(){
        rollA = rd.nextInt(6)+1;
        rollB = rd.nextInt(6)+1;
        rollC = rd.nextInt(6)+1;
//        check triple
//        rollA = 1; rollB = 1; rollC=1;
        roll = rollA+rollB+rollC;
    }
       public void betTime(){
           bet = betMoney;
           gotBet = timeToGot();
           if (!null1.isSelected() && !null2.isSelected()){
               if(check){
                   loseWin.setForeground(Color.GREEN);
                   loseWin.setText("YOU WIN!");
                   loseWinBar.setForeground(Color.BLACK);
                   loseWinBar.setText("You win money");
                   howMuchLostWin.setForeground(Color.GREEN);
                   howMuchLostWin.setText(Integer.toString(bet*gotBet) +" Bath.");
                   money += bet*gotBet;
               }else{
                   loseWin.setForeground(Color.RED);
                   loseWin.setText("YOU LOSE!");
                   loseWinBar.setForeground(Color.BLACK);
                   loseWinBar.setText("You lose money");
                   howMuchLostWin.setForeground(Color.RED);
                   howMuchLostWin.setText(Integer.toString(bet)+" Bath.");
                   money -= bet;
               }
           } 
           if(money<=0){
               money = 100;
               betMoney=0;
               setBetMoney = Integer.toString(betMoney);
               whatSelectShip.setText(setBetMoney+" BATH");
               new Alert("FreeMoney").setVisible(true);
           }
           if(betMoney > money){
           betMoney = money;
           setBetMoney = Integer.toString(betMoney);
           whatSelectShip.setText(setBetMoney+" BATH");
           }
           setMoney();
           setSaveStatus();
       }
       
       public int timeToGot(){
           if(oneOrfiveselect.isSelected()){
            return 2;
         }if(fivelowselect.isSelected()){
             return 3;
         }if(elevenHiLowselect.isSelected()){
             return 3;
         }if(sixlowselect.isSelected()){
            return 3;
         }if(sixOrtwoselect.isSelected()){
             return 2;
         }if(oneOrsixselect.isSelected() || sixOroneselect.isSelected()){
             return 2;
         }if(oneselect.isSelected()){
             return 1;
         }if(lowselect.isSelected()){
             return 1;
         }if(highselect.isSelected()){
             return 1;
         }if(sixselect.isSelected()){
             return 1;
         }if(twoOrfiveselect.isSelected() || fiveOrtwoselect.isSelected()){
            return 2;
         }if(twoselect.isSelected()){
             return 1;
         }if(threeselect.isSelected()){
             return 1;
         }if(fourselect.isSelected()){
             return 1;
         }if(fiveselect.isSelected()){
             return 1;
         }if(onetwothreeselect.isSelected()){
             return 5;
         }if(threeOrsixselect.isSelected()){
             return 2;
         }if(twoOrfourselect.isSelected()){
             return 2;
         }if(threeOrfiveselect.isSelected()){
             return 2;
         }if(fourOroneselect.isSelected()){
             return 2;
         }if(fourfivesixselect.isSelected()){
             return 5;
         }
         return 0;
       }
     public void whatSelected(){
         if(rollA == rollB && rollA == rollC && rollB == rollC){
             check = false;
         }else{
         if(oneOrfiveselect.isSelected()){
            check = hilo.is1and5(rollA, rollB, rollC);
         }if(fivelowselect.isSelected()){
             check = hilo.is5lo(rollA, rollB, rollC, roll);
         }if(elevenHiLowselect.isSelected()){
             check = hilo.is11hilo(roll);
         }if(sixlowselect.isSelected()){
             check = hilo.is6lo(rollA, rollB, rollC, roll);
         }if(sixOrtwoselect.isSelected()){
             check = hilo.is6and2(rollA, rollB, rollC);
         }if(oneOrsixselect.isSelected() || sixOroneselect.isSelected()){
             check = hilo.is1and6(rollA, rollB, rollC);
         }if(oneselect.isSelected()){
             check = hilo.isFace1(rollA, rollB, rollC);
         }if(lowselect.isSelected()){
             check = hilo.isLow(roll);
         }if(highselect.isSelected()){
             check = hilo.isHigh(roll);
         }if(sixselect.isSelected()){
             check = hilo.isFace6(rollA, rollB, rollC);
         }if(twoOrfiveselect.isSelected() || fiveOrtwoselect.isSelected()){
             check = hilo.is2and5(rollA, rollB, rollC);
         }if(twoselect.isSelected()){
             check = hilo.isFace2(rollA, rollB, rollC);
         }if(threeselect.isSelected()){
             check = hilo.isFace3(rollA, rollB, rollC);
         }if(fourselect.isSelected()){
             check = hilo.isFace4(rollA, rollB, rollC);
         }if(fiveselect.isSelected()){
             check = hilo.isFace5(rollA, rollB, rollC);
         }if(onetwothreeselect.isSelected()){
             check = hilo.is123(rollA, rollB, rollC);
         }if(threeOrsixselect.isSelected()){
             check = hilo.is3and6(rollA, rollB, rollC);
         }if(twoOrfourselect.isSelected()){
             check = hilo.is2and4(rollA, rollB, rollC);
         }if(threeOrfiveselect.isSelected()){
             check = hilo.is3and5(rollA, rollB, rollC);
         }if(fourOroneselect.isSelected()){
             check = hilo.is4and1(rollA, rollB, rollC);
         }if(fourfivesixselect.isSelected()){
             check = hilo.is456(rollA, rollB, rollC);
         }
         }
     } 
    public void rollDice(){
        GetPNG show = new GetPNG();
             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource(show.getImageRollBig(rollA))));
             dice1.setIcon(new ImageIcon(getClass().getResource(show.getImageRollSmall(rollA))));
        
             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource(show.getImageRollBig(rollB))));
             dice2.setIcon(new ImageIcon(getClass().getResource(show.getImageRollSmall(rollB))));
       
             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource(show.getImageRollBig(rollC))));
             dice3.setIcon(new ImageIcon(getClass().getResource(show.getImageRollSmall(rollC))));
        setRoll();
    }
    public void setWindow(){
        setBackground(Color.LIGHT_GRAY);
        setSize(1024, 726);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }
    public MyDiceGame() {
        setWindow();
        setMoney();
        setArrayList();
       null1.setSelected(rootPaneCheckingEnabled);
       null2.setSelected(rootPaneCheckingEnabled);
        
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        HiLoSelect = new javax.swing.ButtonGroup();
        shipselect = new javax.swing.ButtonGroup();
        moneyString = new javax.swing.JTextField();
        moneyPic = new javax.swing.JLabel();
        usShow = new javax.swing.JTextField();
        six = new javax.swing.JLabel();
        cover = new javax.swing.JLabel();
        dice1 = new javax.swing.JLabel();
        dice2 = new javax.swing.JLabel();
        dice3 = new javax.swing.JLabel();
        rollBut = new javax.swing.JButton();
        diceShow3 = new javax.swing.JLabel();
        diceShow2 = new javax.swing.JLabel();
        diceShow1 = new javax.swing.JLabel();
        resetButt = new javax.swing.JButton();
        ship20 = new javax.swing.JLabel();
        ship50 = new javax.swing.JLabel();
        ship100 = new javax.swing.JLabel();
        ship200 = new javax.swing.JLabel();
        ship10 = new javax.swing.JLabel();
        elevenHiLo = new javax.swing.JLabel();
        fivelow = new javax.swing.JLabel();
        sixlow = new javax.swing.JLabel();
        threeOrsix = new javax.swing.JLabel();
        high = new javax.swing.JLabel();
        low = new javax.swing.JLabel();
        one = new javax.swing.JLabel();
        oneOrsix = new javax.swing.JLabel();
        fiveOrtwo = new javax.swing.JLabel();
        two = new javax.swing.JLabel();
        five = new javax.swing.JLabel();
        three = new javax.swing.JLabel();
        four = new javax.swing.JLabel();
        twoOrfive = new javax.swing.JLabel();
        oneORfive = new javax.swing.JLabel();
        onetwothree = new javax.swing.JLabel();
        fourfivesix = new javax.swing.JLabel();
        fourOrone = new javax.swing.JLabel();
        threeOrfive = new javax.swing.JLabel();
        twoOrfour = new javax.swing.JLabel();
        sixOrone = new javax.swing.JLabel();
        sixOrtwo = new javax.swing.JLabel();
        oneORfive21 = new javax.swing.JLabel();
        hiloPlane = new javax.swing.JLabel();
        plate = new javax.swing.JLabel();
        totalText = new javax.swing.JTextField();
        totalBox = new javax.swing.JTextField();
        whatSelectBet = new javax.swing.JTextField();
        whatSelectShip = new javax.swing.JTextField();
        betText = new javax.swing.JTextField();
        betText1 = new javax.swing.JTextField();
        loseWin = new javax.swing.JTextField();
        howMuchLostWin = new javax.swing.JTextField();
        loseWinBar = new javax.swing.JTextField();
        what = new javax.swing.JTextField();
        backButt = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        oneOrfiveselect = new javax.swing.JRadioButton();
        fivelowselect = new javax.swing.JRadioButton();
        elevenHiLowselect = new javax.swing.JRadioButton();
        sixlowselect = new javax.swing.JRadioButton();
        sixOrtwoselect = new javax.swing.JRadioButton();
        oneOrsixselect = new javax.swing.JRadioButton();
        oneselect = new javax.swing.JRadioButton();
        lowselect = new javax.swing.JRadioButton();
        highselect = new javax.swing.JRadioButton();
        sixselect = new javax.swing.JRadioButton();
        sixOroneselect = new javax.swing.JRadioButton();
        twoOrfiveselect = new javax.swing.JRadioButton();
        twoselect = new javax.swing.JRadioButton();
        threeselect = new javax.swing.JRadioButton();
        fourselect = new javax.swing.JRadioButton();
        fiveselect = new javax.swing.JRadioButton();
        fiveOrtwoselect = new javax.swing.JRadioButton();
        onetwothreeselect = new javax.swing.JRadioButton();
        threeOrsixselect = new javax.swing.JRadioButton();
        twoOrfourselect = new javax.swing.JRadioButton();
        threeOrfiveselect = new javax.swing.JRadioButton();
        fourOroneselect = new javax.swing.JRadioButton();
        fourfivesixselect = new javax.swing.JRadioButton();
        null1 = new javax.swing.JRadioButton();
        null2 = new javax.swing.JRadioButton();
        ship200select = new javax.swing.JRadioButton();
        ship100select = new javax.swing.JRadioButton();
        ship50select = new javax.swing.JRadioButton();
        ship20select = new javax.swing.JRadioButton();
        ship10select = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        moneyString.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        moneyString.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        moneyString.setText("Money");
        moneyString.setAutoscrolls(false);
        moneyString.setBorder(null);
        moneyString.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        moneyString.setFocusable(false);
        moneyString.setRequestFocusEnabled(false);
        getContentPane().add(moneyString, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 100, 30));

        moneyPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/money.png"))); // NOI18N
        getContentPane().add(moneyPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 50));

        usShow.setBackground(new java.awt.Color(86, 57, 57));
        usShow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usShow.setForeground(new java.awt.Color(255, 51, 51));
        usShow.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usShow.setText("Username");
        usShow.setBorder(null);
        usShow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usShow.setFocusable(false);
        usShow.setOpaque(false);
        getContentPane().add(usShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 40));

        six.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        six.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sixMouseClicked(evt);
            }
        });
        getContentPane().add(six, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 100, 90));

        cover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/cover.png"))); // NOI18N
        getContentPane().add(cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        dice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/dice1.png"))); // NOI18N
        getContentPane().add(dice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 100, 20, -1));

        dice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/dice1.png"))); // NOI18N
        getContentPane().add(dice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        dice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/dice1.png"))); // NOI18N
        getContentPane().add(dice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        rollBut.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        rollBut.setText("Roll");
        rollBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rollBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollButActionPerformed(evt);
            }
        });
        getContentPane().add(rollBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, 90));

        diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/rolll.png"))); // NOI18N
        getContentPane().add(diceShow3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 80, -1, -1));

        diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/rolll.png"))); // NOI18N
        getContentPane().add(diceShow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, -1, -1));

        diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/rolll.png"))); // NOI18N
        getContentPane().add(diceShow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        resetButt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        resetButt.setText("Reset");
        resetButt.setToolTipText("");
        resetButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtActionPerformed(evt);
            }
        });
        getContentPane().add(resetButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 640, 120, 70));

        ship20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/ship20.png"))); // NOI18N
        ship20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ship20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ship20MouseClicked(evt);
            }
        });
        getContentPane().add(ship20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, -1, -1));

        ship50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/ship50.png"))); // NOI18N
        ship50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ship50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ship50MouseClicked(evt);
            }
        });
        getContentPane().add(ship50, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, -1, -1));

        ship100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/ship100.png"))); // NOI18N
        ship100.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ship100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ship100MouseClicked(evt);
            }
        });
        getContentPane().add(ship100, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 650, -1, -1));

        ship200.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/ship200.png"))); // NOI18N
        ship200.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ship200.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ship200MouseClicked(evt);
            }
        });
        getContentPane().add(ship200, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 650, -1, -1));

        ship10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/ship10.png"))); // NOI18N
        ship10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ship10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ship10MouseClicked(evt);
            }
        });
        getContentPane().add(ship10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, -1, -1));

        elevenHiLo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        elevenHiLo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elevenHiLoMouseClicked(evt);
            }
        });
        getContentPane().add(elevenHiLo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 200, 90));

        fivelow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fivelow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fivelowMouseClicked(evt);
            }
        });
        getContentPane().add(fivelow, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 100, 90));

        sixlow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sixlow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sixlowMouseClicked(evt);
            }
        });
        getContentPane().add(sixlow, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 90, 90));

        threeOrsix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        threeOrsix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                threeOrsixMouseClicked(evt);
            }
        });
        getContentPane().add(threeOrsix, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 100, 100));

        high.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        high.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                highMouseClicked(evt);
            }
        });
        getContentPane().add(high, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 90, 90));

        low.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        low.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lowMouseClicked(evt);
            }
        });
        getContentPane().add(low, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 100, 90));

        one.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        one.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneMouseClicked(evt);
            }
        });
        getContentPane().add(one, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 100, 90));

        oneOrsix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oneOrsix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneOrsixMouseClicked(evt);
            }
        });
        getContentPane().add(oneOrsix, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 100, 90));

        fiveOrtwo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fiveOrtwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fiveOrtwoMouseClicked(evt);
            }
        });
        getContentPane().add(fiveOrtwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, 100, 100));

        two.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        two.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                twoMouseClicked(evt);
            }
        });
        getContentPane().add(two, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 100, 100));

        five.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        five.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fiveMouseClicked(evt);
            }
        });
        getContentPane().add(five, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 100, 100));

        three.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        three.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                threeMouseClicked(evt);
            }
        });
        getContentPane().add(three, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 100, 100));

        four.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        four.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fourMouseClicked(evt);
            }
        });
        getContentPane().add(four, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 90, 100));

        twoOrfive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        twoOrfive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                twoOrfiveMouseClicked(evt);
            }
        });
        getContentPane().add(twoOrfive, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 100, 100));

        oneORfive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oneORfive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneORfiveMouseClicked(evt);
            }
        });
        getContentPane().add(oneORfive, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 100, 90));

        onetwothree.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        onetwothree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onetwothreeMouseClicked(evt);
            }
        });
        getContentPane().add(onetwothree, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 100, 100));

        fourfivesix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fourfivesix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fourfivesixMouseClicked(evt);
            }
        });
        getContentPane().add(fourfivesix, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 520, 100, 100));

        fourOrone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fourOrone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fourOroneMouseClicked(evt);
            }
        });
        getContentPane().add(fourOrone, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 520, 100, 100));

        threeOrfive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        threeOrfive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                threeOrfiveMouseClicked(evt);
            }
        });
        getContentPane().add(threeOrfive, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 110, 100));

        twoOrfour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        twoOrfour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                twoOrfourMouseClicked(evt);
            }
        });
        getContentPane().add(twoOrfour, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 100, 100));

        sixOrone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sixOrone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sixOroneMouseClicked(evt);
            }
        });
        getContentPane().add(sixOrone, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 100, 90));

        sixOrtwo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sixOrtwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sixOrtwoMouseClicked(evt);
            }
        });
        getContentPane().add(sixOrtwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 100, 90));

        oneORfive21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneORfive21MouseClicked(evt);
            }
        });
        getContentPane().add(oneORfive21, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 80, 70));

        hiloPlane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/hilo.png"))); // NOI18N
        hiloPlane.setText("jLabel1");
        getContentPane().add(hiloPlane, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 650, 420));

        plate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/plate.png"))); // NOI18N
        getContentPane().add(plate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, -1));

        totalText.setBackground(new java.awt.Color(86, 57, 57));
        totalText.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        totalText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalText.setText("Totals");
        totalText.setBorder(null);
        totalText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        totalText.setFocusable(false);
        totalText.setOpaque(false);
        getContentPane().add(totalText, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, 160, 50));

        totalBox.setBackground(new java.awt.Color(86, 57, 57));
        totalBox.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        totalBox.setForeground(new java.awt.Color(255, 0, 0));
        totalBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalBox.setText("0");
        totalBox.setBorder(null);
        totalBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        totalBox.setFocusable(false);
        totalBox.setOpaque(false);
        getContentPane().add(totalBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 100, 50));

        whatSelectBet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        whatSelectBet.setForeground(new java.awt.Color(204, 204, 204));
        whatSelectBet.setText("bet selected");
        whatSelectBet.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        whatSelectBet.setFocusable(false);
        getContentPane().add(whatSelectBet, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 110, 40));

        whatSelectShip.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        whatSelectShip.setForeground(new java.awt.Color(204, 204, 204));
        whatSelectShip.setText("Ship selected");
        whatSelectShip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        whatSelectShip.setFocusable(false);
        getContentPane().add(whatSelectShip, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 390, 110, 30));

        betText.setBackground(new java.awt.Color(86, 57, 57));
        betText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        betText.setText("Bet :");
        betText.setBorder(null);
        betText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        betText.setFocusable(false);
        getContentPane().add(betText, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, 70, 40));

        betText1.setBackground(new java.awt.Color(86, 57, 57));
        betText1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        betText1.setText("Ship :");
        betText1.setBorder(null);
        betText1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        betText1.setFocusable(false);
        getContentPane().add(betText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 70, 30));

        loseWin.setBackground(new java.awt.Color(86, 57, 57));
        loseWin.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        loseWin.setForeground(new java.awt.Color(86, 57, 57));
        loseWin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loseWin.setText("YOU LOSE!");
        loseWin.setToolTipText("");
        loseWin.setBorder(null);
        loseWin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loseWin.setFocusable(false);
        loseWin.setOpaque(false);
        getContentPane().add(loseWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, 190, -1));

        howMuchLostWin.setBackground(new java.awt.Color(86, 57, 57));
        howMuchLostWin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        howMuchLostWin.setForeground(new java.awt.Color(86, 57, 57));
        howMuchLostWin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        howMuchLostWin.setText("1000 bath.");
        howMuchLostWin.setBorder(null);
        howMuchLostWin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        howMuchLostWin.setFocusable(false);
        howMuchLostWin.setOpaque(false);
        getContentPane().add(howMuchLostWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 170, -1));

        loseWinBar.setBackground(new java.awt.Color(86, 57, 57));
        loseWinBar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loseWinBar.setForeground(new java.awt.Color(86, 57, 57));
        loseWinBar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loseWinBar.setText("YOU LOST MONEY:");
        loseWinBar.setBorder(null);
        loseWinBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loseWinBar.setFocusable(false);
        loseWinBar.setOpaque(false);
        getContentPane().add(loseWinBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, 170, -1));

        what.setBackground(new java.awt.Color(86, 57, 57));
        what.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 100)); // NOI18N
        what.setForeground(new java.awt.Color(255, 51, 51));
        what.setText("?");
        what.setBorder(null);
        what.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        what.setFocusable(false);
        what.setOpaque(false);
        what.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                whatMouseClicked(evt);
            }
        });
        getContentPane().add(what, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 610, 50, 90));

        backButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/backas.png"))); // NOI18N
        backButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButt.setFocusable(false);
        backButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtMouseClicked(evt);
            }
        });
        getContentPane().add(backButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 120, 90));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/pathHiLo.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

        HiLoSelect.add(oneOrfiveselect);
        getContentPane().add(oneOrfiveselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fivelowselect);
        fivelowselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fivelowselectActionPerformed(evt);
            }
        });
        getContentPane().add(fivelowselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(elevenHiLowselect);
        getContentPane().add(elevenHiLowselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(sixlowselect);
        getContentPane().add(sixlowselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(sixOrtwoselect);
        getContentPane().add(sixOrtwoselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(oneOrsixselect);
        getContentPane().add(oneOrsixselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(oneselect);
        getContentPane().add(oneselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(lowselect);
        getContentPane().add(lowselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(highselect);
        getContentPane().add(highselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(sixselect);
        getContentPane().add(sixselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(sixOroneselect);
        getContentPane().add(sixOroneselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(twoOrfiveselect);
        getContentPane().add(twoOrfiveselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(twoselect);
        getContentPane().add(twoselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(threeselect);
        getContentPane().add(threeselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fourselect);
        getContentPane().add(fourselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fiveselect);
        getContentPane().add(fiveselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fiveOrtwoselect);
        getContentPane().add(fiveOrtwoselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(onetwothreeselect);
        getContentPane().add(onetwothreeselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(threeOrsixselect);
        getContentPane().add(threeOrsixselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(twoOrfourselect);
        getContentPane().add(twoOrfourselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(threeOrfiveselect);
        getContentPane().add(threeOrfiveselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fourOroneselect);
        getContentPane().add(fourOroneselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fourfivesixselect);
        getContentPane().add(fourfivesixselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(null1);
        null1.setText("jRadioButton1");
        getContentPane().add(null1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(null2);
        null2.setText("jRadioButton1");
        getContentPane().add(null2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(ship200select);
        getContentPane().add(ship200select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(ship100select);
        getContentPane().add(ship100select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(ship50select);
        getContentPane().add(ship50select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(ship20select);
        getContentPane().add(ship20select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(ship10select);
        getContentPane().add(ship10select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rollButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollButActionPerformed
        rollBut.setEnabled(false);
        backButt.setEnabled(false);
        backButt.setVisible(false);
        resetButt.setEnabled(false);
        ship10.setEnabled(false);
        ship20.setEnabled(false);
        ship100.setEnabled(false);
        ship50.setEnabled(false);
        ship200.setEnabled(false);
        elevenHiLo.setEnabled(false);
        fivelow.setEnabled(false);
        fiveOrtwo.setEnabled(false);
        one.setEnabled(false);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        high.setEnabled(false);
        low.setEnabled(false);
        oneORfive.setEnabled(false);
        oneOrsix.setEnabled(false);
        sixlow.setEnabled(false);
        twoOrfive.setEnabled(false);
        onetwothree.setEnabled(false);
        threeOrsix.setEnabled(false);
        threeOrfive.setEnabled(false);
        twoOrfour.setEnabled(false);
        twoOrfive.setEnabled(false);
        sixOrone.setEnabled(false);
        sixOrtwo.setEnabled(false);
        fourfivesix.setEnabled(false);
//            jLabel6.setIcon(new ImageIcon(getClass().getResource("/Image/rolll.png")));
//            jLabel7.setIcon(new ImageIcon(getClass().getResource("/Image/rolll.png")));
//            jLabel8.setIcon(new ImageIcon(getClass().getResource("/Image/rolll.png")));
           try {
             tm2 = new Timer (30,new ActionListener(){
                
                public void actionPerformed(ActionEvent e ){
                    if ( j == 430){
                        diceRolling();
                    rollDice();
                    }
                    j-=10;
                    cover.setLocation(j, 40);
                    
                    if(j==230){
                        whatSelected();
                        betTime();
                        backButt.setEnabled(true);
                        backButt.setVisible(true);
                        rollBut.setEnabled(true);
                        resetButt.setEnabled(true);
                        ship10.setEnabled(true);
                        ship20.setEnabled(true);
                        ship100.setEnabled(true);
                        ship50.setEnabled(true);
                        ship200.setEnabled(true);
                        elevenHiLo.setEnabled(true);
                        sixlow.setEnabled(true);
                        fivelow.setEnabled(true);
                        fiveOrtwo.setEnabled(true);
                        one.setEnabled(true);
                        two.setEnabled(true);
                        three.setEnabled(true);
                        four.setEnabled(true);
                        five.setEnabled(true);
                        six.setEnabled(true);
                        high.setEnabled(true);
                        low.setEnabled(true);
                        oneORfive.setEnabled(true);
                        oneOrsix.setEnabled(true);
                        twoOrfive.setEnabled(true);
                        onetwothree.setEnabled(true);
                        fourfivesix.setEnabled(true);
                        threeOrsix.setEnabled(true);
                        threeOrfive.setEnabled(true);
                        twoOrfour.setEnabled(true);
                        twoOrfive.setEnabled(true);
                        sixOrone.setEnabled(true);
                        sixOrtwo.setEnabled(true);
                       tm2.stop();
                    }
                   i = 250;
                }
            });
        } catch (Exception e) {
                                 System.out.println("lol");

        }
            
                 try {
              tm1 = new Timer(30 , new ActionListener(){
                public void actionPerformed(ActionEvent e ){
                    i+=10;
                    cover.setLocation(i, 40);
                    
                    if(i==430){
                        tm2.start();
                        tm1.stop();
                        
                        }
                   j = 430;
                }
            });
           
                
        } catch (Exception e) {
                     System.out.println("lol");
        }
  
           
            tm1.start();
                    
                          
    }//GEN-LAST:event_rollButActionPerformed
  
    private void sixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixMouseClicked
       sixselect.setSelected(true);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 6");
    }//GEN-LAST:event_sixMouseClicked

    private void elevenHiLoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elevenHiLoMouseClicked
        elevenHiLowselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("HILO");
    }//GEN-LAST:event_elevenHiLoMouseClicked

    private void fivelowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fivelowMouseClicked
       fivelowselect.setSelected(true);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("5 LOW");
    }//GEN-LAST:event_fivelowMouseClicked

    private void sixlowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixlowMouseClicked
       sixlowselect.setSelected(true);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("6 LOW");
    }//GEN-LAST:event_sixlowMouseClicked

    private void threeOrsixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threeOrsixMouseClicked
        threeOrsixselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("3 AND 6");
    }//GEN-LAST:event_threeOrsixMouseClicked

    private void highMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_highMouseClicked
        highselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("HIGH");
    }//GEN-LAST:event_highMouseClicked

    private void lowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lowMouseClicked
        lowselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("LOW");
    }//GEN-LAST:event_lowMouseClicked

    private void oneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneMouseClicked
       oneselect.setSelected(true);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 1");
    }//GEN-LAST:event_oneMouseClicked

    private void oneOrsixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneOrsixMouseClicked
      oneOrsixselect.setSelected(true);
      whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("1 AND 6");
    }//GEN-LAST:event_oneOrsixMouseClicked

    private void fiveOrtwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fiveOrtwoMouseClicked
        fiveOrtwoselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("5 AND 2");
    }//GEN-LAST:event_fiveOrtwoMouseClicked

    private void twoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoMouseClicked
       twoselect.setSelected(true);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 2");
    }//GEN-LAST:event_twoMouseClicked

    private void fiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fiveMouseClicked
        fiveselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 5");
    }//GEN-LAST:event_fiveMouseClicked

    private void threeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threeMouseClicked
        threeselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 3");
    }//GEN-LAST:event_threeMouseClicked

    private void fourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fourMouseClicked
        fourselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 4");
    }//GEN-LAST:event_fourMouseClicked

    private void twoOrfiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoOrfiveMouseClicked
       twoOrfiveselect.setSelected(true);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("2 AND 5");
    }//GEN-LAST:event_twoOrfiveMouseClicked

    private void onetwothreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onetwothreeMouseClicked
        onetwothreeselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("1 2 3");
    }//GEN-LAST:event_onetwothreeMouseClicked

    private void fourfivesixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fourfivesixMouseClicked
        fourfivesixselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("4 5 6 ");
    }//GEN-LAST:event_fourfivesixMouseClicked

    private void fourOroneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fourOroneMouseClicked
        fourOroneselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("4 AND 1");
    }//GEN-LAST:event_fourOroneMouseClicked

    private void threeOrfiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threeOrfiveMouseClicked
        threeOrfiveselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("3 AND 5");
    }//GEN-LAST:event_threeOrfiveMouseClicked

    private void twoOrfourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoOrfourMouseClicked
        twoOrfourselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("2 AND 4");
    }//GEN-LAST:event_twoOrfourMouseClicked

    private void sixOrtwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixOrtwoMouseClicked
        sixOrtwoselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("6 AND 2");
    }//GEN-LAST:event_sixOrtwoMouseClicked

    private void oneORfive21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneORfive21MouseClicked
        oneOrfiveselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("1 AND 5");
    }//GEN-LAST:event_oneORfive21MouseClicked

    private void sixOroneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixOroneMouseClicked
        sixOroneselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("6 AND 1");
    }//GEN-LAST:event_sixOroneMouseClicked

    private void oneORfiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneORfiveMouseClicked
        oneOrfiveselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("1 AND 5");
    }//GEN-LAST:event_oneORfiveMouseClicked

    private void fivelowselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fivelowselectActionPerformed
        fivelowselect.setSelected(true);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("5 LOW");
    }//GEN-LAST:event_fivelowselectActionPerformed

    private void ship10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ship10MouseClicked
        ship10select.setSelected(true);
        whatSelectShip.setForeground(Color.BLACK);
        if(betMoney >= money){
            betMoney += 0;
        }else if(betMoney+10 > money){
            betMoney = money;
        }else{
        betMoney += 10;
        }
        setBetMoney = Integer.toString(betMoney);
        whatSelectShip.setText(setBetMoney+" BATH");
    }//GEN-LAST:event_ship10MouseClicked

    private void ship20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ship20MouseClicked
        ship20select.setSelected(true);
        whatSelectShip.setForeground(Color.BLACK);
        if(betMoney >= money){
            betMoney += 0;
        }
        else if(betMoney+20 > money){
            betMoney = money;
        }
        else{
        betMoney += 20;
        }
        setBetMoney = Integer.toString(betMoney);
        whatSelectShip.setText(setBetMoney+" BATH");
    }//GEN-LAST:event_ship20MouseClicked

    private void ship50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ship50MouseClicked
        ship50select.setSelected(true);
        whatSelectShip.setForeground(Color.BLACK);
        if(betMoney >= money){
            betMoney += 0;
        }
        else if(betMoney+50 > money){
            betMoney = money;
        }
        else{
        betMoney += 50;
        }
        setBetMoney = Integer.toString(betMoney);
        whatSelectShip.setText(setBetMoney+" BATH");
    }//GEN-LAST:event_ship50MouseClicked

    private void ship100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ship100MouseClicked
        ship100select.setSelected(true);
        whatSelectShip.setForeground(Color.BLACK);
        if(betMoney >= money){
            betMoney += 0;
        }
        else if(betMoney+100 > money){
            betMoney = money;
        }
        else{
        betMoney += 100;
        }
        setBetMoney = Integer.toString(betMoney);
        whatSelectShip.setText(setBetMoney+" BATH");
    }//GEN-LAST:event_ship100MouseClicked

    private void ship200MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ship200MouseClicked
       ship200select.setSelected(true);
       whatSelectShip.setForeground(Color.BLACK);
       if(betMoney >= money){
            betMoney += 0;
        }
       else if(betMoney+200 > money){
            betMoney = money;
        }
       else{
       betMoney += 200;
       }
       setBetMoney = Integer.toString(betMoney);
        whatSelectShip.setText(setBetMoney+" BATH");
    }//GEN-LAST:event_ship200MouseClicked

    private void resetButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtActionPerformed
       whatSelectBet.setForeground(Color.LIGHT_GRAY);
       whatSelectBet.setText("bet selected");
       whatSelectShip.setForeground(Color.lightGray);
       whatSelectShip.setText("Ship selected");
       loseWin.setForeground(new java.awt.Color(86, 57, 57));
       howMuchLostWin.setForeground(new java.awt.Color(86, 57, 57));
       loseWinBar.setForeground(new java.awt.Color(86, 57, 57));
       betMoney = 0;
       null1.setSelected(true);
       null2.setSelected(true);
    }//GEN-LAST:event_resetButtActionPerformed

    private void whatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whatMouseClicked
        new HowToPlay("DiceGame").setVisible(true);
    }//GEN-LAST:event_whatMouseClicked

    private void backButtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtMouseClicked
        null1.setSelected(true);
        null2.setSelected(true);
        new StartForm().setVisible(true);
        userLog.clear();
        userLogin.clear();
        userLoginShow.clear();
        userMoney.clear();
        userMoneyShow.clear();
        password.clear();
        this.setVisible(false);
        file.setAllListClear();
    }//GEN-LAST:event_backButtMouseClicked
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
                    /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyDiceGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyDiceGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyDiceGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyDiceGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fol
        //</editor-fol
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new MyDiceGame().setVisible(true);
            }
        }); 
        
       
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup HiLoSelect;
    private javax.swing.JLabel backButt;
    private javax.swing.JLabel background;
    private javax.swing.JTextField betText;
    private javax.swing.JTextField betText1;
    private javax.swing.JLabel cover;
    private javax.swing.JLabel dice1;
    private javax.swing.JLabel dice2;
    private javax.swing.JLabel dice3;
    private javax.swing.JLabel diceShow1;
    private javax.swing.JLabel diceShow2;
    private javax.swing.JLabel diceShow3;
    private javax.swing.JLabel elevenHiLo;
    private javax.swing.JRadioButton elevenHiLowselect;
    private javax.swing.JLabel five;
    private javax.swing.JLabel fiveOrtwo;
    private javax.swing.JRadioButton fiveOrtwoselect;
    private javax.swing.JLabel fivelow;
    private javax.swing.JRadioButton fivelowselect;
    private javax.swing.JRadioButton fiveselect;
    private javax.swing.JLabel four;
    private javax.swing.JLabel fourOrone;
    private javax.swing.JRadioButton fourOroneselect;
    private javax.swing.JLabel fourfivesix;
    private javax.swing.JRadioButton fourfivesixselect;
    private javax.swing.JRadioButton fourselect;
    private javax.swing.JLabel high;
    private javax.swing.JRadioButton highselect;
    private javax.swing.JLabel hiloPlane;
    private javax.swing.JTextField howMuchLostWin;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField loseWin;
    private javax.swing.JTextField loseWinBar;
    private javax.swing.JLabel low;
    private javax.swing.JRadioButton lowselect;
    private javax.swing.JLabel moneyPic;
    private javax.swing.JTextField moneyString;
    private javax.swing.JRadioButton null1;
    private javax.swing.JRadioButton null2;
    private javax.swing.JLabel one;
    private javax.swing.JLabel oneORfive;
    private javax.swing.JLabel oneORfive21;
    private javax.swing.JRadioButton oneOrfiveselect;
    private javax.swing.JLabel oneOrsix;
    private javax.swing.JRadioButton oneOrsixselect;
    private javax.swing.JRadioButton oneselect;
    private javax.swing.JLabel onetwothree;
    private javax.swing.JRadioButton onetwothreeselect;
    private javax.swing.JLabel plate;
    private javax.swing.JButton resetButt;
    private javax.swing.JButton rollBut;
    private javax.swing.JLabel ship10;
    private javax.swing.JLabel ship100;
    private javax.swing.JRadioButton ship100select;
    private javax.swing.JRadioButton ship10select;
    private javax.swing.JLabel ship20;
    private javax.swing.JLabel ship200;
    private javax.swing.JRadioButton ship200select;
    private javax.swing.JRadioButton ship20select;
    private javax.swing.JLabel ship50;
    private javax.swing.JRadioButton ship50select;
    private javax.swing.ButtonGroup shipselect;
    private javax.swing.JLabel six;
    private javax.swing.JLabel sixOrone;
    private javax.swing.JRadioButton sixOroneselect;
    private javax.swing.JLabel sixOrtwo;
    private javax.swing.JRadioButton sixOrtwoselect;
    private javax.swing.JLabel sixlow;
    private javax.swing.JRadioButton sixlowselect;
    private javax.swing.JRadioButton sixselect;
    private javax.swing.JLabel three;
    private javax.swing.JLabel threeOrfive;
    private javax.swing.JRadioButton threeOrfiveselect;
    private javax.swing.JLabel threeOrsix;
    private javax.swing.JRadioButton threeOrsixselect;
    private javax.swing.JRadioButton threeselect;
    private javax.swing.JTextField totalBox;
    private javax.swing.JTextField totalText;
    private javax.swing.JLabel two;
    private javax.swing.JLabel twoOrfive;
    private javax.swing.JRadioButton twoOrfiveselect;
    private javax.swing.JLabel twoOrfour;
    private javax.swing.JRadioButton twoOrfourselect;
    private javax.swing.JRadioButton twoselect;
    private javax.swing.JTextField usShow;
    private javax.swing.JTextField what;
    private javax.swing.JTextField whatSelectBet;
    private javax.swing.JTextField whatSelectShip;
    // End of variables declaration//GEN-END:variables
}
