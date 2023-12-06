package pl.minigames.lotto.main;

import pl.minigames.lotto.logic.RandomNumberGenerator;

public class MiniGamesApplication {
    public static void main(String[] args) {
        System.out.println("Hello!");

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Double random = randomNumberGenerator.generateRandomNumber();
        System.out.println(random);
    }
}