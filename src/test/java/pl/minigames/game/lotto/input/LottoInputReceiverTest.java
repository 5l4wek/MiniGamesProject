package pl.minigames.game.lotto.input;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoInputReceiverTest {
    LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();

    @Test
    void shouldReturnNumbersInSetWhenAllInRange() {
        //given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
        String givenNumbers = "1 2 3 4 5 101 6";
        Scanner userNumbers = mockScannerIn(givenNumbers);
        //when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getRandomNumbers(userNumbers);
        //then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);
    }

    @Test
    void shouldReturnZeroNumbersInSetWhenAllNotInRange() {
        //given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1,2,3,4,5,15)));
        String givenNumbers = "1 2 3 4 5 101 15";
        Scanner scanner = mockScannerIn(givenNumbers);
        //when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getRandomNumbers(scanner);
        //then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);

    }

    private static Scanner mockScannerIn(String givenNumbers) {
        return mockScannerIn(givenNumbers);
    }
}
