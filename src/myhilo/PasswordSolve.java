/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
   
   
    public  boolean isHaveNumber(String what){
        try {
			Integer.parseInt(what);
			return false;
	} catch(NumberFormatException ex) {
			return true;
		}
    }
    public  boolean isHaveLower(String what){
        if(isHaveNumber(what)){
            if(what.toLowerCase().equals(what))return false;
            else return true;
        }else
        return false;
    }
    public  boolean isHaveUpper(String what){
         if(isHaveNumber(what)){
            if(what.toUpperCase().equals(what))return false;
            else return true;
        }else
        return false;
    }
     public  boolean isHaveLetter(String what){
         if(isHaveLower(what)&&isHaveUpper(what))
             return true;
         else return false;
     }
     public  boolean isHave6Letter(String what){
         if(what.length()>=6)return true;
         else return false;
     }
     public  boolean isPasswordOkay(String what){
         if(isHave6Letter(what)&&isHaveLetter(what))
             return true;
         else return false;
     }
     public boolean verifyPassword(String what,String whatda) {
		return BCrypt.checkpw(what, whatda);
	}
     public String letHash(String what){
         return BCrypt.hashpw(what, BCrypt.gensalt());
         
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
