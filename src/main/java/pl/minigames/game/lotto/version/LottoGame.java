package pl.minigames.game.lotto.version;

import lombok.Data;
import pl.minigames.game.lotto.input.LottoInputReceiver;
import pl.minigames.game.lotto.logic.LottoHitNumberCalculator;
import pl.minigames.game.lotto.message.LottoMessage;
import pl.minigames.game.lotto.Game;
import pl.minigames.game.lotto.logic.LottoRandomGenerator;
import pl.minigames.model.GameResultInfo;
import pl.minigames.model.GameResult;

import java.util.Scanner;
import java.util.Set;

@Data
public class LottoGame implements Game {
    private final LottoInputReceiver lottoInputReceiver;
    private final LottoRandomGenerator randomGenerator;
    private final LottoHitNumberCalculator lottoHitNumberCalculator;
    private final Scanner scanner;

    public GameResult startGame() {
        System.out.println(String.format(LottoMessage.THE_GAME_HAS_STARTED, LottoMessage.THE_GAME_NAME));
        final GameResultInfo gameResultInfo = getHitNumbers();
        return getGameResult(gameResultInfo);
    }

    private GameResultInfo getHitNumbers() {
        final Set<Integer> inputNumbers = lottoInputReceiver.getRandomNumbers(scanner);
        final Set<Integer> randomNumbers = randomGenerator.getRandomSixNumbers();
        return lottoHitNumberCalculator.getHitNumbers(inputNumbers, randomNumbers);
    }

    private GameResult getGameResult(GameResultInfo gameResultInfo) {
        final GameResult gameResult = new GameResult(this, gameResultInfo);
        System.out.println(gameResult.getGameResultInfo().getGameResultMessage());
        return gameResult;
    }
}
