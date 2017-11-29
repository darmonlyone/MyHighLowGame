/*
 * This class for playing CardGame which will get your acount use
 * and set money all the time you finished a game.a
 */
package myhilo;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author Maunsporn Fukkham
 */
public class MyCardGame extends javax.swing.JFrame {
    static List<Integer> userMoney;
    static List<String> password;
    static List<String> userLogin;
    static List<Integer>userMoneyShow;
    static List<String> userLoginShow;
    static List<String> userLog;
    static List<Integer> cardDeck = new ArrayList<Integer>();
        static List<Integer> cardUsed = new ArrayList<Integer>();
	static Random rd = new Random();
        static Scanner sc = new Scanner(System.in);
        static GetCard cardgame = new GetCard();
        static int ourCardNum,ourHiddenCardNum = 0; 
        static int enemyCardNum,enemyHiddenCardNum = 0;
        static int betMoney;
        static int money = 0;
        static boolean betMoneyCheck = true;
        
     FileLock file = new FileLock();
    private void setArrayList(){
       
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
            logSave.printf("%s : %s : %s%n",userLogin.get(i),password.get(i),userMoney.get(i));
        }
        logSave.close();
    }
        
        private void setMoney(){
          String mn = Integer.toString(money);
          moneyString.setText(mn);
          
      }
        
        
    public MyCardGame() {
         
        setBackground(Color.LIGHT_GRAY);
        setSize(1200, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        
        setMoney();
        setArrayList();
         
    }
    public void setButtEnable(){
        bothNewCardButt.setEnabled(true);
       newCardButt.setEnabled(true);
       enemyNewCardButt.setEnabled(true);
       checkButt.setEnabled(true);
    }
         public int randomCard(){
                 return rd.nextInt(cardDeck.size())+1;
         }
	
	public  void addCard(){
		cardDeck.clear();
		for(int i = 0 ; i < 52 ; i++){
			cardDeck.add(i+1);
		}
	}
	
        public void ourNewCard(){
        while(true){
            ourCardNum = randomCard();
            if(!cardUsed.contains(ourCardNum) || cardUsed.isEmpty()){
                System.out.println("Ourcard = "+ourCardNum);
                cardUsed.add(ourCardNum);
                ourHiddenCardNum = ourCardNum;
                break;
            }
            }
        }
        public void enemyNewCard(){
            while(true){
                enemyCardNum = randomCard();
                if(!cardUsed.contains(enemyCardNum)||cardUsed.isEmpty()){
                    System.out.println("EnemyCard = "+enemyCardNum);
                cardUsed.add(enemyCardNum);
                enemyHiddenCardNum = enemyCardNum;
                break;
                }
            }
         }
    public void setCard(){
        ourNewCard();
        enemyNewCard();
        setOurcard(ourCardNum);
        
    }
    public void setOurcard(int card){
         ourCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardgame.getPicCard(card))));
    }
    public void setEnemyCard(int card){
        enemyCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardgame.getPicCard(card))));
    }
    public void setOurHiddenCard(){
        if(ourHiddenCardNum != 0){
            ourHideCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardgame.getPicCard(ourHiddenCardNum))));
        }
       
    }
     public void setEnemyHiddenCard(){
          if(enemyHiddenCardNum !=0 ){
            enemyHideCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardgame.getPicCard(enemyHiddenCardNum))));
        }
     }
     public void noMoney(){
         if (money == 0){
             money = 100;
             GetFreeMoney get = new GetFreeMoney();
               get.setVisible(true);
         }
     }
     public void setGamePlay(){
           if(betMoneyText.getText().equals("money here")||betMoneyText.getText().equals("")){
            tooMuch.setText("Please put some money");
            tooMuch.setForeground(new java.awt.Color(255, 0, 0));
        }
       else if (!isNumber(betMoneyText.getText())){
           tooMuch.setText("Please put a number");
            tooMuch.setForeground(new java.awt.Color(255, 0, 0));
       }
       else if(Integer.parseInt(betMoneyText.getText())<=0){
             tooMuch.setText("Please put money more than 0");
            tooMuch.setForeground(new java.awt.Color(255, 0, 0));
        }
       else if(Integer.parseInt(betMoneyText.getText())>money){
            tooMuch.setText("Not more than your money");
            tooMuch.setForeground(new java.awt.Color(255, 0, 0));
        }else{
           addCard();
           backButt.setEnabled(false);
           backButt.setVisible(false);
            betButt.setEnabled(false);
           betMoneyText.setEditable(false);
             tooMuch.setText("");
        betMoney = Integer.parseInt(betMoneyText.getText());
        setButtEnable();
       setCard();
       betMoneyCheck = false;
        }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usShow = new javax.swing.JTextField();
        moneyString = new javax.swing.JTextField();
        moneyPic = new javax.swing.JLabel();
        backButt = new javax.swing.JLabel();
        ourHideCardCover = new javax.swing.JLabel();
        enemyHideCardCover = new javax.swing.JLabel();
        loseWinBar = new javax.swing.JTextField();
        loseWin = new javax.swing.JTextField();
        howMuchLostWin = new javax.swing.JTextField();
        tooMuch = new javax.swing.JTextField();
        betButt = new javax.swing.JButton();
        enemyHideCard = new javax.swing.JLabel();
        inputyourbet = new javax.swing.JTextField();
        bothNewCardButt = new javax.swing.JButton();
        bothNewCradCountText = new javax.swing.JTextField();
        enemyNewCardButt = new javax.swing.JButton();
        betMoneyText = new javax.swing.JTextField();
        newCradCountText = new javax.swing.JTextField();
        resetButt = new javax.swing.JButton();
        enemyNewCradCountText = new javax.swing.JTextField();
        checkButt = new javax.swing.JButton();
        newCardButt = new javax.swing.JButton();
        enemyCard = new javax.swing.JLabel();
        deckOfCard = new javax.swing.JLabel();
        ourCard = new javax.swing.JLabel();
        ourHideCard = new javax.swing.JLabel();
        what2 = new javax.swing.JTextField();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usShow.setEditable(false);
        usShow.setBackground(new java.awt.Color(116, 158, 69));
        usShow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usShow.setForeground(new java.awt.Color(255, 0, 0));
        usShow.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usShow.setText("Username");
        usShow.setBorder(null);
        usShow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usShow.setFocusable(false);
        usShow.setOpaque(false);
        getContentPane().add(usShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 40));

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

        backButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/backas.png"))); // NOI18N
        backButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButt.setFocusable(false);
        backButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtMouseClicked(evt);
            }
        });
        getContentPane().add(backButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 120, 90));

        ourHideCardCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageCard/HiddenCard.png"))); // NOI18N
        getContentPane().add(ourHideCardCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, -1, -1));

        enemyHideCardCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageCard/HiddenCard.png"))); // NOI18N
        getContentPane().add(enemyHideCardCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, -1, -1));

        loseWinBar.setBackground(new java.awt.Color(116, 158, 69));
        loseWinBar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        loseWinBar.setForeground(new java.awt.Color(116, 158, 69));
        loseWinBar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loseWinBar.setText("YOU LOST MONEY:");
        loseWinBar.setBorder(null);
        loseWinBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loseWinBar.setFocusable(false);
        loseWinBar.setOpaque(false);
        getContentPane().add(loseWinBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 250, 60));

        loseWin.setBackground(new java.awt.Color(116, 158, 69));
        loseWin.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        loseWin.setForeground(new java.awt.Color(116, 158, 69));
        loseWin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loseWin.setText("YOU LOSE!");
        loseWin.setToolTipText("");
        loseWin.setBorder(null);
        loseWin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loseWin.setFocusable(false);
        loseWin.setOpaque(false);
        getContentPane().add(loseWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 320, 70));

        howMuchLostWin.setBackground(new java.awt.Color(116, 158, 69));
        howMuchLostWin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        howMuchLostWin.setForeground(new java.awt.Color(116, 158, 69));
        howMuchLostWin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        howMuchLostWin.setText("1000 bath.");
        howMuchLostWin.setBorder(null);
        howMuchLostWin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        howMuchLostWin.setFocusable(false);
        howMuchLostWin.setOpaque(false);
        getContentPane().add(howMuchLostWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 140, 60));

        tooMuch.setBackground(new java.awt.Color(116, 158, 69));
        tooMuch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tooMuch.setForeground(new java.awt.Color(116, 158, 69));
        tooMuch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tooMuch.setText("Not more than you money");
        tooMuch.setBorder(null);
        tooMuch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tooMuch.setFocusable(false);
        getContentPane().add(tooMuch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 200, -1));

        betButt.setBackground(new java.awt.Color(255, 51, 51));
        betButt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        betButt.setText("Bet");
        betButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        betButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betButtActionPerformed(evt);
            }
        });
        getContentPane().add(betButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 110, 60));

        enemyHideCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageCard/HiddenCard.png"))); // NOI18N
        getContentPane().add(enemyHideCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, -1, -1));

        inputyourbet.setEditable(false);
        inputyourbet.setBackground(new java.awt.Color(116, 158, 69));
        inputyourbet.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        inputyourbet.setText("Input Bet :");
        inputyourbet.setToolTipText("");
        inputyourbet.setBorder(null);
        inputyourbet.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inputyourbet.setFocusable(false);
        getContentPane().add(inputyourbet, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        bothNewCardButt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bothNewCardButt.setText("Both new card");
        bothNewCardButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bothNewCardButt.setEnabled(false);
        bothNewCardButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bothNewCardButtActionPerformed(evt);
            }
        });
        getContentPane().add(bothNewCardButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 170, 60));

        bothNewCradCountText.setBackground(new java.awt.Color(116, 158, 69));
        bothNewCradCountText.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        bothNewCradCountText.setForeground(new java.awt.Color(255, 153, 0));
        bothNewCradCountText.setText("1");
        bothNewCradCountText.setBorder(null);
        bothNewCradCountText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bothNewCradCountText.setFocusable(false);
        getContentPane().add(bothNewCradCountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 30, 40));

        enemyNewCardButt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enemyNewCardButt.setText("Enemy new card");
        enemyNewCardButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enemyNewCardButt.setEnabled(false);
        enemyNewCardButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enemyNewCardButtActionPerformed(evt);
            }
        });
        getContentPane().add(enemyNewCardButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 170, 60));

        betMoneyText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        betMoneyText.setForeground(new java.awt.Color(204, 204, 204));
        betMoneyText.setText("money here");
        betMoneyText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                betMoneyTextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                betMoneyTextKeyTyped(evt);
            }
        });
        getContentPane().add(betMoneyText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 160, -1));

        newCradCountText.setBackground(new java.awt.Color(116, 158, 69));
        newCradCountText.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        newCradCountText.setForeground(new java.awt.Color(255, 255, 0));
        newCradCountText.setText("2");
        newCradCountText.setBorder(null);
        newCradCountText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newCradCountText.setFocusable(false);
        getContentPane().add(newCradCountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 30, 40));

        resetButt.setBackground(new java.awt.Color(255, 0, 51));
        resetButt.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        resetButt.setForeground(new java.awt.Color(255, 255, 255));
        resetButt.setText("Reset");
        resetButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetButt.setEnabled(false);
        resetButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtActionPerformed(evt);
            }
        });
        getContentPane().add(resetButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 450, 130, 70));

        enemyNewCradCountText.setBackground(new java.awt.Color(116, 158, 69));
        enemyNewCradCountText.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        enemyNewCradCountText.setForeground(new java.awt.Color(255, 153, 0));
        enemyNewCradCountText.setText("1");
        enemyNewCradCountText.setBorder(null);
        enemyNewCradCountText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        enemyNewCradCountText.setFocusable(false);
        getContentPane().add(enemyNewCradCountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 30, 40));

        checkButt.setBackground(new java.awt.Color(51, 255, 51));
        checkButt.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        checkButt.setText("Check");
        checkButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkButt.setEnabled(false);
        checkButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtActionPerformed(evt);
            }
        });
        getContentPane().add(checkButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 140, 120));

        newCardButt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        newCardButt.setText("New card");
        newCardButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newCardButt.setEnabled(false);
        newCardButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCardButtActionPerformed(evt);
            }
        });
        getContentPane().add(newCardButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 170, 60));

        enemyCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageCard/BackCard.png"))); // NOI18N
        getContentPane().add(enemyCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));

        deckOfCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageCard/DeckCard.png"))); // NOI18N
        getContentPane().add(deckOfCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 180, -1, -1));

        ourCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageCard/FaceCard.png"))); // NOI18N
        getContentPane().add(ourCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, -1, -1));

        ourHideCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageCard/HiddenCard.png"))); // NOI18N
        getContentPane().add(ourHideCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, -1, -1));

        what2.setBackground(new java.awt.Color(0, 114, 54));
        what2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 100)); // NOI18N
        what2.setForeground(new java.awt.Color(255, 51, 51));
        what2.setText("?");
        what2.setBorder(null);
        what2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        what2.setFocusable(false);
        what2.setOpaque(false);
        what2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                what2MouseClicked(evt);
            }
        });
        getContentPane().add(what2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 500, 50, 100));

        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageCard/pathCard.png"))); // NOI18N
        backGround.setFocusable(false);
        getContentPane().add(backGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   public boolean isNumber(String what){
		try {
			Integer.parseInt(what);
			return true;
		} catch(NumberFormatException ex) {
			return false;
		}
	}
    private void betButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betButtActionPerformed
                setGamePlay();
    }//GEN-LAST:event_betButtActionPerformed

    private void newCardButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCardButtActionPerformed
         if(Integer.parseInt(newCradCountText.getText())  > 0){
             setOurHiddenCard();
             ourNewCard();
             setOurcard(ourCardNum);
             newCradCountText.setText(Integer.toString(Integer.parseInt(newCradCountText.getText())-1));
             
             if(newCradCountText.getText().equals("1"))
                  newCradCountText.setForeground(new java.awt.Color(255, 153, 0));
             if(newCradCountText.getText().equals("0"))
                 newCradCountText.setForeground(new java.awt.Color(255, 0, 0));
         }
    }//GEN-LAST:event_newCardButtActionPerformed

    private void enemyNewCardButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enemyNewCardButtActionPerformed
         if(Integer.parseInt(enemyNewCradCountText.getText())  > 0){
             setEnemyHiddenCard();
             enemyNewCard();
             enemyNewCradCountText.setText(Integer.toString(Integer.parseInt(enemyNewCradCountText.getText())-1));
             
             if(enemyNewCradCountText.getText().equals("0"))
                 enemyNewCradCountText.setForeground(new java.awt.Color(255, 0, 0));
         }
    }//GEN-LAST:event_enemyNewCardButtActionPerformed

    private void bothNewCardButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bothNewCardButtActionPerformed
         if(Integer.parseInt(bothNewCradCountText.getText())  > 0){
             setOurHiddenCard();
             setEnemyHiddenCard();
             ourNewCard();
             setOurcard(ourCardNum);
             enemyNewCard();
             bothNewCradCountText.setText(Integer.toString(Integer.parseInt(bothNewCradCountText.getText())-1));
            if(bothNewCradCountText.getText().equals("0"))
                 bothNewCradCountText.setForeground(new java.awt.Color(255, 0, 0));
         }
    }//GEN-LAST:event_bothNewCardButtActionPerformed

    private void betMoneyTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_betMoneyTextKeyTyped
        if(betMoneyText.getText().equals("money here")){
        betMoneyText.setText("");
        betMoneyText.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_betMoneyTextKeyTyped

    private void checkButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtActionPerformed
                   
        
        betMoneyText.setEnabled(false);
        resetButt.setEnabled(true);
        betButt.setEnabled(false);
        newCardButt.setEnabled(false);
        enemyNewCardButt.setEnabled(false);
        bothNewCardButt.setEnabled(false);
        setEnemyCard(enemyCardNum);
        if(enemyCardNum>ourCardNum){
            loseWin.setText("YOU LOSE!");
            loseWin.setForeground(Color.red);
            loseWinBar.setText("YOU LOST MONEY :");
            loseWinBar.setForeground(Color.black);
            howMuchLostWin.setText(Integer.toString(betMoney)+" Bath.");
            howMuchLostWin.setForeground(Color.red);
            money -= betMoney;
            noMoney();
            setMoney();
            setSaveStatus();
            checkButt.setEnabled(false);
        }
        if(ourCardNum>enemyCardNum){
            loseWin.setText("YOU WIN!");
            loseWin.setForeground(Color.blue);
            loseWinBar.setText("YOU GET MONEY :");
            loseWinBar.setForeground(Color.black);
            howMuchLostWin.setText(Integer.toString(betMoney)+" Bath.");
            howMuchLostWin.setForeground(Color.blue);
            money += betMoney;
            setMoney();
            setSaveStatus();
            checkButt.setEnabled(false);
        }
    }//GEN-LAST:event_checkButtActionPerformed

    private void resetButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtActionPerformed
        cardUsed.clear();
        cardDeck.clear();
        resetButt.setEnabled(false);
        checkButt.setEnabled(false);
        backButt.setVisible(true);
        betButt.setEnabled(true);
        backButt.setEnabled(true);
        ourCardNum = 53;
        enemyCardNum = 0;
        ourHiddenCardNum = 54;
        enemyHiddenCardNum = 54;
        setOurcard(ourCardNum);
        setEnemyCard(enemyCardNum);
        setOurHiddenCard();
        setEnemyHiddenCard();
        loseWin.setForeground(new java.awt.Color(116, 158, 69));
        loseWinBar.setForeground(new java.awt.Color(116, 158, 69));
        howMuchLostWin.setForeground(new java.awt.Color(116, 158, 69));
        betMoneyText.setText("money here");
        betMoneyText.setForeground(new java.awt.Color(204, 204, 204));
        newCradCountText.setText("2");
        newCradCountText.setForeground(new java.awt.Color(255, 255, 0));
        bothNewCradCountText.setText("1");
        bothNewCradCountText.setForeground(new java.awt.Color(255, 153, 0));
        enemyNewCradCountText.setText("1");
        enemyNewCradCountText.setForeground(new java.awt.Color(255, 153, 0));
        betMoneyText.setEnabled(true);
        betMoneyText.setEditable(true);
        betMoneyCheck = true;
    }//GEN-LAST:event_resetButtActionPerformed

    private void backButtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtMouseClicked
        
        StartForm star = new StartForm();
        userLog.clear();
        userLogin.clear();
        userLoginShow.clear();
        userMoney.clear();
        userMoneyShow.clear();
        password.clear();
        this.setVisible(false);
        star.setVisible(true);
        file.setAllListClear();
    }//GEN-LAST:event_backButtMouseClicked

    private void betMoneyTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_betMoneyTextKeyPressed
    if (evt.getKeyCode()==KeyEvent.VK_ENTER){
         if(betMoneyCheck){
            setGamePlay();
        } 
    }
    }//GEN-LAST:event_betMoneyTextKeyPressed

    private void what2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_what2MouseClicked
        HowToPlayCardGame what = new HowToPlayCardGame();
        what.setVisible(true);
    }//GEN-LAST:event_what2MouseClicked

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
            java.util.logging.Logger.getLogger(MyCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyCardGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backButt;
    private javax.swing.JLabel backGround;
    private javax.swing.JButton betButt;
    private javax.swing.JTextField betMoneyText;
    private javax.swing.JButton bothNewCardButt;
    private javax.swing.JTextField bothNewCradCountText;
    private javax.swing.JButton checkButt;
    private javax.swing.JLabel deckOfCard;
    private javax.swing.JLabel enemyCard;
    private javax.swing.JLabel enemyHideCard;
    private javax.swing.JLabel enemyHideCardCover;
    private javax.swing.JButton enemyNewCardButt;
    private javax.swing.JTextField enemyNewCradCountText;
    private javax.swing.JTextField howMuchLostWin;
    private javax.swing.JTextField inputyourbet;
    private javax.swing.JTextField loseWin;
    private javax.swing.JTextField loseWinBar;
    private javax.swing.JLabel moneyPic;
    private javax.swing.JTextField moneyString;
    private javax.swing.JButton newCardButt;
    private javax.swing.JTextField newCradCountText;
    private javax.swing.JLabel ourCard;
    private javax.swing.JLabel ourHideCard;
    private javax.swing.JLabel ourHideCardCover;
    private javax.swing.JButton resetButt;
    private javax.swing.JTextField tooMuch;
    private javax.swing.JTextField usShow;
    private javax.swing.JTextField what2;
    // End of variables declaration//GEN-END:variables
}
