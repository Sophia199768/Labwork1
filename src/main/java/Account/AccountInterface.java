package Account;

import Result.ResultInterface;

public interface AccountInterface {
    ResultInterface setMoney(int setMoneyAmount);
    ResultInterface getMoney(int getMoneyAmount);
    void restore();
}
