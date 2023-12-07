package pl.minigames.game.lotto.version;

import lombok.Data;
import pl.minigames.game.lotto.message.LottoMessage;
import pl.minigames.model.GameResultInfo;

import java.util.Set;

@Data
public class LottoGameResultInfo implements GameResultInfo {
    private final Set<Integer> userGivenNumbers;
    private final Set<Integer> randomSixNumbers;
    private final Set<Integer> finalHitNumbers;


    @Override
    public String getGameResultMessage() {
        return String.format(LottoMessage.GAME_RESULT, finalHitNumbers.size(), randomSixNumbers, userGivenNumbers);
    }
}
