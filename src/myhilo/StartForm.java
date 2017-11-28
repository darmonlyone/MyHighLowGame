/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhilo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.Timer;



/**
 *
 * @author Manusporn Fukkham
 */
public class StartForm extends javax.swing.JFrame {

    /**
     * Creates new form StartForm
     */
    static HowToPlayDiceGame what = new HowToPlayDiceGame();
    static LoginForm login = new LoginForm();
    static List<String> userLog; 
    static List<Integer> userMoney;
    static List<String> userLogin;
    static List<Integer> userMoneyShow; 
    static List<String> userLoginShow;   
    FileLock file = new FileLock();
    private static boolean freeVideos = true;
    
    int i = 0 , j =0, veri =2, verj =1;
    int  i2 =50 , i3 =100 , i4 =150, i5 =200;
    int  j2 =10, veri2 =2, verj2 =1;
    int  j3 =20, veri3 =2, verj3=1;
    int  j4 =30, veri4 =2, verj4 =1;
    int j5 =40, veri5 =2, verj5 =1;
    
    int x = 200,y =300,verX=1, verY=3;
    int x2 = 100 , y2 = 127, verX2 = -2 , verY2 = 2;
    int x3 = 899 , y3 = 421, verX3 = -2 , verY5 = 1;
    int x4 = 700 , y5 = 432, verX4 = 1 , verY4 = 3;
    int x5 = 200 , y6 = 456, verX5 = -3 , verY6 = 2;
    int x6 = 648 , y4 = 249, verX6 = 4 , verY3 = 1;
    int countter = 0;
    
    public void fileOpen(){
        file.setUPMlog();
        file.setUPMAF();
        userLog = file.getUserLog();
        userLogin = file.getUserLog();
        userMoney = file.getUserMoney();
        userLoginShow = file.getUserLoginShow();
        userMoneyShow = file.getUserMoneyShow();
        setText();
        
    }
    
    public void setText(){
    String mn = Integer.toString(userMoneyShow.get(0));
        moneyString.setText(mn);
        usShow.setText(userLoginShow.get(0));
//        System.out.println(userLoginShow.get(0));
}
    public StartForm() {
        backGroundAnimetion();
        backGroundAnimetion2();
        setSize(900, 500);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
        fileOpen();
        advertiseFree.setVisible(false);
        freeMoneyText.setVisible(false);
        
     }
    public void backGroundAnimetion2(){
        Timer t1 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (i<-15||i>850)
                        veri  =  -veri;
                    if (j>81 || j<-8)
                        verj = -verj;
                       i += veri;
                       j += verj;
                      ship1.setLocation(i, j);     
                       }
            });
        Timer t2 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (i2<-15||i2>850)
                        veri2  =  -veri2;
                    if (j2>81 || j2<-8)
                        verj2 = -verj2;
                       i2 += veri2;
                       j2 += verj2;
                      ship2.setLocation(i2, j2);     
                       }
            });
        Timer t3 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (i3<-15||i3>850)
                        veri3  =  -veri3;
                    if (j3>81 || j3<-8)
                        verj3 = -verj3;
                       i3 += veri3;
                       j3 += verj3;
                      ship3.setLocation(i3, j3);     
                       }
            });
        Timer t4 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (i4<-15||i4>850)
                        veri4  =  -veri4;
                    if (j4>81 || j4<-8)
                        verj4 = -verj4;
                       i4 += veri4;
                       j4 += verj4;
                      ship4.setLocation(i4, j4);     
                       }
            });
        Timer t5 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (i5<-15||i5>850)
                        veri5  =  -veri5;
                    if (j5>81 || j5<-8)
                        verj5 = -verj5;
                       i5 += veri5;
                       j5 += verj5;
                      ship5.setLocation(i5, j5);     
                       }
            });
      
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }
  
    
    public void backGroundAnimetion(){

    Timer tm1 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (x<0||x>890)
                        verX  =  -verX;
                    if (y>500 || y<127)
                        verY = -verY;
                       x += verX;
                       y += verY;
                      dice1.setLocation(x, y);   
                      countter++;
                      if(freeVideos && !userMoneyShow.isEmpty() ){
                      if(countter == 100 && userMoneyShow.get(0) <= 800){
                          advertiseFree.setVisible(true);
                          freeMoneyText.setVisible(true);
                          freeVideos = false;
                      }
                       }
                }
            });
    
    Timer tm2 = new Timer(15 , new ActionListener(){
       
                public void actionPerformed(ActionEvent e ){
                    
                    if (x2<0||x2>890)
                        verX2  =  -verX2;
                    if (y2>500 || y2<127)
                        verY2 = -verY2;
                       x2 += verX2;
                       y2 += verY2;
                       
                      dice2.setLocation(x2, y2);     
                       
                }
            });
    Timer tm3 = new Timer(15 , new ActionListener(){
       
                public void actionPerformed(ActionEvent e ){
                    
                    if (x3<0||x3>890)
                        verX3  =  -verX3;
                    if (y3>500 || y3<127)
                        verY3 = -verY3;
                       x3 += verX3;
                       y3 += verY3;
                       
                      dice3.setLocation(x3, y3);     
                       
                }
            });
    Timer tm4 = new Timer(15 , new ActionListener(){
       
                public void actionPerformed(ActionEvent e ){
                    
                    if (x4<0||x4>890)
                        verX4  =  -verX4;
                    if (y4>500 || y4<127)
                        verY4 = -verY4;
                       x4 += verX4;
                       y4 += verY4;
                       
                      dice4.setLocation(x4, y4);     
                       
                }
            });
    Timer tm5 = new Timer(15 , new ActionListener(){
       
                public void actionPerformed(ActionEvent e ){
                    
                    if (x5<0||x5>890)
                        verX5  =  -verX5;
                    if (y5>500 || y5<127)
                        verY5 = -verY5;
                       x5 += verX5;
                       y5 += verY5;
                       
                      dice5.setLocation(x5, y5);     
                       
                }
            });
    Timer tm6 = new Timer(15 , new ActionListener(){
       
                public void actionPerformed(ActionEvent e ){
                    
                    if (x6<0||x6>890)
                        verX6  =  -verX6;
                    if (y6>500 || y6<127)
                        verY6 = -verY6;
                       x6 += verX6;
                       y6 += verY6;
                     dice6.setLocation(x6, y6);     
                     }
            });
    
    tm2.start();
    tm1.start();
    tm3.start();
    tm4.start();
    tm5.start();
    tm6.start();
 }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dice6 = new javax.swing.JLabel();
        dice5 = new javax.swing.JLabel();
        dice4 = new javax.swing.JLabel();
        dice3 = new javax.swing.JLabel();
        dice2 = new javax.swing.JLabel();
        dice1 = new javax.swing.JLabel();
        advertiseFree = new javax.swing.JLabel();
        freeMoneyText = new javax.swing.JTextField();
        diceGamePic = new javax.swing.JLabel();
        cardGamepic = new javax.swing.JLabel();
        playButtDice = new javax.swing.JButton();
        playCard = new javax.swing.JButton();
        ship1 = new javax.swing.JLabel();
        ship2 = new javax.swing.JLabel();
        ship3 = new javax.swing.JLabel();
        ship4 = new javax.swing.JLabel();
        ship5 = new javax.swing.JLabel();
        highLowtexT = new javax.swing.JTextField();
        moneyString = new javax.swing.JTextField();
        moneyPic = new javax.swing.JLabel();
        usShow = new javax.swing.JTextField();
        logoutBut = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        dice6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/dice6.png"))); // NOI18N

        dice5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/dice5.png"))); // NOI18N

        dice4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/dice4.png"))); // NOI18N

        dice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/dice3.png"))); // NOI18N

        dice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/dice2.png"))); // NOI18N

        dice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/dice1.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        advertiseFree.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageStart/Videos.png"))); // NOI18N
        advertiseFree.setToolTipText("");
        advertiseFree.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        advertiseFree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                advertiseFreeMouseClicked(evt);
            }
        });
        getContentPane().add(advertiseFree, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 70, -1));

        freeMoneyText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        freeMoneyText.setForeground(new java.awt.Color(255, 0, 0));
        freeMoneyText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        freeMoneyText.setText("Free 5000 ฿");
        freeMoneyText.setBorder(null);
        freeMoneyText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        freeMoneyText.setFocusable(false);
        getContentPane().add(freeMoneyText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 90, -1));

        diceGamePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageStart/DiceGame.png"))); // NOI18N
        getContentPane().add(diceGamePic, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 200, 140));

        cardGamepic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageStart/CardGame.png"))); // NOI18N
        getContentPane().add(cardGamepic, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 180, 170));

        playButtDice.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        playButtDice.setText("Play");
        playButtDice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playButtDice.setFocusable(false);
        playButtDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtDiceActionPerformed(evt);
            }
        });
        getContentPane().add(playButtDice, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        playCard.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        playCard.setText("Play");
        playCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playCard.setFocusable(false);
        playCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playCardActionPerformed(evt);
            }
        });
        getContentPane().add(playCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        ship1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/ship200.png"))); // NOI18N
        getContentPane().add(ship1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 70, 50));

        ship2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/ship100.png"))); // NOI18N
        getContentPane().add(ship2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        ship3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/ship50.png"))); // NOI18N
        getContentPane().add(ship3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 50));

        ship4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/ship20.png"))); // NOI18N
        getContentPane().add(ship4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 70, 50));

        ship5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/ship10.png"))); // NOI18N
        getContentPane().add(ship5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 70, 50));

        highLowtexT.setEditable(false);
        highLowtexT.setBackground(new java.awt.Color(231, 53, 137));
        highLowtexT.setFont(new java.awt.Font("Tahoma", 0, 80)); // NOI18N
        highLowtexT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        highLowtexT.setText("HILO GAME");
        highLowtexT.setBorder(null);
        highLowtexT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        highLowtexT.setFocusable(false);
        getContentPane().add(highLowtexT, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        moneyString.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        moneyString.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        moneyString.setText("Money");
        moneyString.setAutoscrolls(false);
        moneyString.setBorder(null);
        moneyString.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        moneyString.setFocusable(false);
        moneyString.setRequestFocusEnabled(false);
        getContentPane().add(moneyString, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 100, 30));

        moneyPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/money.png"))); // NOI18N
        getContentPane().add(moneyPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 160, 50));

        usShow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usShow.setForeground(new java.awt.Color(255, 51, 51));
        usShow.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usShow.setText("Username");
        usShow.setBorder(null);
        usShow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usShow.setFocusable(false);
        usShow.setOpaque(false);
        getContentPane().add(usShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 140, 40));

        logoutBut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logoutBut.setForeground(new java.awt.Color(255, 51, 51));
        logoutBut.setText("Logout");
        logoutBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        logoutBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBut.setFocusPainted(false);
        logoutBut.setFocusable(false);
        logoutBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButActionPerformed(evt);
            }
        });
        getContentPane().add(logoutBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 80, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageStart/BG.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtDiceActionPerformed
       MyDiceGame playDiceGame = new MyDiceGame();
       userLog.clear();
       userLogin.clear();
       userMoney.clear();
       userLoginShow.clear();
       userMoneyShow.clear();
       playDiceGame.setVisible(true);
       what.setVisible(true);
       this.setVisible(false);
        file.setAllListClear();
    }//GEN-LAST:event_playButtDiceActionPerformed

    private void logoutButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButActionPerformed
       LoginForm logout = new LoginForm();
       userLog.clear();
       userLogin.clear();
       userMoney.clear();
       userLoginShow.clear();
       userMoneyShow.clear();
       logout.setVisible(true);
       this.setVisible(false);
        file.setAllListClear();
    }//GEN-LAST:event_logoutButActionPerformed

    private void playCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playCardActionPerformed
       MyCardGame playCardGame = new MyCardGame();
       HowToPlayCardGame how = new HowToPlayCardGame();
       userLog.clear();
       userLogin.clear();
       userMoney.clear();
       userLoginShow.clear();
       userMoneyShow.clear();
       playCardGame.setVisible(true);
       how.setVisible(true);
       this.setVisible(false);
       file.setAllListClear();       
    }//GEN-LAST:event_playCardActionPerformed

    private void advertiseFreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_advertiseFreeMouseClicked
        try {
            AdvertiseMain.main(null);
            userMoneyShow.set(0,userMoneyShow.get(0)+5000);
        } catch (Exception e) {
            System.out.println(e);
        }
       advertiseFree.setVisible(false);
       freeMoneyText.setVisible(false);
       setText();
        
    }//GEN-LAST:event_advertiseFreeMouseClicked
 
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
            java.util.logging.Logger.getLogger(StartForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advertiseFree;
    private javax.swing.JLabel background;
    private javax.swing.JLabel cardGamepic;
    private javax.swing.JLabel dice1;
    private javax.swing.JLabel dice2;
    private javax.swing.JLabel dice3;
    private javax.swing.JLabel dice4;
    private javax.swing.JLabel dice5;
    private javax.swing.JLabel dice6;
    private javax.swing.JLabel diceGamePic;
    private javax.swing.JTextField freeMoneyText;
    private javax.swing.JTextField highLowtexT;
    private javax.swing.JButton logoutBut;
    private javax.swing.JLabel moneyPic;
    private javax.swing.JTextField moneyString;
    private javax.swing.JButton playButtDice;
    private javax.swing.JButton playCard;
    private javax.swing.JLabel ship1;
    private javax.swing.JLabel ship2;
    private javax.swing.JLabel ship3;
    private javax.swing.JLabel ship4;
    private javax.swing.JLabel ship5;
    private javax.swing.JTextField usShow;
    // End of variables declaration//GEN-END:variables
}
