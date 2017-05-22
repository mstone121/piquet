import java.util.ArrayList;

public class Game {
    private String  name;
    private boolean humanFirst;

    private Deck  deck;
    private Table table;

    private Player human;
    private Player robot;

    private Player yungr; // Alignment > Spelling
    private Player elder;

    private ArrayList<Card> talon;

    public Game(String name) {
        this.name  = name;
        this.table = new Table();
        this.deck  = new Deck();
        this.human = new Human(table);
        this.robot = new Robot(table);
    }

    public void cut() {
        deck.shuffle();

        Card robotCard = deck.pop();
        Card humanCard = deck.pop();

        table.robotSlot(robotCard);
        table.humanSlot(humanCard);

        if (humanCard.compareTo(robotCard) > 0) {
            yungr = human;
            elder = robot;
            table.setMessage("Player deals first", true);
        } else {
            yungr = robot;
            elder = human;
            table.setMessage("Computer deals first", true);
        }

        deck.push(robotCard);
        deck.push(humanCard);

        Piquet.pause();
    }

    public void deal() {
        for (int i = 0; i < 12; i++) {
            System.out.println("i: " + i);
            System.out.println("c: " + deck.size());
            elder.add(deck.pop());
            yungr.add(deck.pop());
        }

        talon = new ArrayList<Card>();
        while (deck.size() > 0) {
            talon.add(deck.pop());
        }
    }

    public void exchange() {
        talon = elder.exchange(talon);
        talon = yungr.exchange(talon);
    }
}
