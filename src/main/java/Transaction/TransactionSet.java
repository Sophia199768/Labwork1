package Transaction;

import Account.AccountInterface;
import Account.StrategyInterface;

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

    @Override
    public void madeTransaction() {
        strategyTo.setMoney(amountOfMoney, accountTo);
    }

    @Override
    public void canselTransaction() {
        accountTo.restore();
    }
}
