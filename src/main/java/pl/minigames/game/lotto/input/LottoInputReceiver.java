package pl.minigames.game.lotto.input;

import pl.minigames.game.lotto.message.LottoMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static pl.minigames.game.lotto.controller.LottoGameController.*;

public class LottoInputReceiver {

    public Set<Integer> getRandomNumbers(Scanner scanner) {
        Set<Integer> numbersFromUser = getNumbersFromUser(scanner);
        scanner.close();
        return numbersFromUser;
    }

    private Set<Integer> getNumbersFromUser(Scanner in) {
        final Set<Integer> givenNumbers = new HashSet<>();
        System.out.println(String.format(LottoMessage.PASS_THE_NUMBERS, TOTAL_FROM_USER));
        while (areLessThanSixNumbersGiven(givenNumbers)) {
            System.out.println(LottoMessage.TYPE_THE_NUMBER);
            while (!in.hasNext()) {
                System.out.printf(LottoMessage.NUMBER_NOT_IN_RANGE, LOWEST_NUMBER, HIGHEST_NUMBER);
                if (!in.hasNext()) {
                    return Collections.emptySet();
                }
            }
            final int userInput = in.nextInt();
            getValidateNumber(givenNumbers, userInput);
        }
        return givenNumbers;
    }

    private void getValidateNumber(Set<Integer> givenNumbers, int userInput) {
        if (isInRange(userInput)) {
            givenNumbers.add(userInput);
        } else {
            System.out.printf(LottoMessage.GIVEN_NUMBER_NOT_IN_RANGE, userInput, LOWEST_NUMBER, HIGHEST_NUMBER);
        }
    }

    private boolean areLessThanSixNumbersGiven(Set<Integer> numbers) {
        return numbers.size() < TOTAL_FROM_USER;
    }

    private static boolean isInRange(int givenNumber) {
        return givenNumber >= LOWEST_NUMBER && givenNumber <= HIGHEST_NUMBER;
    }
}
