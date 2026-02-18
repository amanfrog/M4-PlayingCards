import java.util.ArrayList; // imports dynamic array implementation for storing cards
import java.util.Collections; // imported utility class that has the shuffle method
import java.util.List; // imports te list interface type for cards

// Class defines a full deck of playing cards
public class Deck { 
    private final List<Card> cards; // private var that stores all cards in the deck

    // This constructor will create all 52 cards
    public Deck(String imageFolder) { 
        cards = new ArrayList<>(); // Initializes
        String[] suits = {"clubs", "diamonds", "hearts", "spades"}; // four suits/card types
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; // there are 13 ranks 

        // For loop that iterates through each suit
        for (String suit : suits) { 

            // For loop that iterates through each rank depending on the current suit/card type
            for (String rank : ranks) { 
                String filePath = imageFolder + "/" + rank + "_of_" + suit + ".jpg"; // image filename creation
                cards.add(new Card(rank, suit, filePath)); // This creates/stores a new 'Card' object
            }
        }
    }

    // shuffle() randomizes the order of the cards in the deck
    public void shuffle() { 
        Collections.shuffle(cards); // built in shuffle method
    }

    public List<Card> getCards() {
        return cards;
    }
}
