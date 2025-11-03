package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외 발생")
    void invalidSizeThrowsException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_INVALID_SIZE);
    }

    @Test
    @DisplayName("중복된 번호가 있으면 예외 발생")
    void duplicateNumbersThrowsException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_DUPLICATE_LOTTO);
    }

    @Test
    @DisplayName("1~45 범위를 벗어나면 예외 발생")
    void outOfRangeThrowsException() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_RANGE);
    }

    @Test
    @DisplayName("로또 번호는 정렬되어 반환된다")
    void lottoNumbersAreSorted() {
        Lotto lotto = new Lotto(List.of(8, 1, 10, 3, 7, 2));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 7, 8, 10);
    }
}