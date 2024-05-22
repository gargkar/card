/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;


import java.util.Random;
import java.util.Scanner;

public class CardTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Card[] magicHand = new Card[7];

        for (int i = 0; i < magicHand.length; i++) {
            int value = random.nextInt(13) + 1; // Cards from 1 to 13
            int suitIndex = random.nextInt(Card.SUITS.length); // Random suit index
            magicHand[i] = new Card(value, Card.SUITS[suitIndex]);
        }

        System.out.print("Enter a card value (1-13): ");
        int value = scanner.nextInt();
        System.out.print("Enter a suit (Hearts, Diamonds, Clubs, Spades): ");
        String suit = scanner.next();

        Card userCard = new Card(value, suit);

        boolean found = false;
        for (Card card : magicHand) {
            if (card.equals(userCard)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Your card was found in the magic hand!");
        } else {
            System.out.println("Your card was not found in the magic hand.");
        }

        scanner.close();
    }
}

class Card {
    private int value;
    public static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public boolean equals(Card other) {
        return this.value == other.value && this.suit.equalsIgnoreCase(other.suit);
    }
}
