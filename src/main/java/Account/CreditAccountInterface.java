package Account;

import Result.ResultInterface;

public interface CreditAccountInterface extends AccountInterface {
    void changeProcent(double newProcent);
    void addComission();
    void setProcentToOverdraft(Double procentToOverdraft);
}
