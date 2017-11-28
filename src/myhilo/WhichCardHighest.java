/*
 * To show the lowest to highest card.
 * Using on playing Card game.
 */
package myhilo;

import java.awt.Color;
import java.awt.event.KeyEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author hp
 */
public class WhichCardHighest extends javax.swing.JFrame {

    /**
     * Creates new form WhichCardHighest
     */
    public WhichCardHighest() {
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

        highetCard = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        highetCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageStart/pathcardReviewer.png"))); // NOI18N
        highetCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        highetCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                highetCardMouseClicked(evt);
            }
        });
        highetCard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                highetCardKeyPressed(evt);
            }
        });
        getContentPane().add(highetCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void highetCardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_highetCardKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        this.setVisible(false);
    }
    // TODO add your handling code here:
    }//GEN-LAST:event_highetCardKeyPressed

    private void highetCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_highetCardMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_highetCardMouseClicked

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
            java.util.logging.Logger.getLogger(WhichCardHighest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WhichCardHighest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WhichCardHighest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WhichCardHighest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WhichCardHighest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel highetCard;
    // End of variables declaration//GEN-END:variables
}
