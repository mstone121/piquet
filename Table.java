import java.util.TreeMap;
import java.util.Map;

public class Table {
    private static final Map<String, Character[]> keys;
    static {
        keys = new TreeMap<String, Character[]>();
        keys.put("clubs",    new Character[] {'1', '2', '3', '4', '5', '6', '7', '8'});
        keys.put("diamonds", new Character[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i'});
        keys.put("hearts",   new Character[] {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k'});
        keys.put("spades",   new Character[] {'z', 'x', 'c', 'v', 'b', 'n', 'm', ','});
    }

    private Map<String, Integer> suiteCounts;

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

    public Table() {
        suiteCounts = new TreeMap<String, Integer>();
        suiteCounts.put("clubs",    0);
        suiteCounts.put("diamonds", 0);
        suiteCounts.put("hearts",   0);
        suiteCounts.put("spades",   0);

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
        int row = -1;
        switch (card.getSuite()) {
            case "clubs"   : row = 5; break;
            case "diamonds": row = 7; break;
            case "hearts"  : row = 9; break;
            case "spades"  : row = 11; break;
        }

        String suiteRow = getRow(row);
        updateRow(row, suiteRow + card.toString() + '|');

        updateRow(row + 1, "| ");
        addSuiteCard(card.getSuite());
        for (int i = 0; i < suiteCounts.get(card.getSuite()); i++) {
            updateRow(row + 1, getRow(row + 1) + "  " + keys.get(card.getSuite())[i] + " ");
        }
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

        for (String line : template) {
            System.out.println(line);
        }
    }

    private void addSuiteCard(String suite) {
        suiteCounts.put(suite, suiteCounts.get(suite) + 1);
    }

    private void removeSuiteCard(String suite) {
        suiteCounts.put(suite, suiteCounts.get(suite) - 1);
    }
}
