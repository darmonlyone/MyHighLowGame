/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhilo;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.*;
import org.mindrot.jbcrypt.BCrypt;

/**
 * This class for regis an useraccount to play on Hilo application.
 * 
 * @author Manusporn Fukkham
 */
public class RegisterForm extends  javax.swing.JFrame {

    /**
     * Creates new form registerForm
     */
    private LoginForm login = new LoginForm();
    private FileSet file = new FileSet();
    
    public RegisterForm() {
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        passwordAction.setVisible(false);
         
    }
    public boolean isUsernameUse(){
        for(String userUse : login.username){
            if(userText.getText().equals(userUse))
                return false;
        }
       return true; 
    }
    
    
    public void runCreateAccount(){
        PrintStream logSave = new PrintStream(file.getOutputStreamUPM());
        PasswordSolve solvePassword = new PasswordSolve();
        
        if(!isUsernameUse()) {
             wrongText.setText("This Username already use");
            wrongText.setForeground(Color.red);
        }
        else if(!passWordGetText1.getText().equals(passWordGetText2.getText())) {
            wrongText.setText("Retype password are not correct");
            wrongText.setForeground(Color.red);
        }else if(!solvePassword.isPasswordOkay(passWordGetText1.getText())){
            String what = passWordGetText1.getText();
            wrongText.setForeground(Color.red);
            if(!solvePassword.isHave6Letter(what))
                wrongText.setText("Password should more than 6 letter");
            else wrongText.setText("Please put some number and letter with some upper case");
            
            cautionsText.setForeground(Color.red);
            cautionsText.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        }else if (passWordGetText1.getText().equals(passWordGetText2.getText())){
             for (int i = 0 ; i < login.username.size();i++){
            logSave.println(login.username.get(i)+" : "+login.password.get(i)+" : "+login.userMoney.get(i));
            }
            logSave.println(userText.getText()+" : "+BCrypt.hashpw(passWordGetText1.getText(), BCrypt.gensalt())+" : "+"2000");
            this.setVisible(false);
            login.username.clear();
            login.password.clear();
            login.userMoney.clear();
            new Alert("NewAccount").setVisible(true);
            file.setAllListClear();
                }
       logSave.close();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cautionsText = new javax.swing.JTextField();
        passwordAction = new javax.swing.JTextArea();
        cancelButt = new javax.swing.JButton();
        regisButt = new javax.swing.JButton();
        userText = new javax.swing.JTextField();
        passWordGetText2 = new javax.swing.JPasswordField();
        passWordGetText1 = new javax.swing.JPasswordField();
        wrongText = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cautionsText.setBackground(new java.awt.Color(204, 204, 204));
        cautionsText.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        cautionsText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cautionsText.setText("?");
        cautionsText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cautionsText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cautionsText.setFocusable(false);
        cautionsText.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cautionsTextMouseMoved(evt);
            }
        });
        getContentPane().add(cautionsText, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 40, 40));

        passwordAction.setColumns(20);
        passwordAction.setLineWrap(true);
        passwordAction.setRows(5);
        passwordAction.setWrapStyleWord(true);
        passwordAction.setFocusable(false);
        getContentPane().add(passwordAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 200, 110));

        cancelButt.setBackground(new java.awt.Color(255, 51, 51));
        cancelButt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cancelButt.setForeground(new java.awt.Color(255, 255, 255));
        cancelButt.setText("Cancel");
        cancelButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 120, 70));

        regisButt.setBackground(new java.awt.Color(102, 102, 255));
        regisButt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        regisButt.setForeground(new java.awt.Color(255, 255, 255));
        regisButt.setText("Regis");
        regisButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regisButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisButtActionPerformed(evt);
            }
        });
        getContentPane().add(regisButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 120, 70));

        userText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userText.setForeground(new java.awt.Color(204, 204, 204));
        userText.setText("username");
        userText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTextMouseClicked(evt);
            }
        });
        userText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userTextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userTextKeyTyped(evt);
            }
        });
        getContentPane().add(userText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 270, 40));

        passWordGetText2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        passWordGetText2.setForeground(new java.awt.Color(204, 204, 204));
        passWordGetText2.setText("password");
        passWordGetText2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passWordGetText2MouseClicked(evt);
            }
        });
        passWordGetText2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passWordGetText2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passWordGetText2KeyTyped(evt);
            }
        });
        getContentPane().add(passWordGetText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 210, 40));

        passWordGetText1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        passWordGetText1.setForeground(new java.awt.Color(204, 204, 204));
        passWordGetText1.setText("password");
        passWordGetText1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passWordGetText1MouseClicked(evt);
            }
        });
        passWordGetText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passWordGetText1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passWordGetText1KeyTyped(evt);
            }
        });
        getContentPane().add(passWordGetText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 270, 40));

        wrongText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wrongText.setForeground(new java.awt.Color(255, 255, 255));
        wrongText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wrongText.setText("Retype password are not correct");
        wrongText.setBorder(null);
        wrongText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        wrongText.setFocusable(false);
        getContentPane().add(wrongText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 440, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageStart/register.png"))); // NOI18N
        background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                backgroundMouseMoved(evt);
            }
        });
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtActionPerformed
       PrintStream logSave = new PrintStream(file.getOutputStreamUPM());
        for (int i = 0 ; i < login.username.size();i++){
            logSave.println(login.username.get(i)+" : "+login.password.get(i)+" : "+login.userMoney.get(i));
            }
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtActionPerformed

    private void userTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTextMouseClicked
        userText.setText("");
        userText.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_userTextMouseClicked

    private void regisButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisButtActionPerformed
        runCreateAccount();
    }//GEN-LAST:event_regisButtActionPerformed

    private void passWordGetText1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passWordGetText1MouseClicked
       passWordGetText1.setText("");
       passWordGetText1.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_passWordGetText1MouseClicked

    private void passWordGetText2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passWordGetText2MouseClicked
       passWordGetText2.setText("");
       passWordGetText2.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_passWordGetText2MouseClicked

    private void userTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTextKeyTyped
        if(userText.getText().equals("username")){
            userText.setText("");
            userText.setForeground(new java.awt.Color(0,0,0));
        }
    }//GEN-LAST:event_userTextKeyTyped

    private void passWordGetText1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passWordGetText1KeyTyped
        if(passWordGetText1.getText().equals("password")){
            passWordGetText1.setText("");
            passWordGetText1.setForeground(new java.awt.Color(0,0,0));
        }
    }//GEN-LAST:event_passWordGetText1KeyTyped

    private void passWordGetText2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passWordGetText2KeyTyped
       if(passWordGetText2.getText().equals("password")){
            passWordGetText2.setText("");
            passWordGetText2.setForeground(new java.awt.Color(0,0,0));
        }
        
    }//GEN-LAST:event_passWordGetText2KeyTyped

    private void passWordGetText2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passWordGetText2KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            runCreateAccount();
        }      
    }//GEN-LAST:event_passWordGetText2KeyPressed

    private void userTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTextKeyPressed
       if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            runCreateAccount();
        }
    }//GEN-LAST:event_userTextKeyPressed

    private void passWordGetText1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passWordGetText1KeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            runCreateAccount();
        }
    }//GEN-LAST:event_passWordGetText1KeyPressed

    private void cautionsTextMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cautionsTextMouseMoved
       cautionsText.setBackground(Color.red);
       passwordAction.setText("Use at least 6 characters. Don’t " +
                                "use a password too obvious like " +
                                "your pet’s name. You have to use at least " +
                                "1 Capital letter and normal letter" +
                                "");
       passwordAction.setVisible(true);
      
    }//GEN-LAST:event_cautionsTextMouseMoved

    private void backgroundMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseMoved
        cautionsText.setBackground(new java.awt.Color(204, 204, 204));
        passwordAction.setVisible(false);
    }//GEN-LAST:event_backgroundMouseMoved

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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton cancelButt;
    private javax.swing.JTextField cautionsText;
    private javax.swing.JPasswordField passWordGetText1;
    private javax.swing.JPasswordField passWordGetText2;
    private javax.swing.JTextArea passwordAction;
    private javax.swing.JButton regisButt;
    private javax.swing.JTextField userText;
    private javax.swing.JTextField wrongText;
    // End of variables declaration//GEN-END:variables
}
