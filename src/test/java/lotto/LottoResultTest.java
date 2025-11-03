package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

class LottoResultTest {

    @Test
    @DisplayName("각 로또의 등수 계산이 정확하게 이루어진다")
    void calculateEachRank() {
        WinningLotto winning = new WinningLotto(
                new String[]{"1", "2", "3", "4", "5", "6"}, 7);

        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),     // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),     // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),     // 3등
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),   // 4등
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),  // 5등
                new Lotto(List.of(10, 11, 12, 13, 14, 15)) // 없음
        );

        LottoResult result = new LottoResult(winning, tickets);
        Map<Rank, Integer> summary = result.calculate();

        assertThat(summary.get(Rank.FIRST)).isEqualTo(1);
        assertThat(summary.get(Rank.SECOND)).isEqualTo(1);
        assertThat(summary.get(Rank.THIRD)).isEqualTo(1);
        assertThat(summary.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(summary.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(summary.get(Rank.NONE)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익률 계산이 정확하다")
    void profitRateCalculation() {
        WinningLotto winning = new WinningLotto(
                new String[]{"1", "2", "3", "4", "5", "6"}, 7);
        List<Lotto> tickets = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        LottoResult result = new LottoResult(winning, tickets);
        double rate = result.calculateProfitRate(Constants.LOTTO_PRICE);

        assertThat(rate).isEqualTo(200000000.0);
    }
}