package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> purchase(int amount) {
        int count = amount / Constants.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    Constants.LOTTO_MIN_NUMBER,
                    Constants.LOTTO_MAX_NUMBER,
                    Constants.LOTTO_SIZE)));
        }
        return lottos;
    }
}
