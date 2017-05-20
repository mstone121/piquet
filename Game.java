public class Game {
    private String  name;
    private boolean humanFirst;

    private Deck  deck;
    private Table table;

    public Game(String name) {
        this.name  = name;
        this.table = new Table();
        this.deck  = new Deck();
    }

    public void cut() {
        deck.shuffle();

        Card robotCard = deck.pop();
        Card humanCard = deck.pop();

        table.robotSlot(robotCard);
        table.humanSlot(humanCard);

        if (humanCard.compareTo(robotCard) > 0) {
            humanFirst = true;
            table.setMessage("Player deals first", true);
        } else {
            humanFirst = false;
            table.setMessage("Computer deals first", true);
        }
        
    }
}
