package myhilo;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class GetCard {
	
	
	 static Random rd = new Random();
	 static Scanner sc = new Scanner(System.in);
	
	static List<Integer> cardDeck = new ArrayList<Integer>();
	
	// name of the card
	//Spade
	//Heart
	//Diamonds
	//Clubs
	/*
	 * C  D  H  S
	 * 1  2  3  4  : 2
	 * 5  6  7  8  : 3
	 * 9  10 11 12 : 4
	 * 13 14 15 16 : 5
	 * 17 18 19 20 : 6
	 * 21 22 23 24 : 7
	 * 25 26 27 28 : 8
	 * 29 30 31 32 : 9
	 * 33 34 35 36 : 10
	 * 37 38 39 40 : jack
	 * 41 42 43 44 : Queen 
	 * 45 46 47 48 : King
	 * 49 50 51 52 : Ace
	 *  
	 */
	
                
	public static int randomCard(){
        return rd.nextInt(cardDeck.size())+1;
    }

	public static void addCard(){
		cardDeck.clear();
		for(int i = 0 ; i < 52 ; i++){
			cardDeck.add(i+1);
		}
	}
	public static void removeCard(int remove){
		cardDeck.remove(remove-(53-cardDeck.size()));
	}
	public static String getPicCard(int cardNum){
            switch (cardNum) {
                case 0:
                    return "/ImageCard/BackCard.png";
                case 1:
                    return "/ImageCard/2Clubs.png";
                case 2:
                    return "/ImageCard/2Diamonds.png";
                case 3:
                    return "/ImageCard/2Heart.png";
                case 4:
                    return "/ImageCard/2Spade.png";
                case 5:
                    return "/ImageCard/3Clubs.png";
                case 6:
                    return "/ImageCard/3Diamonds.png";
                case 7:
                    return "/ImageCard/3Heart.png";
                case 8:
                    return "/ImageCard/3Spade.png";
                case 9:
                    return "/ImageCard/4Clubs.png";
                case 10:
                    return "/ImageCard/4Diamonds.png";
                case 11:
                    return "/ImageCard/4Heart.png";
                case 12:
                    return "/ImageCard/4Spade.png";
                case 13:
                    return "/ImageCard/5Clubs.png";
                case 14:
                    return "/ImageCard/5Diamonds.png";
                case 15:
                    return "/ImageCard/5Heart.png";
                case 16:
                    return "/ImageCard/5Spade.png";
                case 17:
                    return "/ImageCard/6Clubs.png";
                case 18:
                    return "/ImageCard/6Diamonds.png";
                case 19:
                    return "/ImageCard/6Heart.png";
                case 20:
                    return "/ImageCard/6Spade.png";
                case 21:
                    return "/ImageCard/7Clubs.png";
                case 22:
                    return "/ImageCard/7Diamonds.png";
                case 23:
                    return "/ImageCard/7Heart.png";
                case 24:
                    return "/ImageCard/7Spade.png";
                case 25:
                    return "/ImageCard/8Clubs.png";
                case 26:
                    return "/ImageCard/8Diamonds.png";
                case 27:
                    return "/ImageCard/8Heart.png";
                case 28:
                    return "/ImageCard/8Spade.png";
                case 29:
                    return "/ImageCard/9Clubs.png";
                case 30:
                    return "/ImageCard/9Diamonds.png";
                case 31:
                    return "/ImageCard/9Heart.png";
                case 32:
                    return "/ImageCard/9Spade.png";
                case 33:
                    return "/ImageCard/10Clubs.png";
                case 34:
                    return "/ImageCard/10Diamonds.png";
                case 35:
                    return "/ImageCard/10Heart.png";
                case 36:
                    return "/ImageCard/10Spade.png";
                case 37:
                    return "/ImageCard/JackClubs.png";
                case 38:
                    return "/ImageCard/JackDiamonds.png";
                case 39:
                    return "/ImageCard/JackHeart.png";
                case 40:
                    return "/ImageCard/JackSpade.png";
                case 41:
                    return "/ImageCard/QueenClubs.png";
                case 42:
                    return "/ImageCard/QueenDiamonds.png";
                case 43:
                    return "/ImageCard/QueenHeart.png";
                case 44:
                    return "/ImageCard/QueenSpade.png";
                case 45:
                    return "/ImageCard/KingClubs.png";
                case 46:
                    return "/ImageCard/KingDiamonds.png";
                case 47:
                    return "/ImageCard/KingHeart.png";
                case 48:
                    return "/ImageCard/KingSpade.png";
                case 49:
                    return "/ImageCard/AClubs.png";
                case 50:
                    return "/ImageCard/ADiamonds.png";
                case 51:
                    return "/ImageCard/AHeart.png";
                case 52:
                    return "/ImageCard/ASpade.png";
                case 53:
                    return "/ImageCard/FaceCard.png";
                case 54:
                    return "/ImageCard/HiddenCard.png";
                default:
                    return null;
            }
	}
	
	
	public static void testConsol(){
	addCard();
	
	int player = randomCard();
	removeCard(player);
	int bot = randomCard();
	removeCard(bot);
	for(Integer card: cardDeck){
		System.out.println(card);
	}
	System.out.println(player);
	System.out.println(bot);
	
		
	}
	
}
