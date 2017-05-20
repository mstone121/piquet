public class Table {
    private String[] template = new String[] {
        "*---Piquet---*",
        "|",
        "|>    ",
        "|>    ",
        "|_-\\ Cut <-",
        "|\u2663",
        "|",
        "|\u2666",
        "|",
        "|\u2665",
        "|",
        "|\u2660"
    };

    public Table() {
        redrawTable();
    }

    public void robotSlot(Card card) {
        template[2] = "|> " + card.toString();
        redrawTable();
    }

    public void humanSlot(Card card) {
        template[3] = "|> " + card.toString();
        redrawTable();
    }

    public void clearMessage() {
        template[4] = "|_-\\";
        redrawTable();
    }

    public void setMessage(String message) {
        template[4] = "|_-\\ " + message;
    }

    public void setMessage(String message, boolean enter) {
        if (enter) {            
            setMessage(message + " <-");
        } else {
            setMessage(message);
        }
    }

    private void redrawTable() {
        // Clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (String line : template) {
            System.out.println(line);
        }
    }
}
