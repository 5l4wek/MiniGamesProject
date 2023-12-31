package pl.minigames.game.dice.input;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiceInputReceiverTest {
    DiceInputReceiver diceInputReceiver = new DiceInputReceiver();

    @Test
    void shouldReturnWinWhenDiceMatch() {
        //given
        int[] firstDiceExpectedNumbers = new int[]{1,2,3,4,5,6};

        String givenNumbers = "1 2 3 4 5 6";
        Scanner userNumbers = mockScannerIn(givenNumbers);
        //when
        final int userRolledNumbers;
        //then
//        assertThat(firstDiceExpectedNumbers).isEqualTo(userRolledNumbers);
    }
    private Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }
}
