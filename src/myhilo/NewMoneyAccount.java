/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhilo;

import java.awt.event.KeyEvent;

/**
 *
 * @author Manusporn Fukkham
 */
public class NewMoneyAccount extends javax.swing.JFrame {

    /**
     * Creates new form newMoneyAccount
     */
    public NewMoneyAccount() {
        setSize(500, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButt = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Alert");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        okButt.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        okButt.setForeground(new java.awt.Color(255, 0, 51));
        okButt.setText("OK");
        okButt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        okButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        okButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtActionPerformed(evt);
            }
        });
        okButt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                okButtKeyPressed(evt);
            }
        });
        getContentPane().add(okButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 100, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageStart/gotmoney.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_okButtActionPerformed

    private void okButtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_okButtKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.setVisible(false);
        }     
    }//GEN-LAST:event_okButtKeyPressed

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
            java.util.logging.Logger.getLogger(NewMoneyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewMoneyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewMoneyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewMoneyAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewMoneyAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton okButt;
    // End of variables declaration//GEN-END:variables
}
