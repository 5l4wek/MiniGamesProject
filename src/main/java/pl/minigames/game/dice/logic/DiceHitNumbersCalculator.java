package pl.minigames.game.dice.logic;

import pl.minigames.game.dice.model.DiceGameResultInfo;

import java.util.HashSet;
import java.util.Set;

public class DiceHitNumbersCalculator {
    public DiceGameResultInfo getHitNumbers(Set<Integer> userGivenNumbers, Set<Integer> randomSixNumbers) {
        Set<Integer> finalHitNumbers = new HashSet<>(userGivenNumbers);
        finalHitNumbers.retainAll(randomSixNumbers);
        return new DiceGameResultInfo(userGivenNumbers, randomSixNumbers, finalHitNumbers);
    }
}
