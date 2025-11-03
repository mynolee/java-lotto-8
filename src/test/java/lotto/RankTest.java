package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("6개 일치 시 1등")
    void firstRank() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 + 보너스 일치 시 2등")
    void secondRank() {
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개만 일치 시 3등")
    void thirdRank() {
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 일치 시 4등")
    void fourthRank() {
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개 일치 시 5등")
    void fifthRank() {
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하 일치 시 NONE")
    void noneRank() {
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NONE);
    }

    @Test
    @DisplayName("상금 순서대로 정렬 확인")
    void orderByPrize() {
        var ordered = Rank.valuesInOrder();
        assertThat(ordered.get(0)).isEqualTo(Rank.FIRST);
        assertThat(ordered.get(ordered.size() - 1)).isEqualTo(Rank.NONE);
    }
}