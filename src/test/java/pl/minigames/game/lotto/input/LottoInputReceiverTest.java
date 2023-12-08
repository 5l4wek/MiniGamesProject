package pl.minigames.game.lotto.input;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class LottoInputReceiverTest {
    LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();

    @Test
    void shouldReturnNumbersInSetWhenAllInRange() {
        //given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        String givenNumbers = "1 2 3 4 5 101 6";
        Scanner userNumbers = mockScannerIn(givenNumbers);
        //when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getRandomNumbers(userNumbers);
        //then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);
    }

    @Test
    void shouldReturnNumberInSetWhenOneNotInRange() {
        //given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 15)));
        String givenNumbers = "1 2 3 4 5 101 15";
        Scanner scanner = mockScannerIn(givenNumbers);
        //when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getRandomNumbers(scanner);
        //then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);
    }

    @Test
    void shouldReturnZeroNumbersInSetWhenAllNotInRange() {
        //given
        Set<Integer> expectedNumbers = Collections.emptySet();
        String givenNumbers = "0 -1 103 103 104 105 106";
        Scanner scanner = mockScannerIn(givenNumbers);
        //when
        final Set<Integer> userInputNumbers = lottoInputReceiver.getRandomNumbers(scanner);
        //then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);
    }

    @Test
    void shouldThrowExceptionWhenUserGave() {
        //given
        String givenNumbers = "1 2 3 4 5 6 X Y Z ";
        Scanner scanner = mockScannerIn(givenNumbers);
        //when
        Throwable throwable = catchThrowable(() -> lottoInputReceiver.getRandomNumbers(scanner));
        //then
        assertThat(throwable.getMessage()).isEqualTo("");
    }

    private static Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }
}
