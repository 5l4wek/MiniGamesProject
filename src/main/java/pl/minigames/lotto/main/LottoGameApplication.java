package pl.minigames.lotto.main;

import pl.minigames.lotto.logic.LottoNumberGenerator;

public class LottoGameApplication {
    public static void main(String[] args) {
        System.out.println("Hello!");

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        Double random = lottoNumberGenerator.generateRandomNumber();
        System.out.println(random);
    }
}