package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningLotto(String[] numbers, int bonus) {
        this.numbers = parseAndValidate(numbers);
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private List<Integer> parseAndValidate(String[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (String s : numbers) {
            int num = Integer.parseInt(s.trim());
            new LottoNumber(num);
            if (list.contains(num)) {
                throw new IllegalArgumentException(Message.ERROR_DUPLICATE_WINNING);
            }
            list.add(num);
        }
        Collections.sort(list);
        return list;
    }

    private void validateBonus(int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE_BONUS);
        }
        new LottoNumber(bonus);
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}