package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final WinningLotto winningLotto;
    private final List<Lotto> purchasedLottos;

    public LottoResult(WinningLotto winningLotto, List<Lotto> purchasedLottos) {
        this.winningLotto = winningLotto;
        this.purchasedLottos = purchasedLottos;
    }

    public Map<Rank, Integer> calculate() {
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : purchasedLottos) {
            Rank rank = evaluateRank(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private Rank evaluateRank(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        boolean hasBonus = lotto.getNumbers().contains(winningLotto.getBonus());
        return Rank.of(matchCount, hasBonus);
    }

    public double calculateProfitRate(int purchaseAmount) {
        Map<Rank, Integer> result = calculate();
        int totalPrize = result.entrySet().stream()
                .mapToInt(e -> e.getKey().getPrize() * e.getValue())
                .sum();
        double rate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(rate * 10) / 10.0;
    }
}