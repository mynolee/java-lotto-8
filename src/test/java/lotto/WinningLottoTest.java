package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호에 중복이 있으면 예외 발생")
    void duplicateWinningNumbersThrowsException() {
        String[] nums = {"1", "2", "3", "3", "4", "5"};
        assertThatThrownBy(() -> new WinningLotto(nums, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_DUPLICATE_WINNING);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 발생")
    void duplicateBonusThrowsException() {
        String[] nums = {"1", "2", "3", "4", "5", "6"};
        assertThatThrownBy(() -> new WinningLotto(nums, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ERROR_DUPLICATE_BONUS);
    }

    @Test
    @DisplayName("정상 생성 시 번호는 정렬되어 저장된다")
    void sortedWinningNumbers() {
        String[] nums = {"6", "3", "1", "4", "2", "5"};
        WinningLotto lotto = new WinningLotto(nums, 7);
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}