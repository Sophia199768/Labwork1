package Account;

import Result.ResultInterface;

public interface StrategyInterface {
    ResultInterface getMoney(int _amountOfMoney, AccountInterface account);
    ResultInterface setMoney(int _amountOfMoney, AccountInterface account);
}
