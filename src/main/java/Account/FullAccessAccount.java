package Account;

import Result.ResultInterface;

public class FullAccessAccount implements StrategyInterface {

    @Override
    public ResultInterface getMoney(int _amountOfMoney, AccountInterface account) {
        return account.getMoney(_amountOfMoney);
    }

    @Override
    public ResultInterface setMoney(int _amountOfMoney, AccountInterface account) {
        return account.setMoney(_amountOfMoney);
    }
}
