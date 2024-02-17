package Account;

import Result.ResultInterface;

public interface DebitDepositAccountInterface  extends AccountInterface {
    void addProcent();
    void changeProcent(double newProcent);
    void countProcentMoney();
}
