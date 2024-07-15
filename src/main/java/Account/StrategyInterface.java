package Account;

import Result.ResultInterface;

public interface StrategyInterface {
    ResultInterface getMoney(Integer amountOfMoney, AccountInterface account);
    ResultInterface setMoney(Integer amountOfMoney, AccountInterface account);
}
