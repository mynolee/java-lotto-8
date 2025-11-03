package lotto;

public final class Message {
    private Message() {
    }

    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String OUTPUT_RESULT_HEADER = "\n당첨 통계\n---";

    public static final String ERROR_INVALID_AMOUNT = "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.";
    public static final String ERROR_NOT_NUMBER = "[ERROR] 숫자를 입력해야 합니다.";
    public static final String ERROR_DUPLICATE_WINNING = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    public static final String ERROR_DUPLICATE_BONUS = "[ERROR] 보너스 번호는 중복될 수 없습니다.";
    public static final String ERROR_INVALID_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String ERROR_DUPLICATE_LOTTO = "[ERROR] 로또 번호는 중복되면 안 됩니다.";
    public static final String ERROR_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
}
