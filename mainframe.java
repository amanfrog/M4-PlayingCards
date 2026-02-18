import java.awt.*; // imports Swing GUI classes
import javax.swing.*; // imports UI base classes like layouts and events

// This is the main window for the displaying and shuffling of cards
class MainFrame extends JFrame { 
    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 120;
    private final Deck deck; // private var that holds the deck model
    private final JPanel cardsPanel; // private var of the panel where the card images are rendered(UNTESTED)

    // This constructor helps set up the UI components/behavior
    public MainFrame() { 
        super("Playing Cards - Shuffle"); // Sets window title

        deck = new Deck("images"); // Here the deck is made by using image files in "images" folder
        cardsPanel = new JPanel(new GridLayout(4, 13, 6, 6)); // 4x13 grid with spacing between cards

        JButton shuffleButton = new JButton("Shuffle Cards"); // shuffle button
        shuffleButton.addActionListener(e -> { // click handler for button
            deck.shuffle(); // calls shuffle() to randomize the order of cards in the deck
            renderCards(); // rendercards() willre-render the panel to show the new order
        });

        setLayout(new BorderLayout(8, 8)); // this uses border layout with outer spacing
        add(new JScrollPane(cardsPanel), BorderLayout.CENTER); // scrollable card grid to center
        add(shuffleButton, BorderLayout.SOUTH); // Button placement on thebottom

        renderCards(); // THe main render when the window is first madee

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit when the window closes
        setSize(1200, 600); // window size tuned to fit 52 scaled cards
        setLocationRelativeTo(null); // window centered
    }

    // rendercards() will refreshe the card display(based on the current order in the deck)
    private void renderCards() { 
        cardsPanel.removeAll();

        // For loop that iterates through every card in deck
        for (Card card : deck.getCards()) { 
            Image scaledImage = card.getIcon().getImage().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH);
            JLabel cardLabel = new JLabel(new ImageIcon(scaledImage)); // this creates the label showing a scaled card image
            cardLabel.setToolTipText(card.getDisplayName()); // this adds for example "Q of hearts"
            cardsPanel.add(cardLabel); // this adds a label to grid panel
        }

        cardsPanel.revalidate(); // revalidate() -> will recalc the layout after adding/removing components
        cardsPanel.repaint(); // repaint() -> updated UI appears on screen
    }
}
