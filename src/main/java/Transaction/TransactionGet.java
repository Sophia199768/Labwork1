package Transaction;

import Account.AccountInterface;
import Account.StrategyInterface;
import Result.SuccessGetMoney;

public class TransactionGet implements TransactionInterface {
    private StrategyInterface strategyFrom;
    private int amountOfMoney;
    private AccountInterface accountFrom;

    public TransactionGet(StrategyInterface _strategyFrom,
                           int _amountOfMoney,
                           AccountInterface _accountFrom) {
        strategyFrom = _strategyFrom;
        accountFrom = _accountFrom;
        amountOfMoney = _amountOfMoney;
    }
    @Override
    public void madeTransaction() {
        if (strategyFrom.getMoney(amountOfMoney, accountFrom) instanceof SuccessGetMoney) {
            strategyFrom.getMoney(amountOfMoney, accountFrom);
        }
    }

    @Override
    public void canselTransaction() {
        accountFrom.restore();
    }
}
