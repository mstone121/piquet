public class Card implements Comparable<Card> {
    private String suite;
    private String unicode;    
    private Integer number;

    public Card(String suite, int number) {
        this.suite  = suite;
        this.number = number;

        unicode = Piquet.unicodes.get(suite);
    }

    @Override
    public String toString() {
        String output = "";
        switch (number) {
            case 10: output += "10"; break;
            case 11: output += " J"; break;
            case 12: output += " Q"; break;
            case 13: output += " K"; break;
            case 14: output += " A"; break;
            default: output += " " + number;
        }

        return output + unicode;
    }

    @Override
    public int compareTo(Card card) {
        if (number != card.number) {
            return number - card.number;            
        } else {
            return getSuiteValue() - card.getSuiteValue();
        }
    }

    public int getSuiteValue() {
        int output = -1;
        switch (suite) {
            case "clubs"   : output = 0; break;
            case "diamonds": output = 1; break;
            case "hearts"  : output = 2; break;
            case "spades"  : output = 3; break;
        }

        return output;
    }

    // Cards shouldn't be modifiable
    public String getSuite() {
        return suite;
    }

    public int getNumber() {
        return number;
    }
}
