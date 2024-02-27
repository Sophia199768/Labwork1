package Transaction;

import Account.AccountInterface;
import Account.StrategyInterface;
import Result.SuccessGetMoney;

public class TransactionGet implements TransactionInterface {
    private StrategyInterface strategyFrom;
    private Integer amountOfMoney;
    private AccountInterface accountFrom;

    public TransactionGet(StrategyInterface strategyFrom,
                          Integer amountOfMoney,
                          AccountInterface accountFrom) {
        this.strategyFrom = strategyFrom;
        this.accountFrom = accountFrom;
        this.amountOfMoney = amountOfMoney;
    }

    /**
     * <p>
     *   madeTransaction
     *   Function to make a transaction of get.
     *   When user wants to get money from account this transaction is starting to execute
     * </p>
     */
    @Override
    public void madeTransaction() {
        if (strategyFrom.getMoney(amountOfMoney, accountFrom) instanceof SuccessGetMoney) {
            strategyFrom.getMoney(amountOfMoney, accountFrom);
        }
    }

    /**
     * <p>
     *   canselTransaction
     *   Function to cansel transaction
     *   If user wants to cansel his get action
     * </p>
     */
    @Override
    public void canselTransaction() {
        accountFrom.restore();
    }
}
