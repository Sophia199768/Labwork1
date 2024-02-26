package Account;

import Result.ResultInterface;

public interface DebitDepositAccountInterface  extends AccountInterface {
    void addProcent();
    void changeProcent(Integer newProcent);
    void countProcentMoney();
}
