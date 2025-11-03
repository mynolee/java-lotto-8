package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class LottoGame {

    public void run() {
        int amount = readPurchaseAmount();
        LottoMachine machine = new LottoMachine();
        List<Lotto> purchasedLottos = machine.purchase(amount);
        printPurchasedLottos(purchasedLottos);

        WinningLotto winningLotto = readWinningLotto();
        LottoResult result = new LottoResult(winningLotto, purchasedLottos);
        printResult(result, amount);
    }

    private int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println(Message.INPUT_PURCHASE_AMOUNT);
                String input = Console.readLine();
                int amount = parseInt(input);
                if (amount % Constants.LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException(Message.ERROR_INVALID_AMOUNT);
                }
                System.out.println((amount / Constants.LOTTO_PRICE) + "개를 구매했습니다.");
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto readWinningLotto() {
        while (true) {
            try {
                System.out.println(Message.INPUT_WINNING_NUMBERS);
                String[] input = Console.readLine().split(",");
                System.out.println(Message.INPUT_BONUS_NUMBER);
                int bonus = parseInt(Console.readLine());
                return new WinningLotto(input, bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private void printResult(LottoResult result, int amount) {
        System.out.println(Message.OUTPUT_RESULT_HEADER);
        Map<Rank, Integer> resultMap = result.calculate();
        for (Rank rank : Rank.valuesInOrder()) {
            if (rank == Rank.NONE) continue;
            System.out.printf("%s - %d개%n", rank.getMessage(), resultMap.getOrDefault(rank, 0));
        }
        double rate = result.calculateProfitRate(amount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_NOT_NUMBER);
        }
    }
}