import java.util.*;

class Human extends Player {

    public Human(Table table) {
        super(table);
    }

    public ArrayList<Card> exchange(ArrayList<Card> talon) {
        Collections.sort(hand);

        for (Card card : hand) {
            table.addHandCard(card);
        }

        table.setMessage('Select Exchange', true);
        Piquet.pause();

        return talon;
    }
}
