import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.shuffle;

public class CardShuffle {
    public static List<Card> shuffleCards() {
        String[] cardType = {"Clubs", "Spades", "Diamonds", "Hearts"};
        String[] cardValue = {"Ace", "King", "Queen", "Jack", "10",
                "9", "8", "7", "6", "5", "4", "3", "2"};

        List<Card> cards = new ArrayList<Card>();
        for (String s : cardType) {
            for (String value : cardValue) {
                //Generate new Card object and add to list
                cards.add(new Card(value, s));
            }
        }
        shuffle(cards);
        return cards;
    }

    //Sort the cards by their number
    public static List<Card> sortCards(List<Card> cards) {
        for(Card card : cards){
            card.setCardNumber(convertCards(card.getCardNumber()));
        }
        cards.sort(Comparator.comparing(Card::getCardNumber));
        return cards;
    }

    //Sort the cards by their type
    public static List<Card> sortCardsByType(List<Card> cards) {
        for(Card card : cards){
            card.setCardNumber(convertCards(card.getCardNumber()));
        }
        cards.sort(Comparator.comparing(Card::getCardType));
        return cards;
    }

    //Convert Ace,King, Queen and Jack to numbers
    public static String convertCards(String cardNumber){
        if(cardNumber.equals("Ace")) {
            return "11";
        }else if(cardNumber.equals("11")) {
            return "Ace";
        }
        if(cardNumber.equals("King")) {
            return "14";
        }else if(cardNumber.equals("14")){
            return "King";
        }
        if(cardNumber.equals("Queen")) {
            return "13";
        }else if(cardNumber.equals("13")){
            return "Queen";
        }
        if(cardNumber.equals("Jack")) {
            return "12";
        }else if(cardNumber.equals("12")){
            return "Jack";
        }
        return cardNumber;
    }

    public static void main(String[] args) {
        shuffleCards(); // shuffle card at each run
        System.out.println("-------------Shuffled cards: ---------------");
        for (Card c : shuffleCards()) {
            System.out.println(c.getCardNumber() + " " + c.getCardType());
        }
        //sortCards(shuffleCards()); // sort cards by their number
        List <Card> cards = sortCards(shuffleCards()); // sort cards by their number
        System.out.println("-------------Sorted cards: by Number---------------");
        for (Card c : cards) {
            System.out.println(c.getCardNumber() + " " + c.getCardType());
        }

        //shuffleCards(); // shuffle card again
        System.out.println("------------Shuffled cards: ---------------");
        for (Card c : shuffleCards()) {
            System.out.println(c.getCardNumber() + " " + c.getCardType());
        }

        List <Card> newCards = sortCardsByType(sortCards(shuffleCards())); // sort cards by their number
        System.out.println("----------Sorted cards by Type and Number: ------------");
        for (Card c : newCards) {
            System.out.println(c.getCardNumber() + " " + c.getCardType());
        }


    }
}
