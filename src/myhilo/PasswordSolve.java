/*
 * This class use for check password that are 
 * strong password enough to regis
 */
package myhilo;

import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author Manusporn Fukkham
 */
class PasswordSolve {
    
//   private static String encryptedPassword;

    public  boolean isHaveNumber(String pass){
        try {
			Integer.parseInt(pass);
			return false;
	} catch(NumberFormatException ex) {
			return true;
		}
    }
    public  boolean isHaveLower(String pass){
        if(isHaveNumber(pass)){
            if(pass.toLowerCase().equals(pass))return false;
            else return true;
        }else
        return false;
    }
    public  boolean isHaveUpper(String pass){
         if(isHaveNumber(pass)){
            if(pass.toUpperCase().equals(pass))return false;
            else return true;
        }else
        return false;
    }
     public  boolean isHaveLetter(String pass){
         if(isHaveLower(pass)&&isHaveUpper(pass))
             return true;
         else return false;
     }
     public  boolean isHave6Letter(String pass){
         if(pass.length()>=6)return true;
         else return false;
     }
     public  boolean isPasswordOkay(String pass){
         if(isHave6Letter(pass)&&isHaveLetter(pass))
             return true;
         else return false;
     }
     public boolean verifyPassword(String pass,String passCheck) {
		return BCrypt.checkpw(pass, passCheck);
	}
     public String letHash(String pass){
         return BCrypt.hashpw(pass, BCrypt.gensalt());
         
     }
     
     /*
     For testing is its pass word
     */
//    public static void main(String[] args) {
//        String a = "darm";
//        String b = "Darm123";
//        String c = "darm123";
//        String d = "Darm3";
//        String e = "123";
//        String f = "123Darm";
//        String g = "123456";
//        String h = "123ADG";
//        String i = "ASdd1";
//        String j = "//112233";
//        
//        encryptedPassword = BCrypt.hashpw(a, BCrypt.gensalt());
//        System.out.println(encryptedPassword);
//        b = BCrypt.hashpw(a, BCrypt.gensalt());
//        System.out.println(b);
//        
// 
//        System.out.println(verifyPassword("darm", encryptedPassword));
//        System.out.println(encryptedPassword);
//        System.out.println(b);
//        System.out.printf("a = %b%n",isPasswordOkay(a));
//        System.out.printf("b = %b%n",isPasswordOkay(b));
//        System.out.printf("c = %b%n",isPasswordOkay(c));
//        System.out.printf("d = %b%n",isPasswordOkay(d));
//        System.out.printf("e = %b%n",isPasswordOkay(e));
//        System.out.printf("f = %b%n",isPasswordOkay(f));
//        System.out.printf("g = %b%n",isPasswordOkay(g));
//        System.out.printf("h = %b%n",isPasswordOkay(h));
//        System.out.printf("i = %b%n",isPasswordOkay(i));
//        System.out.printf("j = %b%n",isPasswordOkay(j));
//    }
    
}
