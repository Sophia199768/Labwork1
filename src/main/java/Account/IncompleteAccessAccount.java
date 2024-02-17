package Account;

import Result.ResultInterface;
import Result.UnSafeAccount;
import User.IncompleteAccessUser;

public class IncompleteAccessAccount implements StrategyInterface {
    private int limit;

    public IncompleteAccessAccount(int _limit) {
        limit = _limit;
    }

    @Override
    public ResultInterface getMoney(int _amountOfMoney, AccountInterface account) {
        if (_amountOfMoney <= limit) {
            return account.getMoney(_amountOfMoney);
        }
        return new UnSafeAccount("You can't get so much money");
    }

    @Override
    public ResultInterface setMoney(int _amountOfMoney, AccountInterface account) {
        if (_amountOfMoney <= limit) {
            return account.setMoney(_amountOfMoney);
        }
        return new UnSafeAccount("You can't get so much money");
    }
}
