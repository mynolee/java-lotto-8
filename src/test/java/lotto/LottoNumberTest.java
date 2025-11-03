package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("번호가 1보다 작으면 예외 발생")
    void lessThanOneThrowsException() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_RANGE);
    }

    @Test
    @DisplayName("번호가 45보다 크면 예외 발생")
    void greaterThanFortyFiveThrowsException() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_RANGE);
    }

    @Test
    @DisplayName("정상 범위(1~45)는 생성 가능")
    void validNumberIsAccepted() {
        assertThatCode(() -> new LottoNumber(23))
                .doesNotThrowAnyException();
    }
}