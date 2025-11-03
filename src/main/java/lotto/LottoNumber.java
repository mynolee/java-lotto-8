package lotto;

public class LottoNumber {

    public LottoNumber(int number) {
        validate(number);
    }

    private void validate(int number) {
        if (number < Constants.LOTTO_MIN_NUMBER || number > Constants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(Message.ERROR_RANGE);
        }
    }
}
