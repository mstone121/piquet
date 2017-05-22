public class Game {
    private String  name;
    private boolean humanFirst;

    private Deck  deck;
    private Table table;

    private Player human;
    private Player robot;

    private Player yungr; // Alignment > Spelling
    private Player elder;

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
}
