/*
 * This class for running test as console
 * Also use for checking the dice and FaceChooser on MyDiceGame class.
 */
package myhilo;
import java.util.*;


/**
 *
 * @author Manusporn Fukkham
 */
public class GetDiceCorrect {

   static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    static String[] x1 = {"hi", "lo", "1", "2", "3", "4", "5", "6"};
    static String[] x2 = {"1|5", "1|6", "2|5", "3|6", "2|4", "3|5", "4|1", "5|2", "6|1", "6|2"};
    static String[] x3 = {"123", "456", "5lo", "6lo"};
    static String[] x5 = {"11"};
    static ArrayList<String> xx1 = new ArrayList<String>();
    static ArrayList<String> xx2 = new ArrayList<String>();
    static ArrayList<String> xx3 = new ArrayList<String>();
    static ArrayList<String> xx5 = new ArrayList<String>();
//    static int roll ,rollB,rollC;
            static int rollA = rollingDice();
             static int rollB = rollingDice();
             static int rollC = rollingDice();
             static int roll = rollA + rollB + rollC;
    
    public static int rollingDice(){
        return rd.nextInt(6)+1;
    }
    
    public static void maintodo() {
        
        List<String> newList1 = Arrays.asList(x1);
        List<String> newList2 = Arrays.asList(x2);
        List<String> newList3 = Arrays.asList(x3);
        List<String> newList5 = Arrays.asList(x5);
        xx1.addAll(newList1);
        xx2.addAll(newList2);
        xx3.addAll(newList3);
        xx5.addAll(newList5);
          
            

    }
    
     public static void mainner(){
           int money = 1000;
        while (true){
             

            System.out.printf("You have money: %d bath.%n%n",money);


            System.out.println("Choose your bet");
            System.out.printf("%3s    %3s     %8s     %3s   %3s%n", "1|5", "5lo", "11 hilo", "6lo", "6|2");
            System.out.printf("%3s    %3s    %3s    %3s    %3s   %3s%n", "1|6", "1", "hi", "lo", "6", "6|1");
            System.out.printf("%3s    %3s    %3s    %3s    %3s   %3s%n", "2|5", "2", "3", "4", "5", "5|2");
            System.out.printf("%3s    %3s    %3s    %3s    %3s   %3s%n", "123", "3|6", "2|4", "3|5", "4|1", "456");
            System.out.println("");
            System.out.print("What u will choose: ");
            String choose = sc.next();
            System.out.print("How much u bet: ");
            int yourMoney = sc.nextInt();


            System.out.println("");
            System.out.printf("Roll got  %d  %d  %d  Total: %d%n", rollA, rollB, rollC, roll);




            int moneyBack = howMuchYouGot(choose);

            boolean check = checkCorrect(roll, rollA, rollB, rollC, choose);

            if (isSame(rollA, rollB, rollC)){
                money -= yourMoney;
                System.out.println("You lost");
            } else if(check){
                money +=(yourMoney*moneyBack);
                System.out.printf("You win, get money back +%d%n",yourMoney*moneyBack);
            }else{
                money -= yourMoney;
                System.out.println("You lost");
            }
            System.out.println("");
        }





/*for checking correct case*/
//        System.out.println("low "+isLow(roll));
//        System.out.println("high "+isHigh(roll));
//        System.out.println("face1 "+isFace1(rollA,rollB,rollC));
//        System.out.println("face2 "+isFace2(rollA,rollB,rollC));
//        System.out.println("face3 "+isFace3(rollA,rollB,rollC));
//        System.out.println("face1 "+isFace4(rollA,rollB,rollC));
//        System.out.println("face5 "+isFace5(rollA,rollB,rollC));
//        System.out.println("face6 "+isFace6(rollA,rollB,rollC));
//        System.out.println("1|5 "+is1and5(rollA,rollB,rollC));
//        System.out.println("1|6 "+is1and6(rollA,rollB,rollC));
//        System.out.println("2|4 "+is2and4(rollA,rollB,rollC));
//        System.out.println("2|5 "+is2and5(rollA,rollB,rollC));
//        System.out.println("3|5 "+is3and5(rollA,rollB,rollC));
//        System.out.println("3|6 "+is3and6(rollA,rollB,rollC));
//        System.out.println("4|1 "+is4and1(rollA,rollB,rollC));
//        System.out.println("6|2 "+is6and2(rollA,rollB,rollC));
//        System.out.println("5lo "+is5lo(rollA,rollB,rollC,roll));
//        System.out.println("6lo "+is6lo(rollA,rollB,rollC,roll));
//        System.out.println("hilo "+is11hilo(roll));
//        System.out.println("123 "+is123(rollA,rollB,rollC));
//        System.out.println("456 "+is456(rollA,rollB,rollC));

     }
      
    

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

    public static int howMuchYouGot(String choose) {
        if (xx1.contains(choose)) return 1;
        else if (xx2.contains(choose)) return 2;
        else if (xx3.contains(choose)) return 3;
        else if (xx5.contains(choose)) return 5;
        else return 0;
    }

    
}
