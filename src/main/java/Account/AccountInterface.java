package Account;

import Result.ResultInterface;

public interface AccountInterface {
    ResultInterface setMoney(Integer setMoneyAmount);
    ResultInterface getMoney(Integer getMoneyAmount);
    void restore();
}
