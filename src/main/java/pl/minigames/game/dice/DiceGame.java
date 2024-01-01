package pl.minigames.game.dice;

import lombok.Data;
import pl.minigames.game.Game;
import pl.minigames.game.dice.input.DiceInputReceiver;
import pl.minigames.game.dice.logic.DiceHitNumbersCalculator;
import pl.minigames.game.dice.logic.DiceRandomGenerator;
import pl.minigames.game.dice.messageprovider.DiceMessageProvider;
import pl.minigames.model.GameResult;
import pl.minigames.model.GameResultInfo;

import java.util.Scanner;
import java.util.Set;

import static pl.minigames.game.dice.messageprovider.DiceMessageProvider.ROLL_THE_DICE;

@Data
public class DiceGame implements Game {
    private final DiceInputReceiver diceInputReceiver;
    private final DiceRandomGenerator randomGenerator;
    private final DiceHitNumbersCalculator diceHitNumbersCalculator;
    private final Scanner scanner;

    public GameResult startGame() {
        System.out.println(String.format(DiceMessageProvider.GAME_NAME, ROLL_THE_DICE));
        final GameResultInfo gameResultInfo = getHitNumbers();
        return getGameResult(gameResultInfo);
    }

    private GameResultInfo getHitNumbers() {
        final Set<Integer> inputNumbers = diceInputReceiver.getSixNumbers(scanner);
        final Set<Integer> randomNumbers = randomGenerator.getRandomSixNumbers();
        return diceHitNumbersCalculator.getHitNumbers(inputNumbers, randomNumbers);
    }

    private GameResult getGameResult(GameResultInfo gameResultInfo) {
        final GameResult gameResult = new GameResult(this, gameResultInfo);
        System.out.println(gameResult.getGameResultInfo().getGameResultMessage());
        return gameResult;
    }

}
