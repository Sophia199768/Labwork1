package Transaction;

import Account.AccountInterface;
import Account.StrategyInterface;

public class TransactionSet implements TransactionInterface {
    private StrategyInterface strategyTo;
    private int amountOfMoney;
    private AccountInterface accountTo;

    public TransactionSet(
                           StrategyInterface _strategyTo,
                           int _amountOfMoney,
                           AccountInterface _accountTo) {
        strategyTo = _strategyTo;
        accountTo = _accountTo;
        amountOfMoney = _amountOfMoney;
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
