package Transaction;

import Account.AccountInterface;
import Account.StrategyInterface;
import Result.ResultInterface;

public class TransactionSet implements TransactionInterface {
    private StrategyInterface strategyTo;
    private Integer amountOfMoney;
    private AccountInterface accountTo;

    public TransactionSet(
                           StrategyInterface strategyTo,
                           Integer amountOfMoney,
                           AccountInterface accountTo) {
        this.strategyTo = strategyTo;
        this.accountTo = accountTo;
        this.amountOfMoney = amountOfMoney;
    }

    /**
     * <p>
     *   madeTransaction
     *   Function to make a transaction of set.
     *   When user wants to set money in one concrete account.
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
     *   If user wants to cansel his set action
     * </p>
     */
    @Override
    public void canselTransaction() {
        accountTo.restore();
    }
}
