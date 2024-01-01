package pl.minigames.model;

import lombok.Data;
import pl.minigames.game.Game;

@Data
public class GameResult {
    private final Game game;
    private final GameResultInfo gameResultInfo;

}
