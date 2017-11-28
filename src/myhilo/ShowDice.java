/*
 * This class for for return a Picture file name.
 */
package myhilo;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.*;

/**
 *
 * @author Manusporn Fukkham
 */
public class ShowDice extends JButton implements ActionListener{
    ImageIcon rollA1,rollA2,rollA3,rollA4,rollA5,rollA6;
    ImageIcon rollB1,rollB2,rollB3,rollB4,rollB5,rollB6;
    ImageIcon rollC1,rollC2,rollC3,rollC4,rollC5,rollC6;
    
    
    
    public ShowDice(){
//        rollA1 = new ImageIcon(this.getClass().getResource("/Image/roll1.png"));
//        rollB1 = new ImageIcon(this.getClass().getResource("/Image/roll1.png"));
//        rollC1 = new ImageIcon(this.getClass().getResource("/Image/roll1.png"));
//        rollA2 = new ImageIcon(this.getClass().getResource("/Image/roll2.png"));
//        rollB2 = new ImageIcon(this.getClass().getResource("/Image/roll2.png"));
//        rollC2 = new ImageIcon(this.getClass().getResource("/Image/roll2.png"));
//        rollA3 = new ImageIcon(this.getClass().getResource("/Image/roll3.png"));
//        rollB3 = new ImageIcon(this.getClass().getResource("/Image/roll3.png"));
//        rollC3 = new ImageIcon(this.getClass().getResource("/Image/roll3.png"));
//        rollA4 = new ImageIcon(this.getClass().getResource("/Image/roll4.png"));
//        rollB4 = new ImageIcon(this.getClass().getResource("/Image/roll4.png"));
//        rollC4 = new ImageIcon(this.getClass().getResource("/Image/roll4.png"));
//        rollA5 = new ImageIcon(this.getClass().getResource("/Image/roll5.png"));
//        rollB5 = new ImageIcon(this.getClass().getResource("/Image/roll5.png"));
//        rollC5 = new ImageIcon(this.getClass().getResource("/Image/roll5.png"));
//        rollA6 = new ImageIcon(this.getClass().getResource("/Image/roll6.png"));
//        rollB6 = new ImageIcon(this.getClass().getResource("/Image/roll6.png"));
//        rollC6 = new ImageIcon(this.getClass().getResource("/Image/roll6.png"));
//        this.addActionListener(this);
//         if(rollA==1){
//             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll1.png")));
//             dice1.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice1.png")));
//        }if(rollA==2){
//             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll2.png")));
//             dice1.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice2.png")));
//        }if(rollA==3){
//             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll3.png")));
//             dice1.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice3.png")));
//        }if(rollA==4){
//             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll4.png")));
//             dice1.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice4.png")));
//        }if(rollA==5){
//             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll5.png")));
//             dice1.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice5.png")));
//        }if(rollA==6){
//             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll6.png")));
//             dice1.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice6.png")));
//        }
//         if(rollB==1){
//             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll1.png")));
//             dice2.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice1.png")));
//        }if(rollB==2){
//             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll2.png")));
//             dice2.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice2.png")));
//        }if(rollB==3){
//             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll3.png")));
//             dice2.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice3.png")));
//        }if(rollB==4){
//             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll4.png")));
//             dice2.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice4.png")));
//        }if(rollB==5){
//             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll5.png")));
//             dice2.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice5.png")));
//        }if(rollB==6){
//             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll6.png")));
//             dice2.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice6.png")));
//        }
//         if(rollC==1){
//             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll1.png")));
//             dice3.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice1.png")));
//        }if(rollC==2){
//             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll2.png")));
//             dice3.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice2.png")));
//        }if(rollC==3){
//             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll3.png")));
//             dice3.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice3.png")));
//        }if(rollC==4){
//             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll4.png")));
//             dice3.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice4.png")));
//        }if(rollC==5){
//             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll5.png")));
//             dice3.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice5.png")));
//        }if(rollC==6){
//             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageDice/roll6.png")));
//             dice3.setIcon(new ImageIcon(getClass().getResource("/ImageDice/dice6.png")));
//        }
    }
    
    public String getImageRollBig(int roll){
        switch (roll) {
            case 1:
                return "/ImageDice/roll1.png";
            case 2:
                return "/ImageDice/roll2.png";
            case 3:
                return "/ImageDice/roll3.png";
            case 4:
                return "/ImageDice/roll4.png";
            case 5:
                return "/ImageDice/roll5.png";
            case 6:
                return "/ImageDice/roll6.png";
            default:
                return null;
        }
        
    }
    public String getImageRollSmall(int roll){
        switch (roll) {
            case 1:
                return "/ImageDice/dice1.png";
            case 2:
                return "/ImageDice/dice2.png";
            case 3:
                return "/ImageDice/dice3.png";
            case 4:
                return "/ImageDice/dice4.png";
            case 5:
                return "/ImageDice/dice5.png";
            case 6:
                return "/ImageDice/dice6.png";
            default:
                return null;
        }
    }

    public void actionPerformed(ActionEvent e) {
        setIcon(rollA1);
    }
}
