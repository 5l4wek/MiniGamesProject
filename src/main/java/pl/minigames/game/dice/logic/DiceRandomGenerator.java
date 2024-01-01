package pl.minigames.game.dice.logic;

import java.security.SecureRandom;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.minigames.game.dice.config.DiceGameConfiguration.*;

public class DiceRandomGenerator {
    public Set<Integer> getRandomSixNumbers() {
        SecureRandom random = new SecureRandom();
        return random.ints(NUMBERS_TO_GENERATE, NUMBER_ORIGIN, RANDOM_NUMBER_BOUND)
                .boxed()
                .collect(Collectors.toSet());
    }
}
