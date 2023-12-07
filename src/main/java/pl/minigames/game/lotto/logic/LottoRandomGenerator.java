package pl.minigames.game.lotto.logic;

import java.security.SecureRandom;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.minigames.game.lotto.controller.LottoGameController.*;

public class LottoRandomGenerator {
    public Set<Integer> getRandomSixNumbers() {
        SecureRandom random = new SecureRandom();
        return random.ints(GENERATED_NUMBERS, UNIQUE_NUMBER, TOTAL_NUMBERS)
                .boxed()
                .collect(Collectors.toSet());
    }
}