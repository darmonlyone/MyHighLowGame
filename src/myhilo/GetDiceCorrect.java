
package myhilo;
import java.util.*;


/**
 * This class use for checking the dice and FaceChooser on MyDiceGame class.
 * 
 * @author Manusporn Fukkham
 */
public class GetDiceCorrect {

    public static boolean checkCorrect(int roll, int rollA, int rollB, int rollC, String choose) {
        if (choose.equals("lo")) return isLow(roll);
        else if (choose.equals("hi")) return isHigh(roll);
        else if (choose.equals("1")) return isFace1(rollA, rollB, rollC);
        else if (choose.equals("2")) return isFace2(rollA, rollB, rollC);
        else if (choose.equals("3")) return isFace3(rollA, rollB, rollC);
        else if (choose.equals("4")) return isFace4(rollA, rollB, rollC);
        else if (choose.equals("5")) return isFace5(rollA, rollB, rollC);
        else if (choose.equals("6")) return isFace6(rollA, rollB, rollC);
        else if (choose.equals("1|5")) return is1and5(rollA, rollB, rollC);
        else if (choose.equals("1|6") || choose.equals("6|1")) return is1and6(rollA, rollB, rollC);
        else if (choose.equals("2|4")) return is2and4(rollA, rollB, rollC);
        else if (choose.equals("2|5") || choose.equals("5|2")) return is2and5(rollA, rollB, rollC);
        else if (choose.equals("3|5")) return is3and5(rollA, rollB, rollC);
        else if (choose.equals("3|6")) return is3and6(rollA, rollB, rollC);
        else if (choose.equals("4|1")) return is4and1(rollA, rollB, rollC);
        else if (choose.equals("6|2")) return is6and2(rollA, rollB, rollC);
        else if (choose.equals("5lo")) return is5lo(rollA, rollB, rollC, roll);
        else if (choose.equals("6lo")) return is6lo(rollA, rollB, rollC, roll);
        else if (choose.equals("11")) return is11hilo(roll);
        else if (choose.equals("123")) return is123(rollA, rollB, rollC);
        else if (choose.equals("456")) return is456(rollA, rollB, rollC);
        else return false;
    }
    public  static boolean isSame(int rollA, int rollB, int rollC){
        return (rollA==rollB && rollA==rollC && rollB==rollC);
    }

    public static boolean isLow(int roll) {
        return (roll > 3 && roll < 11);
    }

    public static boolean isHigh(int roll) {
        return (roll > 10 && roll < 18);
    }

    public static boolean isFace1(int rollA, int rollB, int rollC) {
        return (rollA == 1 || rollB == 1 || rollC == 1);
    }

    public static boolean isFace2(int rollA, int rollB, int rollC) {
        return (rollA == 2 || rollB == 2 || rollC == 2);
    }

    public static boolean isFace3(int rollA, int rollB, int rollC) {
        return (rollA == 3 || rollB == 3 || rollC == 3);
    }

    public static boolean isFace4(int rollA, int rollB, int rollC) {
        return (rollA == 4 || rollB == 4 || rollC == 4);
    }

    public static boolean isFace5(int rollA, int rollB, int rollC) {
        return (rollA == 5 || rollB == 5 || rollC == 5);
    }

    public static boolean isFace6(int rollA, int rollB, int rollC) {
        return (rollA == 6 || rollB == 6 || rollC == 6);
    }

    public static boolean is1and5(int rollA, int rollB, int rollC) {
        return ((rollA == 1 || rollB == 1 || rollC == 1) && (rollA == 5 || rollB == 5 || rollC == 5));
    }

    public static boolean is6and2(int rollA, int rollB, int rollC) {
        return ((rollA == 6 || rollB == 6 || rollC == 6) && (rollA == 2 || rollB == 2 || rollC == 2));
    }

    public static boolean is1and6(int rollA, int rollB, int rollC) {
        return ((rollA == 1 || rollB == 1 || rollC == 1) && (rollA == 6 || rollB == 6 || rollC == 6));
    }

    public static boolean is2and5(int rollA, int rollB, int rollC) {
        return ((rollA == 2 || rollB == 2 || rollC == 2) && (rollA == 5 || rollB == 5 || rollC == 5));
    }

    public static boolean is3and6(int rollA, int rollB, int rollC) {
        return ((rollA == 3 || rollB == 3 || rollC == 3) && (rollA == 6 || rollB == 6 || rollC == 6));
    }

    public static boolean is2and4(int rollA, int rollB, int rollC) {
        return ((rollA == 2 || rollB == 2 || rollC == 2) && (rollA == 4 || rollB == 4 || rollC == 4));
    }

    public static boolean is3and5(int rollA, int rollB, int rollC) {
        return ((rollA == 3 || rollB == 3 || rollC == 3) && (rollA == 5 || rollB == 5 || rollC == 5));
    }

    public static boolean is4and1(int rollA, int rollB, int rollC) {
        return ((rollA == 1 || rollB == 1 || rollC == 1) && (rollA == 4 || rollB == 4 || rollC == 4));
    }

    public static boolean is123(int rollA, int rollB, int rollC) {
        return ((rollA == 1 || rollB == 1 || rollC == 1) && (rollA == 2 || rollB == 2 || rollC == 2) && (rollA == 3 || rollB == 3 || rollC == 3));

    }

    public static boolean is456(int rollA, int rollB, int rollC) {
        return ((rollA == 4 || rollB == 4 || rollC == 4) && (rollA == 5 || rollB == 5 || rollC == 5) && (rollA == 6 || rollB == 6 || rollC == 6));

    }

    public static boolean is5lo(int rollA, int rollB, int rollC, int roll) {
        return ((rollA == 5 || rollB == 5 || rollC == 5) && (roll > 3 && roll < 11));

    }

    public static boolean is6lo(int rollA, int rollB, int rollC, int roll) {
        return ((rollA == 6 || rollB == 6 || rollC == 6) && (roll > 3 && roll < 11));
    }

    public static boolean is11hilo(int roll) {
        return ((roll == 11));
    }
}
