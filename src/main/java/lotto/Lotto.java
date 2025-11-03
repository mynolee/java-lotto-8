package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(Message.ERROR_INVALID_SIZE);
        }
        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE_LOTTO);
        }
        for (int number : numbers) {
            new LottoNumber(number);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
