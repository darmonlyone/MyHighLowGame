/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhilo;

import java.awt.Color;
import java.awt.event.KeyEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author hp
 */
public class HowToPlayCardGame extends javax.swing.JFrame {

    /**
     * Creates new form HowToPlayCardGame
     */
    public HowToPlayCardGame() {
        setBackground(Color.BLACK);
        setSize(1200, 600);
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

        what = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        what.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageStart/pathCardreview.png"))); // NOI18N
        what.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        what.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                whatMouseClicked(evt);
            }
        });
        what.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                whatKeyPressed(evt);
            }
        });
        getContentPane().add(what, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void whatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whatMouseClicked
        WhichCardHighest what = new WhichCardHighest();
        what.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_whatMouseClicked

    private void whatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_whatKeyPressed
        WhichCardHighest what = new WhichCardHighest();
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            what.setVisible(true);
        this.setVisible(false);
        }
    }//GEN-LAST:event_whatKeyPressed

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
            java.util.logging.Logger.getLogger(HowToPlayCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HowToPlayCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HowToPlayCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HowToPlayCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HowToPlayCardGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel what;
    // End of variables declaration//GEN-END:variables
}
