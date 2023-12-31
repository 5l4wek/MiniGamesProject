package pl.minigames.game.dice.input;

import pl.minigames.game.dice.messageprovider.DiceMessageProvider;

import java.util.*;

import static pl.minigames.game.dice.messageprovider.DiceMessageProvider.*;

public class DiceInputReceiver {
    public static void main(String[] args) {
        playDiceGame();
    }

    public static void playDiceGame() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println(DiceMessageProvider.GAME_NAME);

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.println(DiceMessageProvider.ROLL_THE_DICE);
            scanner.nextLine();

            int firstDice = rollDice(random);
            int secondDice = rollDice(random);

            System.out.println(DICE_ONE + firstDice);
            System.out.println(DICE_TWO + secondDice);

            if (firstDice == secondDice) {
                System.out.println(DiceMessageProvider.DICE_WON_RESULT);
                break;
            } else {
                System.out.println(DiceMessageProvider.DICE_LOSE_RESULT);
            }
        }
        System.out.println(DICE_GAME_OVER);
    }

    private static int rollDice(Random random) {
        return random.nextInt(6) + 1;
    }
}



