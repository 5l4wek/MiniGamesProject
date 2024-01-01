package pl.minigames;

import pl.minigames.game.Game;
import pl.minigames.game.dice.DiceGame;
import pl.minigames.game.dice.input.DiceInputReceiver;
import pl.minigames.game.dice.logic.DiceHitNumbersCalculator;
import pl.minigames.game.dice.logic.DiceRandomGenerator;
import pl.minigames.game.lotto.input.LottoInputReceiver;
import pl.minigames.game.lotto.logic.LottoHitNumberCalculator;
import pl.minigames.game.lotto.logic.LottoRandomGenerator;
import pl.minigames.game.lotto.LottoGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

//        final Game lottoGame = getLottoGame();
//        lottoGame.startGame();

        final Game diceGame = getDiceGame();
        diceGame.startGame();
    }

    private static Game getLottoGame() {
        final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();
        final LottoRandomGenerator randomGenerator = new LottoRandomGenerator();
        final LottoHitNumberCalculator lottoHitNumberCalculator = new LottoHitNumberCalculator();
        final Scanner scanner = new Scanner(System.in);
        return new LottoGame(lottoInputReceiver, randomGenerator, lottoHitNumberCalculator, scanner);
    }

    private static Game getDiceGame() {
        final DiceInputReceiver diceInputReceiver = new DiceInputReceiver();
        final DiceRandomGenerator diceRandomGenerator = new DiceRandomGenerator();
        final DiceHitNumbersCalculator diceHitNumbersCalculator = new DiceHitNumbersCalculator();
        final Scanner scanner = new Scanner(System.in);
        return new DiceGame(diceInputReceiver, diceRandomGenerator, diceHitNumbersCalculator, scanner);
    }
}
