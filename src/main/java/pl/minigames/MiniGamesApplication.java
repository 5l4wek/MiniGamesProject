package pl.minigames;

public class MiniGamesApplication {
    public static void main(String[] args) {
        System.out.println("Hello!");

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Double random = randomNumberGenerator.generateRandomNumber();
        System.out.println(random);
    }
}