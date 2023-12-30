package pl.minigames.game.dice.input;

import pl.minigames.game.dice.messageprovider.DiceMessageProvider;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DiceInputReceiver {
    public Set<Integer> getSixNumbersTwice(Scanner scanner) {
        Set<Integer> givenNumbersFromUser = getNumbersFromRollDice(scanner);
        scanner.close();
        return givenNumbersFromUser;
    }

    private Set<Integer> getNumbersFromRollDice(Scanner in) {

        final Set<Integer> givenNumbersFromFirstDie = new HashSet<>();
        final Set<Integer> givenNumbersFromSecondDie = new HashSet<>();

        System.out.println(String.format(DiceMessageProvider.ROLL_TWO_DICE));

        if (givenNumbersFromFirstDie == givenNumbersFromSecondDie) {
            System.out.println(DiceMessageProvider.DICE_WON_RESULT);
        }
        if (givenNumbersFromFirstDie != givenNumbersFromFirstDie) {
            System.out.println(DiceMessageProvider.TWO_MORE_TRY);
        }
        if (givenNumbersFromFirstDie != givenNumbersFromSecondDie) {
            System.out.println(DiceMessageProvider.ONE_MORE_TRY);
        }
        if (givenNumbersFromFirstDie != givenNumbersFromSecondDie) {
            System.out.println(DiceMessageProvider.DICE_LOSE_RESULT);
        }

        return Collections.emptySet();
    }
}



