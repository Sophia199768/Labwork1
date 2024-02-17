package Transaction;

import Account.AccountInterface;
import Account.StrategyInterface;
import Result.SuccessGetMoney;

public class TransactionSend implements TransactionInterface {
    private StrategyInterface strategyFrom;
    private StrategyInterface strategyTo;
    private int amountOfMoney;
    private AccountInterface accountFrom;
    private AccountInterface accountTo;

    public TransactionSend(StrategyInterface _strategyFrom,
                           StrategyInterface _strategyTo,
                           int _amountOfMoney,
                           AccountInterface _accountFrom,
                           AccountInterface _accountTo) {
        strategyFrom = _strategyFrom;
        strategyTo = _strategyTo;
        accountFrom = _accountFrom;
        accountTo = _accountTo;
        amountOfMoney = _amountOfMoney;
    }

    @Override
    public void madeTransaction() {
        if (strategyFrom.getMoney(amountOfMoney, accountFrom) instanceof SuccessGetMoney) {
            strategyTo.setMoney(amountOfMoney, accountTo);
        }
    }

    @Override
    public void canselTransaction() {
        accountFrom.restore();
        accountTo.restore();
    }
}
