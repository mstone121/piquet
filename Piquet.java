import java.util.Scanner;

public class Piquet {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // "Menu"
        System.out.print("Please enter your name: ");
        String name = input.nextLine();

        Game game = new Game(name);
        game.cut();

        for (int round = 1; round <= 6; ++round) {
            //            game.deal();
            //            game.exchange();
            //            game.declaration();
            //            game.play();            
        }

        //        game.end();
    }

    public static void pause() {
        input.nextLine();
    }
}
