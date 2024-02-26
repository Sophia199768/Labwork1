package Transaction;

import Account.AccountInterface;
import Account.StrategyInterface;
import Result.SuccessGetMoney;

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
