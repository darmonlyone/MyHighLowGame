/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhilo;
import java.util.List;
import java.awt.Color;
import java.awt.event.*;
import java.io.PrintStream;
/**
 * Login form use for login to play on Hilo Game with your own account.
 * 
 * @author Manusporn Fukkham
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    
    public static List<String> username;
    public static List<String> password;
    public static List<Integer> userMoney;
    public FileSet file = new FileSet();
    
      public LoginForm() {
       
       initComponents();      
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
 public void runLogin(){
     PasswordSolve solvePassword = new PasswordSolve();
     String userLogin = userText.getText();
        String passLogin = passwordGetText.getText();
          file.setUPM();
          username = file.getUsername();
          password = file.getPassword();
          userMoney = file.getUserMoney();
          
        PrintStream logSave = new PrintStream(file.getOutputStreamNewFile());
        
        for (int i = 0 ; i < username.size(); i++){
          if (userLogin.equals(username.get(i))&&solvePassword.verifyPassword(passLogin, password.get(i))){
              logSave.print(username.get(i));
              StartForm start = new StartForm();
                username.clear();
                start.setVisible(true);
                start.fileOpen();
                this.setVisible(false);
                file.setAllListClear();
                logSave.close();
                break;
            }else{
              wrong.setForeground(Color.RED);
          }
                
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

        wrong = new javax.swing.JTextField();
        userText = new javax.swing.JTextField();
        goRegister = new javax.swing.JTextField();
        loginButt = new javax.swing.JButton();
        cancelButt = new javax.swing.JButton();
        passwordGetText = new javax.swing.JPasswordField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wrong.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        wrong.setForeground(new java.awt.Color(255, 255, 255));
        wrong.setText("Wrong username or password");
        wrong.setBorder(null);
        wrong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        wrong.setFocusable(false);
        getContentPane().add(wrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

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
        getContentPane().add(userText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 270, 40));

        goRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        goRegister.setForeground(new java.awt.Color(102, 51, 255));
        goRegister.setText("Click here to create new account");
        goRegister.setToolTipText("");
        goRegister.setBorder(null);
        goRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goRegister.setFocusable(false);
        goRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goRegisterMouseClicked(evt);
            }
        });
        getContentPane().add(goRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        loginButt.setBackground(new java.awt.Color(102, 102, 255));
        loginButt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        loginButt.setForeground(new java.awt.Color(255, 255, 255));
        loginButt.setText("Login");
        loginButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtActionPerformed(evt);
            }
        });
        getContentPane().add(loginButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 120, 70));

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
        getContentPane().add(cancelButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 120, 70));

        passwordGetText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        passwordGetText.setForeground(new java.awt.Color(204, 204, 204));
        passwordGetText.setText("password");
        passwordGetText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordGetTextMouseClicked(evt);
            }
        });
        passwordGetText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordGetTextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordGetTextKeyTyped(evt);
            }
        });
        getContentPane().add(passwordGetText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 270, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageStart/Login.png"))); // NOI18N
        background.setText("0357102284");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTextMouseClicked
        userText.setText("");
        userText.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_userTextMouseClicked

    private void goRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goRegisterMouseClicked
          file.setUPM();
          username = file.getUsername();
          password = file.getPassword();
          userMoney = file.getUserMoney();
        RegisterForm regis = new RegisterForm();
        regis.setVisible(true);
    }//GEN-LAST:event_goRegisterMouseClicked

    private void cancelButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtActionPerformed
        userText.setForeground(new java.awt.Color(204, 204, 204));
        userText.setText("username");
        passwordGetText.setForeground(new java.awt.Color(204, 204, 204));
        passwordGetText.setText("password");
    }//GEN-LAST:event_cancelButtActionPerformed

    private void loginButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtActionPerformed
        runLogin();
    }//GEN-LAST:event_loginButtActionPerformed

    private void passwordGetTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordGetTextMouseClicked
        passwordGetText.setText("");
        passwordGetText.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_passwordGetTextMouseClicked

    private void userTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTextKeyTyped
        if(userText.getText().equals("username")){
            userText.setText("");
            userText.setForeground(new java.awt.Color(0,0,0));   
         }
    }//GEN-LAST:event_userTextKeyTyped

    private void passwordGetTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordGetTextKeyTyped
        if(passwordGetText.getText().equals("password")){
            passwordGetText.setText("");
            passwordGetText.setForeground(new java.awt.Color(0,0,0));
        }
    }//GEN-LAST:event_passwordGetTextKeyTyped

    private void passwordGetTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordGetTextKeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            runLogin();
        }
    }//GEN-LAST:event_passwordGetTextKeyPressed

    private void userTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTextKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            runLogin();
        }     
    }//GEN-LAST:event_userTextKeyPressed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton cancelButt;
    private javax.swing.JTextField goRegister;
    private javax.swing.JButton loginButt;
    private javax.swing.JPasswordField passwordGetText;
    private javax.swing.JTextField userText;
    private javax.swing.JTextField wrong;
    // End of variables declaration//GEN-END:variables
}
