import java.util.*;

public class Table {

    public static final Map<String, Character[]> keys;
    static {
        keys = new TreeMap<String, Character[]>();
        keys.put("clubs",    new Character[] {'1', '2', '3', '4', '5', '6', '7', '8'});
        keys.put("diamonds", new Character[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i'});
        keys.put("hearts",   new Character[] {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k'});
        keys.put("spades",   new Character[] {'z', 'x', 'c', 'v', 'b', 'n', 'm', ','});
    }

    private class Hand {

        private String suite;
        private String unicode;
        private ArrayList<Card> cards;

        public Hand(String suite) {
            this.suite = suite;

            unicode = Piquet.unicodes.get(suite);

            cards = new ArrayList<Card>();
        }

        public void addCard(Card card) {
            cards.add(card);
            Collections.sort(cards);
        }

        public void removeCard(Card card) {
            cards.remove(card);
            Collections.sort(cards);
        }

        public String cardString() {
            String output = "|" + unicode;
            for (Card card : cards) {
                output += card.toString() + "|";
            }

            return output;
        }

        public String keyString() {
            String output = "| ";

            for (int i = 0; i < cards.size(); i++) {
                output += " " + Table.keys.get(suite)[i] + "  ";
            }

            return output;
        }
    }

    private String[] template = new String[] {
        "*---Piquet---*",
        "|",
        "|>",
        "|>",
        "|_-\\ Cut <-",
        "|\u2663 ",
        "| ",
        "|\u2666 ",
        "| ",
        "|\u2665 ",
        "| ",
        "|\u2660 ",
        "| "
    };

    private Hand clubs;
    private Hand diamonds;
    private Hand hearts;
    private Hand spades;

    public Table() {
        clubs =    new Hand("clubs");
        diamonds = new Hand("diamonds");
        hearts =   new Hand("hearts");
        spades =   new Hand("spades");

        redrawTable();
    }

    public void robotSlot(Card card) {
        updateRow(2, "|> " + card.toString());
    }

    public void humanSlot(Card card) {
        updateRow(3, "|> " + card.toString());
    }

    public void clearMessage() {
        updateRow(4, "|_-\\");
    }

    public void setMessage(String message) {
        updateRow(4, "|_-\\ " + message);
    }

    public void setMessage(String message, boolean enter) {
        if (enter) {            
            setMessage(message + " <-");
        } else {
            setMessage(message);
        }
    }

    public void addHandCard(Card card) {
        switch (card.getSuite()) {
            case "clubs":    clubs.addCard(card);    break;
            case "diamonds": diamonds.addCard(card); break;
            case "hearts":   hearts.addCard(card);   break;
            case "spades":   spades.addCard(card);   break;
        }

        redrawTable();
    }

    public void removeHandCard(Card card) {
        switch (card.getSuite()) {
            case "clubs":    clubs.removeCard(card);    break;
            case "diamonds": diamonds.removeCard(card); break;
            case "hearts":   hearts.removeCard(card);   break;
            case "spades":   spades.removeCard(card);   break;
        }

        redrawTable();
    }

    private void updateRow(int row, String message) {
        template[row] = message;
        redrawTable();
    }

    private String getRow(int row) {
        return template[row];
    }

    private void redrawTable() {
        // Clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        template[5] = clubs.cardString();
        template[6] = clubs.keyString();

        template[7] = diamonds.cardString();
        template[8] = diamonds.keyString();

        template[9] = hearts.cardString();
        template[10] = hearts.keyString();

        template[11] = spades.cardString();
        template[12] = spades.keyString();

        for (String line : template) {
            System.out.println(line);
        }
    }
}
