package Account;

public interface DebitDepositAccountInterface  extends AccountInterface {
    void addProcent();
    void changeProcent(Integer newProcent);
    void countProcentMoney();
}
