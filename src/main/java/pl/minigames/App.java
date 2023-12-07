package pl.minigames;

import pl.minigames.game.lotto.Game;
import pl.minigames.game.lotto.inset.LottoInsetFromUser;
import pl.minigames.game.lotto.logic.LottoHitNumberCalculator;
import pl.minigames.game.lotto.logic.LottoRandomGenerator;
import pl.minigames.game.lotto.version.LottoGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Game lottoGame = getLottoGame();
        lottoGame.startGame();
    }

    private static Game getLottoGame() {
        final LottoInsetFromUser lottoInsetFromUser = new LottoInsetFromUser();
        final LottoRandomGenerator randomGenerator = new LottoRandomGenerator();
        final LottoHitNumberCalculator lottoHitNumberCalculator = new LottoHitNumberCalculator();
        final Scanner scanner = new Scanner(System.in);
        return new LottoGame(lottoInsetFromUser, randomGenerator, lottoHitNumberCalculator, scanner);
    }
}
