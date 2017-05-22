import java.util.ArrayList;

interface PlayerInterface {
    public ArrayList<Card> exchange(ArrayList<Card> talon);

    public void add(Card card);
}

abstract class Player implements PlayerInterface {
    public ArrayList<Card> hand;
    public Integer score;
    public Integer total;
    public Table   table;

    public Player(Table table) {
        this.hand  = new ArrayList<Card>();
        this.score = 0;
        this.total = 0;
        this.table = table;
    }

    public void add(Card card) {
        hand.add(card);
    }

    public abstract ArrayList<Card> exchange(ArrayList<Card> talon);

}
