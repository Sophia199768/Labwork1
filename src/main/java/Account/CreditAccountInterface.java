package Account;

public interface CreditAccountInterface extends AccountInterface {
    void changeProcent(double newProcent);
    void addComission();
    void setProcentToOverdraft(Double procentToOverdraft);
}
