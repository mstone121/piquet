import java.util.*;

public class Piquet {
    public static final Scanner input = new Scanner(System.in);

    public static final Map<String, String> unicodes;
    static {
        unicodes = new TreeMap<String, String>();
        unicodes.put("clubs",    "\u2663");
        unicodes.put("diamonds", "\u2666");
        unicodes.put("hearts",   "\u2665");
        unicodes.put("spades",   "\u2660");
    }

    public static void main(String[] args) {
        // "Menu"
        System.out.print("Please enter your name: ");
        String name = input.nextLine();

        Game game = new Game(name);
        game.cut();

        for (int partie = 1; partie <= 6; ++partie) {
            game.deal();
            game.exchange();
            //            game.declaration();
            //            game.play();            
        }

        //        game.end();
    }

    public static void pause() {
        input.nextLine();
    }
}
