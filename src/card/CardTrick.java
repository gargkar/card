/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template...
* @author Karan Garg
Student number-991733104.
 */
 
package card;



import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Define the lucky card
        Card luckyCard = new Card(2, "Clubs");

        // Initialize the cards with random values and suits, ensuring one is the lucky card
        magicHand[0] = luckyCard;  // Place lucky card in the array
        for (int i = 1; i < magicHand.length; i++) {
            int value = random.nextInt(13) + 1; // Card values from 1 to 13
            String suit = Card.SUITS[random.nextInt(Card.SUITS.length)]; // Random suit
            magicHand[i] = new Card(value, suit);
        }

        // Ask user for a card
        System.out.println("Enter a card value (1 to 13):");
        int userValue = scanner.nextInt();
        System.out.println("Enter a suit (Hearts, Diamonds, Clubs, Spades):");
        String userSuit = scanner.next();

        // Create a card object for user's input
        Card userCard = new Card(userValue, userSuit);

        // Search for the card in the magic hand
        boolean found = false;
        boolean isLucky = false;
        for (Card card : magicHand) {
            if (card.equals(userCard)) {
                found = true;
                if (card.equals(luckyCard)) {
                    isLucky = true;
                }
                break;
            }
        }

        if (found) {
            if (isLucky) {
                System.out.println("Congratulations! You found the lucky card!");
            } else {
                System.out.println("Your card was found in the magic hand!");
            }
        } else {
            System.out.println("Your card was not found in the magic hand.");
        }

        scanner.close();
    }
}

class Card {
    private int value;
    private String suit;
    public static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            Card other = (Card) obj;
            return this.value == other.value && this.suit.equalsIgnoreCase(other.suit);
        }
        return false;
    }
}