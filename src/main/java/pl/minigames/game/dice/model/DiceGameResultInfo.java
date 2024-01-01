package pl.minigames.game.dice.model;

import lombok.Data;
import pl.minigames.game.dice.messageprovider.DiceMessageProvider;
import pl.minigames.model.GameResultInfo;

import java.util.Set;

@Data
public class DiceGameResultInfo implements GameResultInfo {
    private final Set<Integer> userGivenNumbers;
    private final Set<Integer> randomSixNumbers;
    private final Set<Integer> finalHitNumbers;

    @Override
    public String getGameResultMessage() {
        return String.format(DiceMessageProvider.DICE_GAME_OVER, finalHitNumbers.size(), randomSixNumbers, userGivenNumbers);
    }
}
