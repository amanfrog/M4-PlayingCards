import javax.swing.ImageIcon; 
// This imports Swing class which is used to load and display card image files(UNTESTED)

class Card { 

    private final String rank; // This will store card ranks (A, 2, K, etc)
    private final String suit; // This will store the clubs, diamonds, hearts, or spades types
    private final String imagePath; // This will store file card imafe paths
    private final ImageIcon icon; // This stores a preloaded image icon for the GUI visuals

    // This is a constructor to create a card
    public Card(String rank, String suit, String imagePath) { 
        this.rank = rank; // Saves rank
        this.suit = suit; // Saves suit
        this.imagePath = imagePath; // Saves image file path
        this.icon = new ImageIcon(imagePath); // THis loads image from the path into an ImageIcon
    }

    public String getRank() { 
        return rank;
    }

    public String getSuit() { 
        return suit;
    }

    public String getImagePath() { 
        return imagePath;
    }

    public ImageIcon getIcon() { 
        return icon;
    }

    public String getDisplayName() { 
        return rank + " of " + suit; // Example of how it displays: "A of spades".
    }
}
