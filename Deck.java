import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {    
    public static final String[] suites = new String[] {"clubs", "diamonds", "hearts", "spades"};

    LinkedList<Card> cards;

    public Deck() {
        this.cards = new LinkedList<Card>();
        for (String suite : suites) {
            for (int i = 7; i <= 14; i++) {
                cards.add(new Card(suite, i));
            }
        }
    }

    // Yates-Fisher
    public void shuffle() {
        for(int i = 0; i < cards.size(); i++) {
            Card temp = cards.get(i);
            int j = ThreadLocalRandom.current().nextInt(i, cards.size());

            cards.add(i, cards.get(j));
            cards.remove(i + 1);

            cards.add(j, temp);
            cards.remove(j + 1);
        }
    }

    public Card pop() {
        return cards.remove();
    }

    public void push(Card card) {
        cards.add(card);
    }
}
