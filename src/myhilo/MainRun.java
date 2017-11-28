/*
 * Main class on running this Program.
 */
package myhilo;

import myhilo.LoginForm;

/**
 *
 * @author Manusporn Fukkham
 */
public class MainRun {
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
