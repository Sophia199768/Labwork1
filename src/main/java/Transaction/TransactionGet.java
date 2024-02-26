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
