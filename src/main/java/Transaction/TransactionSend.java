package Transaction;

import Account.AccountInterface;
import Account.StrategyInterface;
import Result.ResultInterface;

public class TransactionSend implements TransactionInterface {
    private StrategyInterface strategyFrom;
    private StrategyInterface strategyTo;
    private Integer amountOfMoney;
    private AccountInterface accountFrom;
    private AccountInterface accountTo;

    public TransactionSend(StrategyInterface strategyFrom,
                           StrategyInterface strategyTo,
                           Integer amountOfMoney,
                           AccountInterface accountFrom,
                           AccountInterface accountTo) {
        this.strategyFrom = strategyFrom;
        this.strategyTo = strategyTo;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amountOfMoney = amountOfMoney;
    }

    /**
     * <p>
     *   madeTransaction
     *   Function to make a transaction of send.
     *   When user wants to send money from one account to another.
     * </p>
     */
    @Override
    public ResultInterface madeTransaction() {
           return strategyTo.setMoney(amountOfMoney, accountTo);
    }

    /**
     * <p>
     *   canselTransaction
     *   Function to cansel transaction
     *   If user wants to cansel his send transaction
     * </p>
     */
    @Override
    public void canselTransaction() {
        accountFrom.restore();
        accountTo.restore();
    }
}
